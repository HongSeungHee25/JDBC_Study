
/* Drop Tables */

DROP TABLE Payment CASCADE CONSTRAINTS;
DROP TABLE car_rent CASCADE CONSTRAINTS;
DROP TABLE car CASCADE CONSTRAINTS;
DROP TABLE Discount_Rate CASCADE CONSTRAINTS;
DROP TABLE CARD CASCADE CONSTRAINTS;
DROP TABLE customer CASCADE CONSTRAINTS;
DROP TABLE Drivers_License CASCADE CONSTRAINTS;
DROP TABLE Reservation_Status CASCADE CONSTRAINTS;
DROP TABLE vehicle_class CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE car
(
	car_id number NOT NULL,
	carType varchar2(30) NOT NULL,
	fuel varchar2(30) NOT NULL,
	car_option varchar2(100) NOT NULL,
	Daily_Rental_Rate number NOT NULL,
	Daily_Premium number,
	Rating_id number NOT NULL,
	PRIMARY KEY (car_id)
);


CREATE TABLE CARD
(
	card_id number NOT NULL UNIQUE,
	card_name varchar2(30) NOT NULL UNIQUE,
	PRIMARY KEY (card_id)
);


CREATE TABLE car_rent
(
	history_id number NOT NULL,
	start_date date NOT NULL,
	end_date date,
	Remainin_fuel_amount varchar2(30),
	customer_id varchar2(30) NOT NULL UNIQUE,
	car_id number NOT NULL,
	ReservationStatusID number NOT NULL,
	PRIMARY KEY (history_id)
);


CREATE TABLE customer
(
	customer_id varchar2(30) NOT NULL UNIQUE,
	password number NOT NULL UNIQUE,
	name varchar2(30) NOT NULL,
	phone varchar2(30) NOT NULL,
	license_id number NOT NULL UNIQUE,
	PRIMARY KEY (customer_id)
);


CREATE TABLE Discount_Rate
(
	card_id number NOT NULL UNIQUE,
	discount_rate number,
	card_id_fk number NOT NULL UNIQUE,
	PRIMARY KEY (card_id)
);


CREATE TABLE Drivers_License
(
	license_id number NOT NULL UNIQUE,
	license_information varchar2(30) NOT NULL UNIQUE,
	Date_issue date NOT NULL,
	expiration_period date NOT NULL,
	licensed_servant varchar2(30) NOT NULL,
	license_source varchar2(30),
	PRIMARY KEY (license_id)
);


CREATE TABLE Payment
(
	payment_id varchar2(30) NOT NULL,
	payment_date date NOT NULL,
	payment_amount number NOT NULL,
	payment_method varchar2(30) NOT NULL,
	customer_id varchar2(30) NOT NULL UNIQUE,
	history_id number NOT NULL,
	card_id number NOT NULL UNIQUE,
	PRIMARY KEY (payment_id)
);


CREATE TABLE Reservation_Status
(
	ReservationStatusID number NOT NULL,
	ReservationStatusName varchar2(30) NOT NULL,
	PRIMARY KEY (ReservationStatusID)
);


CREATE TABLE vehicle_class
(
	Rating_id number NOT NULL,
	vehicle_Class varchar2(30) NOT NULL,
	domestic_Market varchar2(30) NOT NULL,
	PRIMARY KEY (Rating_id)
);



/* Create Foreign Keys */

ALTER TABLE car_rent
	ADD FOREIGN KEY (car_id)
	REFERENCES car (car_id)
;


ALTER TABLE Discount_Rate
	ADD FOREIGN KEY (card_id_fk)
	REFERENCES CARD (card_id)
;


ALTER TABLE Payment
	ADD FOREIGN KEY (card_id)
	REFERENCES CARD (card_id)
;


ALTER TABLE Payment
	ADD FOREIGN KEY (history_id)
	REFERENCES car_rent (history_id)
;


ALTER TABLE car_rent
	ADD FOREIGN KEY (customer_id)
	REFERENCES customer (customer_id)
;


ALTER TABLE Payment
	ADD FOREIGN KEY (customer_id)
	REFERENCES customer (customer_id)
;


ALTER TABLE customer
	ADD FOREIGN KEY (license_id)
	REFERENCES Drivers_License (license_id)
;


ALTER TABLE car_rent
	ADD FOREIGN KEY (ReservationStatusID)
	REFERENCES Reservation_Status (ReservationStatusID)
;


ALTER TABLE car
	ADD FOREIGN KEY (Rating_id)
	REFERENCES vehicle_class (Rating_id)
;



