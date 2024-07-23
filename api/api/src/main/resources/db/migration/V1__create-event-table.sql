CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE event(
    id UUID DEFAULT gen_random_uuid() primary key,
    title varchar(100) not null,
    description varchar(250) not null,
    img_url varchar(100) not null,
    event_url varchar(100) not null,
    date TIMESTAMP not null,
    remote Boolean not null
);