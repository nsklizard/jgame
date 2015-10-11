BEGIN;

alter table skills alter column fire set default 0;
alter table skills alter column water set default 0;
alter table skills alter column air set default 0;
alter table skills alter column earth set default 0;
alter table skills alter column poison set default 0;

COMMIT;