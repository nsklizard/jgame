BEGIN;

alter TABLE game_map add column id serial not null;
alter table game_map drop constraint game_map_pkey;
alter table game_map add constraint game_map_pkey primary key (id);

COMMIT;