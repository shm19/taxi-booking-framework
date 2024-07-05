import sqlite3
import pandas as pd
import matplotlib.pyplot as plt

# Connect to the SQLite database
conn = sqlite3.connect('report.db')
cursor = conn.cursor()

# Query to get total number of user actions
query = "SELECT COUNT(*) AS total_actions FROM user_logs"
total_actions = pd.read_sql_query(query, conn)

# Plotting the total number of user actions
plt.figure(figsize=(10, 6))
plt.bar(['Total Actions'], total_actions['total_actions'])
plt.xlabel('Metric')
plt.ylabel('Count')
plt.title('Total Number of User Actions')
plt.savefig('total_user_actions.png')
plt.show()
