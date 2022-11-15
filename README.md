# Portfolio Application
Web application for monitoring a user's crypto asset.

## Start PosrtgreSQL with Docker
To get started, you need a database. Docker will help us with this. It needs to be installed locally.

First step. Run the command in the terminal:


> docker pull postgres:latest
>
> docker run --name dev-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres:latest

NOTE: The first line pulls PostgreSQL `latest` version;
the second line initiates a new instance of it with the name `dev-postgres`, running on port `5432`.

Next step, create a working database

> docker exec dev-postgres psql -U postgres -c "CREATE DATABASE portfoliodb" postgres

This line executes a DDL command to create the database `portfoliodb` into the instance.

_Keep in mind, you are not creating a volume for the storage data if the container is deleted, all its data will be deleted as well._


_Coming soon ..._
