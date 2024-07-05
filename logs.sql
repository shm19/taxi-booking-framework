-- user_activity_analytics.sql
-- Total number of user actions
SELECT COUNT(*) AS total_actions
FROM user_logs;
-- User actions grouped by type
SELECT action,
  COUNT(*) AS action_count
FROM user_logs
GROUP BY action
ORDER BY action_count DESC;
-- Most active users
SELECT username,
  COUNT(*) AS action_count
FROM user_logs
GROUP BY username
ORDER BY action_count DESC
LIMIT 10;
-- User actions over time (daily)
SELECT DATE(timestamp) AS date,
  COUNT(*) AS daily_actions
FROM user_logs
GROUP BY date
ORDER BY date DESC;
-- Peak activity hours
SELECT strftime('%H', timestamp) AS hour,
  COUNT(*) AS hourly_actions
FROM user_logs
GROUP BY hour
ORDER BY hourly_actions DESC;
-- Bookings made each day
SELECT DATE(timestamp) AS date,
  COUNT(*) AS daily_bookings
FROM user_logs
WHERE action = 'create booking'
GROUP BY date
ORDER BY date DESC;
-- Login attempts over the last week
SELECT DATE(timestamp) AS date,
  COUNT(*) AS login_attempts
FROM user_logs
WHERE action = 'login'
  AND timestamp >= date('now', '-7 days')
GROUP BY date
ORDER BY date DESC;
-- User actions in the last month
SELECT username,
  COUNT(*) AS action_count
FROM user_logs
WHERE timestamp >= date('now', '-1 month')
GROUP BY username
ORDER BY action_count DESC;
-- Action types by user
SELECT username,
  action,
  COUNT(*) AS action_count
FROM user_logs
GROUP BY username,
  action
ORDER BY username,
  action_count DESC;
-- Most active days of the week
SELECT strftime('%w', timestamp) AS day_of_week,
  COUNT(*) AS weekly_actions
FROM user_logs
GROUP BY day_of_week
ORDER BY weekly_actions DESC;
-- Hourly booking trends
SELECT strftime('%H', timestamp) AS hour,
  COUNT(*) AS hourly_bookings
FROM user_logs
WHERE action = 'create booking'
GROUP BY hour
ORDER BY hour;
-- Top actions by specific user
SELECT action,
  COUNT(*) AS action_count
FROM user_logs
WHERE username = 'specific_user'
GROUP BY action
ORDER BY action_count DESC;
-- Average number of actions per user
SELECT AVG(action_count) AS avg_actions_per_user
FROM (
    SELECT username,
      COUNT(*) AS action_count
    FROM user_logs
    GROUP BY username
  );
-- Users with more than 10 actions
SELECT username,
  COUNT(*) AS action_count
FROM user_logs
GROUP BY username
HAVING action_count > 10
ORDER BY action_count DESC;
-- Distribution of actions over the past month
SELECT DATE(timestamp) AS date,
  action,
  COUNT(*) AS action_count
FROM user_logs
WHERE timestamp >= date('now', '-1 month')
GROUP BY date,
  action
ORDER BY date,
  action_count DESC;
-- Average time between actions per user
SELECT username,
  AVG(action_interval) AS avg_time_between_actions
FROM (
    SELECT username,
      timestamp - LAG(timestamp, 1) OVER (
        PARTITION BY username
        ORDER BY timestamp
      ) AS action_interval
    FROM user_logs
  )
WHERE action_interval IS NOT NULL
GROUP BY username;
-- Most frequent action sequences
SELECT action_sequence,
  COUNT(*) AS sequence_count
FROM (
    SELECT username,
      action || ' -> ' || LEAD(action, 1) OVER (
        PARTITION BY username
        ORDER BY timestamp
      ) AS action_sequence
    FROM user_logs
  )
WHERE action_sequence IS NOT NULL
GROUP BY action_sequence
ORDER BY sequence_count DESC;
-- User retention rate based on repeated logins
SELECT COUNT(DISTINCT username) AS total_users,
  COUNT(
    DISTINCT CASE
      WHEN action = 'login' THEN username
    END
  ) AS retained_users,
  (
    COUNT(
      DISTINCT CASE
        WHEN action = 'login' THEN username
      END
    ) * 1.0 / COUNT(DISTINCT username)
  ) * 100 AS retention_rate
FROM user_logs
WHERE action IN ('login', 'signup');
-- Actions leading to cancellations
SELECT previous_action,
  COUNT(*) AS action_count
FROM (
    SELECT username,
      LAG(action, 1) OVER (
        PARTITION BY username
        ORDER BY timestamp
      ) AS previous_action
    FROM user_logs
    WHERE action = 'cancel booking'
  )
WHERE previous_action IS NOT NULL
GROUP BY previous_action
ORDER BY action_count DESC;
-- Monthly active users (MAU)
SELECT strftime('%Y-%m', timestamp) AS month,
  COUNT(DISTINCT username) AS monthly_active_users
FROM user_logs
GROUP BY month
ORDER BY month DESC;
-- Weekly active users (WAU)
SELECT strftime('%Y-%W', timestamp) AS week,
  COUNT(DISTINCT username) AS weekly_active_users
FROM user_logs
GROUP BY week
ORDER BY week DESC;
-- Daily active users (DAU)
SELECT DATE(timestamp) AS date,
  COUNT(DISTINCT username) AS daily_active_users
FROM user_logs
GROUP BY date
ORDER BY date DESC;
-- Correlation between actions and user ratings
SELECT action,
  AVG(rating) AS avg_rating
FROM user_logs
  JOIN user_ratings ON user_logs.username = user_ratings.username
GROUP BY action
ORDER BY avg_rating DESC;
-- User actions leading to high ratings
SELECT previous_action,
  AVG(rating) AS avg_rating
FROM (
    SELECT user_ratings.username,
      rating,
      LAG(action, 1) OVER (
        PARTITION BY user_ratings.username
        ORDER BY timestamp
      ) AS previous_action
    FROM user_logs
      JOIN user_ratings ON user_logs.username = user_ratings.username
  )
WHERE previous_action IS NOT NULL
GROUP BY previous_action
ORDER BY avg_rating DESC;
-- Time to first action after signup
SELECT username,
  MIN(timestamp) - MIN(
    CASE
      WHEN action = 'signup' THEN timestamp
    END
  ) AS time_to_first_action
FROM user_logs
GROUP BY username
HAVING MIN(
    CASE
      WHEN action = 'signup' THEN timestamp
    END
  ) IS NOT NULL;