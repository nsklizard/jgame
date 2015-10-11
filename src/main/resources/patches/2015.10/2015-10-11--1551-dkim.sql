BEGIN;

CREATE TABLE skills
(
  id serial NOT NULL,
  name character varying,
  fire bigint,
  water bigint,
  air bigint,
  earth bigint,
  ether bigint,
  type character varying,
  CONSTRAINT skills_pkey PRIMARY KEY (id)
);

CREATE TABLE creatures
(
  id serial NOT NULL,
  name character varying,
  CONSTRAINT creatures_pkey PRIMARY KEY (id)
);


CREATE TABLE creature_skill_links
(
  id serial NOT NULL,
  creatureId bigint,
  skillId bigint,
  power bigint,
  CONSTRAINT creature_skill_links_pkey PRIMARY KEY (id),
  CONSTRAINT "creature_skill_links_creatureId_fkey" FOREIGN KEY (creatureId)
      REFERENCES creatures (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "creature_skill_links_skillId_fkey" FOREIGN KEY (skillId)
      REFERENCES skills (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

COMMIT;