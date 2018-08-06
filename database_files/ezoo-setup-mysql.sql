-- drop table animals if exists
drop table if exists animals;

create table animals (
  animalid integer primary key,
  `name` varchar (100),
  taxKingdom varchar (80),
  taxPhylum varchar (80),
  taxClass varchar (80),
  taxOrder varchar (80),
  taxFamily varchar (80),
  taxGenus varchar (80),
  taxSpecies varchar (80),
  height numeric(6,2),
  weight numeric(6,2),
  `type` varchar (80),
  healthStatus varchar (80)
);

insert into animals values (
  1,          -- id
  'Leo',      -- name
  'Animalia', -- kingdom
  'Chordata',    -- phylum
  'Mammalia',   -- class
  'Carnivora',-- animal_order
  'Felidae',  -- family
  'Panthera', -- genus
  'P. leo',   -- species
  120.88,     -- height
  400.67,     -- weight
  'Mammal (Terrestrial)',   -- type
  'Healthy'   -- healthStatus
);

drop table if exists FEEDINGSCHEDULE;
create table FEEDINGSCHEDULE (
  id integer primary key,
  animalid integer,
  "time" varchar (100),
  recurrence varchar (80),
  food varchar (80),
  notes varchar (80),
 );

insert into FEEDINGSCHEDULE values (
  1,          -- id
  '11:20',    -- time
  'yes',      -- recurrence
  'apple',    -- food
  'Mammalia', -- notes
  
);