CREATE TABLE address(
    id UUID DEFAULT gen_random_uuid() primary key ,
    city varchar(100) not null,
    uf varchar(100) not null,
    event_id UUID,
    foreign key (event_id) references event(id) on delete cascade
);