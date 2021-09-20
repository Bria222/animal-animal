## PROJECT AUTHOR
brian nyachae

## Technologies and frameworks used
1. java 11
2. spark core 2.12
3. Gradle 4.10
4. Spark Template Velocity
5. Junit 4
6. Postgres
7. psql
8. sql2o
9. postgresql

## Usage
1. Clone this repo
2. Compile "gradle compileJava"
3. Run cd to cd build/classes/main `java App`

## User Stories 

## In PSQL:
1. Run psql in terminal
2. CREATE DATABASE wildlife_tracker;
3. CREATE TABLE animals (id serial PRIMARY KEY, name VARCHAR);
4. CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
5. CREATE TABLE sightings (id serial PRIMARY KEY, name varchar, location varchar, animalId int);
6. DROP DATABASE wildlife_tracker_test;
7. CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
8. ALTER TABLE animals ADD COLUMN type varchar;
9.  ALTER TABLE sightings DROP COLUMN animalid;
10. ALTER TABLE animals ADD COLUMN SightingId int;

## SCREENSHOTS
[![Screenshot-from-2019-04-30-08-59-32.png](https://i.postimg.cc/gk31T7FP/Screenshot-from-2019-04-30-08-59-32.png)](https://postimg.cc/kBXjVfgj)
## Testing
gradle test

## License
[MIT](https://choosealicense.com/licenses/mit/)

