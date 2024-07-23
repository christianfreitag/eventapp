CREATE TABLE coupon(
    id UUID DEFAULT gen_random_uuid() primary key ,
    code varchar(100) not null,
    discount integer not null,
    valid timestamp not null,
    event_id uuid,
    foreign key (event_id) references event(id) on delete cascade
);