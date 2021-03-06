USE ibikehda;

CREATE TABLE IF NOT EXISTS User (
	UserID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  Username VARCHAR(16) NOT NULL,
	Password VARCHAR(600) NOT NULL,
	IsAdmin TINYINT(1) NOT NULL DEFAULT 0,
	UNIQUE INDEX (Username),
	PRIMARY KEY (UserID)
);

CREATE TABLE IF NOT EXISTS TerminalType (
	TerminalTypeID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Type VARCHAR(16) NOT NULL,
	UNIQUE INDEX (Type),
	PRIMARY KEY (TerminalTypeID)
);

CREATE TABLE IF NOT EXISTS Station (
	StationID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	PhoneNumber VARCHAR(16),
	Place VARCHAR(64) NOT NULL,
	Street VARCHAR(64) NOT NULL,
	HouseNumber VARCHAR(16) NOT NULL,
	Coordinates VARCHAR(64) NOT NULL,
	TerminalTypeID INT UNSIGNED,
	UNIQUE INDEX (PhoneNumber),
	CONSTRAINT Station_TerminalType_FK FOREIGN KEY (TerminalTypeID) REFERENCES TerminalType (TerminalTypeID) ON UPDATE CASCADE ON DELETE SET NULL,
	PRIMARY KEY (StationID)
);

CREATE TABLE IF NOT EXISTS PlugType (
	PlugTypeID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Type VARCHAR(16) NOT NULL,
	UNIQUE INDEX (Type),
	PRIMARY KEY (PlugTypeID)
);

CREATE TABLE IF NOT EXISTS Station_PlugType (
	StationID INT UNSIGNED NOT NULL,
	PlugTypeID INT UNSIGNED NOT NULL,
  CONSTRAINT Station_PlugType_S_FK FOREIGN KEY (StationID) REFERENCES Station (StationID) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT Station_PlugType_PT_FK FOREIGN KEY (PlugTypeID) REFERENCES PlugType (PlugTypeID) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY (StationID, PlugTypeID)
);

CREATE TABLE IF NOT EXISTS hibernate_sequence (
	next_val BIGINT(20)
);

CREATE TABLE IF NOT EXISTS BikeStatus (
	BikeStatusID INT UNSIGNED NOT NULL,
	Status VARCHAR(16) NOT NULL,
	UNIQUE INDEX (Status),
	PRIMARY KEY (BikeStatusID)
);

CREATE TABLE IF NOT EXISTS Bike (
	BikeID INT UNSIGNED NOT NULL,
	BikeNumber INT UNSIGNED NOT NULL,
	Designation VARCHAR(64) NOT NULL,
	GearCount INT UNSIGNED NOT NULL,
	DriveTechnology VARCHAR(64) NOT NULL,
	BatteryLifePercent INT UNSIGNED NOT NULL,
	BikeStatusID INT UNSIGNED,
	UserID INT UNSIGNED,
	MainStationID INT UNSIGNED,
	CurrentStationID INT UNSIGNED,
	CONSTRAINT Bike_BB_FK FOREIGN KEY (BikeStatusID) REFERENCES BikeStatus (BikeStatusID) ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT Bike_BU_FK FOREIGN KEY (UserID) REFERENCES User (UserID) ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT Bike_MS_FK FOREIGN KEY (MainStationID) REFERENCES Station (StationID) ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT Bike_CS_FK FOREIGN KEY (CurrentStationID) REFERENCES Station (StationID) ON UPDATE CASCADE ON DELETE SET NULL,
	PRIMARY KEY (BikeID)
);

INSERT INTO hibernate_sequence VALUE (1);
