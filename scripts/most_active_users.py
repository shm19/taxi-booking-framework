import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

# Connect to the SQLite database
conn = sqlite3.connect('report.db')
cursor = conn.cursor()

# Query to get most active users
query = "SELECT username, COUNT(*) AS action_count FROM user_logs GROUP BY username ORDER BY action_count DESC LIMIT 10"
most_active_users = pd.read_sql_query(query, conn)

# Plotting the most active users
plt.figure(figsize=(12, 8))
plt.bar(most_active_users['username'], most_active_users['action_count'])
plt.xlabel('Username')
plt.ylabel('Action Count')
plt.title('Most Active Users')
plt.xticks(rotation=45)
plt.savefig('most_active_users.png')
plt.show()
