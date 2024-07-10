import requests
import matplotlib.pyplot as plt
from datetime import datetime

# Replace with your Prometheus server URL
prometheus_url = 'http://localhost:9090/api/v1/query_range'
query = 'rate(booking_create_time_seconds_sum[1m]) / rate(booking_create_time_seconds_count[1m])'

# Time range for the query
end_time = datetime.now().timestamp()
start_time = end_time - 3600  # Last 1 hour

params = {
    'query': query,
    'start': start_time,
    'end': end_time,
    'step': '30s'
}

response = requests.get(prometheus_url, params=params)
data = response.json()['data']['result'][0]['values']

# Extract timestamps and values
timestamps = [datetime.fromtimestamp(ts) for ts, _ in data]
values = [float(value) for _, value in data]

# Plotting
plt.figure(figsize=(10, 6))
plt.plot(timestamps, values)
plt.xlabel('Time')
plt.ylabel('Average Booking Creation Time (s)')
plt.title('Average Booking Creation Time Over the Last Hour')
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig('avg_booking_creation_time.png')
plt.show()
