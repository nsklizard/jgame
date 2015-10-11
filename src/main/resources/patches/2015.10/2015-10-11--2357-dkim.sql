BEGIN;

CREATE TABLE game_map
(
  x bigint not null ,
  y bigint not null ,
  creatureId bigint null,
  CONSTRAINT game_map_pkey PRIMARY KEY (x,y),
  CONSTRAINT "creature_skill_links_creatureId_fkey" FOREIGN KEY (creatureId)
  REFERENCES creatures (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

alter table skills rename column ether to poison;

COMMIT;