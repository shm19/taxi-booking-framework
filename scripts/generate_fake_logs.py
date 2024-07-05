import psycopg2
from faker import Faker
import random
from datetime import datetime, timedelta

db_config = {
    'dbname': 'taxi',
    'user': 'postgres',
    'password': 'password',
    'host': 'localhost',
    'port': '5432'
}

conn = psycopg2.connect(**db_config)
cursor = conn.cursor()

fake = Faker()


def generate_fake_logs(num_logs):
    actions = [
        'signup', 'login', 'create booking', 'update booking', 'cancel booking',
        'assign driver', 'update vehicle status', 'calculate price', 'update pricing'
    ]

    end_time = datetime.now()
    start_time = end_time - timedelta(days=30)

    for _ in range(num_logs):
        username = fake.user_name()
        action = random.choice(actions)
        timestamp = fake.date_time_between(
            start_date=start_time, end_date=end_time)
        cursor.execute(
            "INSERT INTO user_logs (username, action, timestamp) VALUES (%s, %s, %s)",
            (username, action, timestamp)
        )


generate_fake_logs(1000)

conn.commit()

cursor.close()
conn.close()
