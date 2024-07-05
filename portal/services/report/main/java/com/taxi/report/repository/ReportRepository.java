package com.taxi.report.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReportRepository extends CrudRepository<Object, Long> {

    @Query(value = "SELECT COUNT(*) AS total_actions FROM user_logs", nativeQuery = true)
    Map<String, Object> totalActions();

    @Query(value = "SELECT action, COUNT(*) AS action_count FROM user_logs GROUP BY action ORDER BY action_count DESC", nativeQuery = true)
    List<Map<String, Object>> actionsGroupedByType();

    @Query(value = "SELECT username, COUNT(*) AS action_count FROM user_logs GROUP BY username ORDER BY action_count DESC LIMIT 10", nativeQuery = true)
    List<Map<String, Object>> mostActiveUsers();

    @Query(value = "SELECT DATE(timestamp) AS date, COUNT(*) AS daily_actions FROM user_logs GROUP BY date ORDER BY date DESC", nativeQuery = true)
    List<Map<String, Object>> userActionsOverTime();

    @Query(value = "SELECT strftime('%H', timestamp) AS hour, COUNT(*) AS hourly_actions FROM user_logs GROUP BY hour ORDER BY hourly_actions DESC", nativeQuery = true)
    List<Map<String, Object>> peakActivityHours();

    @Query(value = "SELECT DATE(timestamp) AS date, COUNT(*) AS daily_bookings FROM user_logs WHERE action = 'create booking' GROUP BY date ORDER BY date DESC", nativeQuery = true)
    List<Map<String, Object>> bookingsMadeEachDay();

    @Query(value = "SELECT DATE(timestamp) AS date, COUNT(*) AS login_attempts FROM user_logs WHERE action = 'login' AND timestamp >= date('now', '-7 days') GROUP BY date ORDER BY date DESC", nativeQuery = true)
    List<Map<String, Object>> loginAttemptsLastWeek();

    @Query(value = "SELECT username, COUNT(*) AS action_count FROM user_logs WHERE timestamp >= date('now', '-1 month') GROUP BY username ORDER BY action_count DESC", nativeQuery = true)
    List<Map<String, Object>> userActionsLastMonth();

    @Query(value = "SELECT username, action, COUNT(*) AS action_count FROM user_logs GROUP BY username, action ORDER BY username, action_count DESC", nativeQuery = true)
    List<Map<String, Object>> actionTypesByUser();

    @Query(value = "SELECT strftime('%w', timestamp) AS day_of_week, COUNT(*) AS weekly_actions FROM user_logs GROUP BY day_of_week ORDER BY weekly_actions DESC", nativeQuery = true)
    List<Map<String, Object>> mostActiveDaysOfWeek();

    @Query(value = "SELECT strftime('%H', timestamp) AS hour, COUNT(*) AS hourly_bookings FROM user_logs WHERE action = 'create booking' GROUP BY hour ORDER BY hour", nativeQuery = true)
    List<Map<String, Object>> hourlyBookingTrends();

    @Query(value = "SELECT action, COUNT(*) AS action_count FROM user_logs WHERE username = 'specific_user' GROUP BY action ORDER BY action_count DESC", nativeQuery = true)
    List<Map<String, Object>> topActionsBySpecificUser();

    @Query(value = "SELECT AVG(action_count) AS avg_actions_per_user FROM (SELECT username, COUNT(*) AS action_count FROM user_logs GROUP BY username)", nativeQuery = true)
    Map<String, Object> avgActionsPerUser();

    @Query(value = "SELECT username, COUNT(*) AS action_count FROM user_logs GROUP BY username HAVING action_count > 10 ORDER BY action_count DESC", nativeQuery = true)
    List<Map<String, Object>> usersWithMoreThanTenActions();

    @Query(value = "SELECT DATE(timestamp) AS date, action, COUNT(*) AS action_count FROM user_logs WHERE timestamp >= date('now', '-1 month') GROUP BY date, action ORDER BY date, action_count DESC", nativeQuery = true)
    List<Map<String, Object>> distributionOfActionsPastMonth();

    @Query(value = "SELECT username, AVG(action_interval) AS avg_time_between_actions FROM (SELECT username, timestamp - LAG(timestamp, 1) OVER (PARTITION BY username ORDER BY timestamp) AS action_interval FROM user_logs) WHERE action_interval IS NOT NULL GROUP BY username", nativeQuery = true)
    List<Map<String, Object>> avgTimeBetweenActionsPerUser();

    @Query(value = "SELECT action_sequence, COUNT(*) AS sequence_count FROM (SELECT username, action || ' -> ' || LEAD(action, 1) OVER (PARTITION BY username ORDER BY timestamp) AS action_sequence FROM user_logs) WHERE action_sequence IS NOT NULL GROUP BY action_sequence ORDER BY sequence_count DESC", nativeQuery = true)
    List<Map<String, Object>> mostFrequentActionSequences();

    @Query(value = "SELECT COUNT(DISTINCT username) AS total_users, COUNT(DISTINCT CASE WHEN action = 'login' THEN username END) AS retained_users, (COUNT(DISTINCT CASE WHEN action = 'login' THEN username END) * 1.0 / COUNT(DISTINCT username)) * 100 AS retention_rate FROM user_logs WHERE action IN ('login', 'signup')", nativeQuery = true)
    Map<String, Object> userRetentionRate();

    @Query(value = "SELECT previous_action, COUNT(*) AS action_count FROM (SELECT username, LAG(action, 1) OVER (PARTITION BY username ORDER BY timestamp) AS previous_action FROM user_logs WHERE action = 'cancel booking') WHERE previous_action IS NOT NULL GROUP BY previous_action ORDER BY action_count DESC", nativeQuery = true)
    List<Map<String, Object>> actionsLeadingToCancellations();

    @Query(value = "SELECT strftime('%Y-%m', timestamp) AS month, COUNT(DISTINCT username) AS monthly_active_users FROM user_logs GROUP BY month ORDER BY month DESC", nativeQuery = true)
    List<Map<String, Object>> monthlyActiveUsers();

    @Query(value = "SELECT strftime('%Y-%W', timestamp) AS week, COUNT(DISTINCT username) AS weekly_active_users FROM user_logs GROUP BY week ORDER BY week DESC", nativeQuery = true)
    List<Map<String, Object>> weeklyActiveUsers();

    @Query(value = "SELECT DATE(timestamp) AS date, COUNT(DISTINCT username) AS daily_active_users FROM user_logs GROUP BY date ORDER BY date DESC", nativeQuery = true)
    List<Map<String, Object>> dailyActiveUsers();

    @Query(value = "SELECT action, AVG(rating) AS avg_rating FROM user_logs JOIN user_ratings ON user_logs.username = user_ratings.username GROUP BY action ORDER BY avg_rating DESC", nativeQuery = true)
    List<Map<String, Object>> correlationBetweenActionsAndRatings();

    @Query(value = "SELECT previous_action, AVG(rating) AS avg_rating FROM (SELECT user_ratings.username, rating, LAG(action, 1) OVER (PARTITION BY user_ratings.username ORDER BY timestamp) AS previous_action FROM user_logs JOIN user_ratings ON user_logs.username = user_ratings.username) WHERE previous_action IS NOT NULL GROUP BY previous_action ORDER BY avg_rating DESC", nativeQuery = true)
    List<Map<String, Object>> actionsLeadingToHighRatings();

    @Query(value = "SELECT username, MIN(timestamp) - MIN(CASE WHEN action = 'signup' THEN timestamp END) AS time_to_first_action FROM user_logs GROUP BY username HAVING MIN(CASE WHEN action = 'signup' THEN timestamp END) IS NOT NULL", nativeQuery = true)
    List<Map<String, Object>> timeToFirstActionAfterSignup();
}
