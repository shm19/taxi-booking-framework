import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

# Connect to the SQLite database
conn = sqlite3.connect('report.db')
cursor = conn.cursor()

# Query to get user actions over time (daily)
query = """
SELECT DATE(timestamp) AS date, COUNT(*) AS daily_actions
FROM user_logs
GROUP BY date
ORDER BY date DESC
"""
user_actions_over_time = pd.read_sql_query(query, conn)

# Ensure the 'date' column has no None values and is of type str
user_actions_over_time = user_actions_over_time.dropna(subset=['date'])
user_actions_over_time['date'] = user_actions_over_time['date'].astype(str)

# Plotting user actions over time (daily)
plt.figure(figsize=(14, 7))
plt.plot(user_actions_over_time['date'], user_actions_over_time['daily_actions'])
plt.xlabel('Date')
plt.ylabel('Daily Actions')
plt.title('User Actions Over Time (Daily)')
plt.xticks(rotation=45)
plt.savefig('user_actions_over_time.png')
plt.show()

# Close the database connection
conn.close()
