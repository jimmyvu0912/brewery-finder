BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS beers;
DROP TABLE IF EXISTS breweries;
DROP TABLE IF EXISTS brewery_beer;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE breweries (
	brewery_id serial,
	name varchar(30) NOT NULL,
	city varchar(30) NOT NULL,
	state varchar(30) NOT NULL,
	brewery_logo_url varchar(2000),
	website_url varchar(2000),
    user_id bigint,
	CONSTRAINT pk_breweries_brewery_id PRIMARY KEY (brewery_id),
    CONSTRAINT fk_users_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE beers (
	beer_id serial,
	name varchar(50) NOT NULL,
	abv varchar(10) NOT NULL,
	type varchar(30) NOT NULL,
	info varchar(5000) NOT NULL,
	beer_image_url varchar(300),
	brewery_id integer,
	CONSTRAINT pk_beers_beer_id PRIMARY KEY (beer_id),
	CONSTRAINT fk_breweries_brewery_id FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);

CREATE TABLE reviews (
    review_id serial,
    name varchar(100) NOT NULL,
    description varchar(100) NOT NULL,
    rating integer,
    create_date timestamp DEFAULT NOW(),
    user_id integer,
    beer_id integer,
    CONSTRAINT pk_reviews_review_id PRIMARY KEY (review_id),
    CONSTRAINT fk_users_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_beers_beer_id FOREIGN KEY (beer_id) REFERENCES beers(beer_id)
);

CREATE TABLE brewery_beer (
    beer_id integer,
    brewery_id integer,
    CONSTRAINT pk_brewery_beer_brewery_id_beer_id PRIMARY KEY (beer_id, brewery_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
