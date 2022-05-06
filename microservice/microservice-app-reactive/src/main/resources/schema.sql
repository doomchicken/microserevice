drop table if exists customer_entity CASCADE;

create table customer_entity (
    id uuid default random_uuid(),
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ,
    name varchar(255),
    primary key (id)
);