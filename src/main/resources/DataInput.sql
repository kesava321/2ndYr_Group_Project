DROP TABLE IF EXISTS EnergyComsumer;

CREATE TABLE EnergyComsumer(
    eID INT NOT NULL,
	eDate Date NOT NULL,
	eTime Time NOT NULL,
	Global_active_power FLOAT,
	Global_reactive_power FLOAT,
	Voltage FLOAT,
	Global_intensity FLOAT,
	Sub_metering_1 FLOAT,
	Sub_metering_2 FLOAT,
	Sub_metering_3 FLOAT,
    CONSTRAINT EnergyComsumer_pk
        PRIMARY KEY (eID)
);

INSERT INTO EnergyComsumer(eID, eDate, eTime, Global_active_power, Global_reactive_power, Voltage, Global_intensity, Sub_metering_1, Sub_metering_2, Sub_metering_3) 
            VALUES ( 1, "2006-12-16", "17:24:00",4.216, 0.418, 234.840, 18.400, 0.000, 1.000,17.000 );