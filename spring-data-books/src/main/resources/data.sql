insert into authors ( `name`)
values ('Marshak');
insert into authors (`name`)
values ('Tolstoy');

insert into genres (`name`)
values ('Poem');
insert into genres (`name`)
values ('Roman');

insert into books(`name`, `author_id`, `genre_id`)
values ('Rasskaz o neizvestnom geroe', 1, 1);
insert into books (`name`, `author_id`, `genre_id`)
values ('Otcy i deti', 2, 2);


insert into comments(`comment`, `book_id`)
values ('cool', 1);

insert into comments(`comment`, `book_id`)
values ('nice', 2);


