BEGIN;

DROP TABLE IF EXISTS breweries;
DROP TABLE IF EXISTS beers;
DROP TABLE IF EXISTS brewery_beer;

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
	info varchar(500) NOT NULL, 
	beer_image_url varchar(300), 
	brewery_id integer,
	CONSTRAINT pk_beers_beer_id PRIMARY KEY (beer_id),
	CONSTRAINT fk_breweries_brewery_id FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);

COMMIT;