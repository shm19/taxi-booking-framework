import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

# Connect to the SQLite database
conn = sqlite3.connect('report.db')
cursor = conn.cursor()

# Query to get peak activity hours
query = """
SELECT strftime('%H', timestamp) AS hour, COUNT(*) AS hourly_actions
FROM user_logs
GROUP BY hour
ORDER BY hourly_actions DESC
"""
peak_activity_hours = pd.read_sql_query(query, conn)

peak_activity_hours['hour'] = peak_activity_hours['hour'].astype(str)

# Plotting peak activity hours
plt.figure(figsize=(12, 8))
plt.bar(peak_activity_hours['hour'], peak_activity_hours['hourly_actions'])
plt.xlabel('Hour of Day')
plt.ylabel('Actions Count')
plt.title('Peak Activity Hours')
plt.savefig('peak_activity_hours.png')
plt.show()

conn.close()