create table IF NOT EXISTS users (
ID INTEGER primary key,
username VARCHAR not null,
fio VARCHAR
)

create table IF NOT EXISTS logins (
id INTEGER primary key,
access_date TIMESTAMP not null,
user_id INTEGER REFERENCES users (id) ON DELETE CASCADE,
application VARCHAR
)