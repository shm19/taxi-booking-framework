import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

# Connect to the SQLite database
conn = sqlite3.connect('report.db')
cursor = conn.cursor()

# Query to get user actions grouped by type
query = "SELECT action, COUNT(*) AS action_count FROM user_logs GROUP BY action ORDER BY action_count DESC"
actions_grouped_by_type = pd.read_sql_query(query, conn)

# Plotting the user actions grouped by type
plt.figure(figsize=(12, 8))
plt.bar(actions_grouped_by_type['action'],
        actions_grouped_by_type['action_count'])
plt.xlabel('Action Type')
plt.ylabel('Count')
plt.title('User Actions Grouped by Type')
plt.xticks(rotation=45)
plt.savefig('actions_grouped_by_type.png')
plt.show()
