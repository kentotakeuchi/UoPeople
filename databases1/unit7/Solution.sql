-- Programming	Assignment	Unit	7 – Solution
-- The	following	SQL	statements	are	used	to	create tables,	populate	data	with	and	retrieve	data	from the	
-- Specialty,	Doctor,	Patient,	Allergy,	PatientAllergy,	Appointment,	Medicine,	and	PatientMedicine
-- tables.
-- SQL	Statements	for Specialty	Table
-- Create	Specialty	Table
Create	Table	Specialty(
								SpecialtyNumber	char(10) Not	Null,
								SpecialtyName	char	(40),
CONSTRAINT	pk_sn	PRIMARY	KEY	(SpecialtyNumber),
CONSTRAINT	uq_sn	Unique	(SpecialtyNumber)
);

-- Populate	Specialty	Table	with	Data

Insert	Into	Specialty	(SpecialtyNumber,	SpecialtyName)	Values ('S1','Dermatology');
Insert	Into	Specialty	(SpecialtyNumber,	SpecialtyName)	Values ('S2','Psychiatry');
Insert	Into	Specialty	(SpecialtyNumber,	SpecialtyName) Values ('S3','Oncology');
Insert	Into	Specialty	(SpecialtyNumber,	SpecialtyName)	Values ('S4','Cardiology');
Insert	Into	Specialty	(SpecialtyNumber,	SpecialtyName)	Values ('S5','Urology');
Insert	Into	Specialty	(SpecialtyNumber,	SpecialtyName)	Values ('S6','Pediatrics');

-- Retrieve	All	Data	from	Specialty	Table

Select	*	From	Specialty;

-- SQL	Statements	for	Doctor	Table

-- Create	Doctor	Table
Create	Table	Doctor(
								DoctorID	char(10) Not	Null,
								Name	char	(40)	Not	Null,
								Phone	char	(20)	Not Null,
								SpecialtyNumber	char(10) Not	Null,
								Supervisor	char(10),
CONSTRAINT	pk_did	PRIMARY	KEY	(DoctorID),
CONSTRAINT	uq_did	Unique	(DoctorID)
);
ALTER	TABLE	Doctor	
ADD	CONSTRAINT	fk_Specialty	FOREIGN	KEY	(SpecialtyNumber)
REFERENCES	Specialty(SpecialtyNumber);
-- Populate	Doctor	Table	with	Data
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D1','Doctor	
Karen','555-1212','S6','');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D2','Doctor	
John','555-2934','S2','D1');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D3','Doctor	
Robert','555-6723','S6','D1');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D4','Doctor	
David','555-1745','S4','D1');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D5','Doctor	
Mary','555-6565','S5','D1');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D6','Doctor	
Linda','555-4889','S1','D1');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D7','Doctor	
Susan','555-4581','S3','D1');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D8','Doctor	
Zeynep','555-7891','S4','D1');
Insert	Into	Doctor	(DoctorID,	Name,	Phone,	SpecialtyNumber,	Supervisor)	Values	('D9','Doctor	
Mat','555-7791','S1','D1');
-- Retrieve	All	Data	from	Doctor	Table
Select	*	From	Doctor;
-- SQL	Statements	for	Patient	Table
-- Create	Patient	Table
Create	Table	Patient(
								PatientID	char(10) Not	Null,
								Name	char(40)	Not	Null,
								Phone	char(20)	Not	Null,
								Email	char(40),
								Address	char(100)	Not	Null,
								AddedDate	date Not	Null,
								DoctorID	char(10) Not	Null,
CONSTRAINT	pk_pid	PRIMARY	KEY	(PatientID),
CONSTRAINT	uq_pid	Unique	(PatientID),
CONSTRAINT	fk_doctor	FOREIGN	KEY	(DoctorID)	REFERENCES	Doctor(DoctorID)
);
-- Populate	Patient	Table	with	Data
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P1','D2','Patient	Dana','444-1212','P1@email.com','123	Home	St.','2019-2-1');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P2','D7','Patient	Harry','444-2934','P2@email.com','3435	Main	St.','2011-7-13');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P3','D6','Patient	Karl','444-6723','P3@email.com','2176	Baker	St.','2009-5-10');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P4','D2','Patient	Sid','444-1745','P4@email.com','176	Right	St.','2010-6-20');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P5','D8','Patient	Marry','444-6565','P5@email.com','435	Main	St.','2014-5-18');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P6','D6','Patient	Kim','444-4889','P6@email.com','34	Home	St.','2018-3-15');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P7','D4','Patient	Susan','444-4581','P7@email.com','65	Water	St.','2011-9-7');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P8','D3','Patient	Sam','444-7891','P8@email.com','23	Hill	Drive','2010-11-23');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P9','D5','Patient	Peter','444-7791','P9@email.com','12	River	St.','2008-2-1');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P10','D7','Patient	Nick','123-1212','P10@email.com','335	Bay	St.','2011-7-13');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P11','D9','Patient	Kyle','123-2934','P11@email.com','216	Baker	St.','2016-5-10');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P12','D9','Patient	Garcia','123-6723','P12@email.com','176	Right	St.','2010-6-20');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P13','D4','Patient	Alicia','123-1745','P13@email.com','823	Left	St.','2015-5-18');
Insert	Into	Patient	(PatientID,	DoctorID,	Name,	Phone,	Email,	Address,	AddedDate)		Values	
('P14','D4','Patient	Dan','123-6565','P14@email.com','534	High	St.','2018-3-15');
-- Retrieve	All	Data	from	Patient	Table
Select	*	From	Patient;
-- SQL	Statements	for	Allergy	Table
-- Create	Allergy	Table
Create	Table	Allergy(
								AllergyID	char(10) Not	Null,
								AllergyName	char(40)	Not	Null,
CONSTRAINT	pk_aid	PRIMARY	KEY	(AllergyID),
CONSTRAINT	uq_aid	Unique	(AllergyID)
);
-- Populate	Allergy	Table	with	Data
Insert	Into	Allergy	(AllergyID,	AllergyName)	Values('AL1','Drug	');
Insert	Into	Allergy	(AllergyID,	AllergyName)	Values('AL2','Food');
Insert	Into	Allergy	(AllergyID,	AllergyName)	Values('AL3','Skin');
Insert	Into	Allergy	(AllergyID,	AllergyName)	Values('AL4','Asthma	');
Insert	Into	Allergy	(AllergyID,	AllergyName)	Values('AL5','Rhinitis');
-- Retrieve	All	Data	from	Allergy	Table
Select	*	From	Allergy;
-- SQL	Statements	for	PatientAllergy	Table
-- Create	PatientAllergy	Table
Create	Table	PatientAllergy(
								AllergyID	char(10) Not	Null,
								PatientID	char(10) Not	Null,
CONSTRAINT	pk_apid PRIMARY	KEY	(AllergyID,PatientID),
CONSTRAINT	uq_apid	Unique	(AllergyID,PatientID),
CONSTRAINT	fk_allergy	FOREIGN	KEY	(AllergyID)	REFERENCES	Allergy(AllergyID),
CONSTRAINT	fk_patient	FOREIGN	KEY	(PatientID)	REFERENCES	Patient(PatientID)
);
-- Populate	PatientAllergy	Table	with	Data
Insert	Into	PatientAllergy	(AllergyID,	PatientID)	Values('AL4','P1');
Insert	Into	PatientAllergy	(AllergyID,	PatientID)	Values('AL2','P13');
Insert	Into	PatientAllergy	(AllergyID,	PatientID)	Values('AL3','P11');
Insert	Into	PatientAllergy	(AllergyID,	PatientID)	Values('AL4','P7');
Insert	Into	PatientAllergy	(AllergyID,	PatientID)	Values('AL5','P9');
Insert	Into	PatientAllergy	(AllergyID,	PatientID)	Values('AL1','P3');
-- Retrieve	All	Data	from	PatientAllergy	Table
Select	*	From	PatientAllergy;
-- SQL	Statements	for	Appointment	Table
-- Create	Appointment	Table
Create	Table	Appointment(
								AppointmentID	char(10) Not	Null,
								PatientID	char(10) Not	Null,
								DoctorID	char(10) Not	Null,
								AppointmentDate	date Not	Null,
								BloodPressure		smallint	Not	Null,
								Weight	decimal(5,2)	Not	Null,
								TreatmentNotes	char(255)	Not	Null,
CONSTRAINT	pk_appid	PRIMARY	KEY	(AppointmentID),
CONSTRAINT	uq_appid	Unique	(AppointmentID),
CONSTRAINT	fk_doctor_app FOREIGN	KEY	(DoctorID)	REFERENCES	Doctor(DoctorID),
CONSTRAINT	fk_patient_app	FOREIGN	KEY	(PatientID)	REFERENCES	Patient(PatientID)
);
-- Populate	Appointment	Table	with	Data
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A1','P1','D2','2019-7-1','80','65','Dream	to	success');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A2','P13','D4','2019-1-4','77','88','Good	heart	rate');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A3','P11','D9','2019-3-22','82','95','Many	spots');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A4','P7','D4','2020-2-1','85','74','Fast	heart	rate');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values ('A5','P9','D5','2019-4-13','75','56','Reports	checked');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A6','P3','D6','2019-11-12','81','96','Sun	light	spots');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A7','P10','D7','2020-1-29','80','87','Early	treatment');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A8','P9','D5','2019-8-12','86','92','Much	better');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A9','P14','D4','2019-5-18','75','75','Good	heart	rate');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A10','P8','D3','2019-11-18','76','79','New	teeth');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID, AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A11','P11','D9','2019-6-22','78','71','Much	better');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A12','P2','D7','2020-2-21','82','86','Early	treatment');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A13','P4','D2','2019-8-17','81','101','Bad	dreams');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A14','P6','D6','2019-6-27','79','49','Sun	light	spots');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A15','P10','D7','2020-7-29','80','83','Early	treatment');
Insert	Into	Appointment	(AppointmentID,	PatientID,	DoctorID,	AppointmentDate,	BloodPressure,	
Weight,	TreatmentNotes)	Values	('A16','P7','D4','2020-8-1','78','79','Good	heart	rate');
Retrieve	All	Data	from	Appointment	Table
Select	*	From	Appointment;
-- SQL	Statements	for	Medicine	Table
-- Create	Medicine	Table
Create	Table	Medicine(
								MedicineID	char(10) Not	Null,
								MedicineName	char	(40)	Not	Null,
CONSTRAINT	pk_mid_pk	PRIMARY	KEY	(MedicineID),
CONSTRAINT	uq_mid	Unique	(MedicineID)
);
-- Populate	Medicine	Table	with	Data
Insert	Into	Medicine	(MedicineID,	MedicineName)	Values('M1','Ativan');
Insert	Into	Medicine	(MedicineID,	MedicineName)	Values('M2','Ibuprofen');
Insert	Into	Medicine	(MedicineID,	MedicineName)	Values('M3','Omeprazole	');
Insert	Into	Medicine	(MedicineID,	MedicineName)	Values('M4','Metoprolol	');
Insert	Into	Medicine	(MedicineID,	MedicineName)	Values('M5','Azithromycin	');
Insert	Into	Medicine	(MedicineID,	MedicineName)	Values('M6','Codeine	');
-- Retrieve	All	Data	from	Medicine	Table
Select	*	From	Medicine;
-- SQL	Statements	for	PatientMedicine	Table
Create	PatientMedicine	Table
Create	Table	PatientMedicine(
								AppointmentID	char(10) Not	Null,
								MedicineID	char(10) Not	Null,
CONSTRAINT	pk_pmid	PRIMARY	KEY	(AppointmentID,MedicineID),
CONSTRAINT	uq_pmid	Unique	(AppointmentID,MedicineID),
CONSTRAINT	fk_appointment	FOREIGN	KEY	(AppointmentID)	REFERENCES	
Appointment(AppointmentID),
CONSTRAINT	fk_medicine	FOREIGN	KEY	(MedicineID)	REFERENCES	Medicine(MedicineID)
);
-- Populate	PatientMedicine	Table	with	Data
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A15','M1');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A2','M6');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A8','M3');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A6','M3');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A15','M2');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A10','M6');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A10','M2');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A4','M5');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A3','M5');
Insert	Into	PatientMedicine	(AppointmentID,	MedicineID)	Values('A1','M2');
-- Retrieve	All	Data	from	PatientMedicine	Table
Select	*	From	PatientMedicine;
