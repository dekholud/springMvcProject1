create table person (id serial primary key,
                     fio varchar(2000) unique,
                     year_of_birth int check (year_of_birth > 1900))
;

create table book (id serial primary key ,
                   name varchar(2000),
                   author varchar(2000),
                   year int check (year > 0),
                   person_id bigint);
ALTER TABLE book
    ADD CONSTRAINT book_1fk FOREIGN KEY (person_id) REFERENCES person (id)
        on UPDATE CASCADE ON DELETE SET NULL;