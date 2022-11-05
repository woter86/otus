insert into authors (`id`, `name`)
values (1, 'Marshak');
insert into authors (`id`,`name`)
values (2, 'Tolstoy');

insert into genres (`id`,`name`)
values (1, 'Poem');
insert into genres (`id`,`name`)
values (2, 'Roman');

insert into books(`id`,`name`, `author_id`, `genre_id`)
values (1, 'Rasskaz o neizvestnom geroe', 1, 1);
insert into books (`id`,`name`, `author_id`, `genre_id`)
values (2, 'Otcy i deti', 2, 2);


