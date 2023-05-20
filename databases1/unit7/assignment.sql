Create the Speciality relation:
CREATE TABLE Specialty (
  SpecialtyNumber VARCHAR(2) PRIMARY KEY,
  SpecialtyName VARCHAR(20) NOT NULL
);


-- Populate the Speciality relation with data:
INSERT INTO Specialty (SpecialtyNumber, SpecialtyName)
VALUES
  ('S1', 'Dermatology'),
  ('S2', 'Psychiatry'),
  ('S3', 'Oncology'),
  ('S4', 'Cardiology'),
  ('S5', 'Urology'),
  ('S6', 'Pediatrics');


-- Selecting data from the Specialty relation:
SELECT * FROM Specialty;


-- The output:


-- Create the Doctor relation:
CREATE TABLE Doctor (
  DoctorID VARCHAR(2) PRIMARY KEY,
  Name VARCHAR(20) NOT NULL,
  Phone VARCHAR(10),
  SpecialtyNumber VARCHAR(2) NOT NULL,
  Supervisor VARCHAR(2),
  FOREIGN KEY (SpecialtyNumber) REFERENCES Specialty(SpecialtyNumber),
  FOREIGN KEY (Supervisor) REFERENCES Doctor(DoctorID)
);


-- Populate the Doctor relation with data:
INSERT INTO Doctor(DoctorID, Name, Phone, SpecialtyNumber, Supervisor)
VALUES
  ('D1', 'Doctor Karen', '555-1212', 'S6', NULL),
  ('D2', 'Doctor John', '555-2934', 'S2', 'D1'),
  ('D3', 'Doctor Robert', '555-6723', 'S6', 'D1'),
  ('D4', 'Doctor David', '555-1745', 'S4', 'D1'),
  ('D5', 'Doctor Mary', '555-6565', 'S5', 'D1'),
  ('D6', 'Doctor Linda', '555-4889', 'S1', 'D1'),
  ('D7', 'Doctor Susan', '555-4581', 'S3', 'D1'),
  ('D8', 'Doctor Zeynep', '555-7891', 'S4', 'D1'),
  ('D9', 'Doctor Mat', '555-7791', 'S1', 'D1');


-- Select data from the Doctor relation:
SELECT * FROM Doctor;


-- The output:

Create the Patient relation:
CREATE TABLE Patient (
  PatientID VARCHAR(2) PRIMARY KEY,
  Name VARCHAR(20) NOT NULL,
  Phone VARCHAR(10),
  Email VARCHAR(30),
  Address VARCHAR(30),
  AddedDate DATE,
  DoctorID VARCHAR(2) NOT NULL,
  FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID)
);


-- Populate the Patient relation with data:
INSERT INTO Patient (PatientID, Name, Phone, Email, Address, AddedDate, DoctorID)
VALUES
  ('P1', 'Patient Dana', '444-1212', 'P1@email.com', '123 Home St.', '2019-02-01', 'D2'),
  ('P2', 'Patient Harry', '444-2934', 'P2@email.com', '3435 Main St.', '2011-07-13', 'D7'),
  ('P3', 'Patient Karl', '444-6723', 'P3@email.com', '2176 Baker St.', '2009-05-10', 'D6'),
  ('P4', 'Patient Sid', '444-1745', 'P4@email.com', '176 Right St.', '2010-06-20', 'D2'),
  ('P5', 'Patient Marry', '444-6565', 'P5@email.com', '435 Main St.', '2014-05-18', 'D8'),
  ('P6', 'Patient Kim', '444-4889', 'P6@email.com', '34 Home St.', '2018-03-15', 'D6'),
  ('P7', 'Patient Susan', '444-4581', 'P7@email.com', '65 St.', '2011-09-07', 'D4'),
  ('P8', 'Patient Sam', '444-7891', 'P8@email.com', '23 Hill Drive', '2010-11-23', 'D3'),
  ('P9', 'Patient Peter', '444-7791', 'P9@email.com', '12 River St.', '2008-02-01', 'D5'),
  ('P10', 'Patient Nick', '123-1212', 'P10@email.com', '335 Bay St.', '2011-07-13', 'D7'),
  ('P11', 'Patient Kyle', '123-2934', 'P11@email.com', '216 Baker St.', '2016-05-10', 'D9'),
  ('P12', 'Patient Garcia', '123-6723', 'P12@email.com', '176 Right St.', '2010-6-20', 'D9'),
  ('P13', 'Patient Alicia', '123-1745', 'P13@email.com', '823 Left St.', '2015-05-18', 'D4'),
  ('P14', 'Patient Dan', '123-6565', 'P14@email.com', '534 High St.', '2018-03-15', 'D4');


-- Select data from the Patient relation:
SELECT * FROM Patient;


-- The output:


-- Create the Appointment relation:
CREATE TABLE Appointment (
  AppointmentID VARCHAR(2) PRIMARY KEY,
  AppointmentDate DATE,
  DoctorID VARCHAR(2) NOT NULL,
  PatientID VARCHAR(2) NOT NULL,
  BloodPressure INT,
  Weight INT,
  TreatmentNotes VARCHAR(50),
  FOREIGN KEY (DoctorID) REFERENCES Doctor(DoctorID),
  FOREIGN KEY (PatientID) REFERENCES Patient(PatientID)
);


-- Populate the Appointment relation with data:
INSERT INTO Appointment (AppointmentID, AppointmentDate, DoctorID, PatientID, BloodPressure, Weight, TreatmentNotes)
VALUES
  ('A1', '2019-07-01', 'D2', 'P1', 80, 65, 'Dream to success'),
  ('A2', '2019-01-04', 'D4', 'P13', 77, 88, 'Good heart rate'),
  ('A3', '2019-03-22', 'D9', 'P11', 82, 95, 'Many spots'),
  ('A4', '2020-02-01', 'D4', 'P7', 85, 74, 'Fast heart rate'),
  ('A5', '2019-04-13', 'D5', 'P9', 75, 56, 'Reports checked'),
  ('A6', '2019-11-12', 'D6', 'P3', 81, 96, 'Sun light spots'),
  ('A7', '2020-01-29', 'D7', 'P10', 80, 87, 'Early treatment'),
  ('A8', '2019-08-12', 'D5', 'P9', 86, 92, 'Much better'),
  ('A9', '2019-05-18', 'D4', 'P14', 75, 75, 'Good heart rate'),
  ('A10', '2019-11-18', 'D3', 'P8', 76, 79, 'New teeth'),
  ('A11', '2019-06-22', 'D9', 'P11', 78, 71, 'Much better'),
  ('A12', '2020-02-21', 'D7', 'P2', 82, 86, 'Early treatment'),
  ('A13', '2019-08-17', 'D2', 'P4', 81, 101, 'Bad dreams'),
  ('A14', '2019-06-27', 'D6', 'P6', 79, 49, 'Sun light spots'),
  ('A15', '2020-07-29', 'D7', 'P10', 80, 83, 'Early treatment'),
  ('A16', '2020-08-01', 'D4', 'P7', 78, 79, 'Good heart rate');


-- Select data from the Appointment relation:
SELECT * FROM Appointment;


-- The output:


-- Create the Allegy relation:
CREATE TABLE Allergy (
  AllergyID VARCHAR(2) PRIMARY KEY,
  AllergyName VARCHAR(20) NOT NULL
);


-- Populate the Allegy relation with data:
INSERT INTO Allergy (AllergyID, AllergyName)
VALUES
  ('AL1', 'Drug'),
  ('AL2', 'Food'),
  ('AL3', 'Skin'),
  ('AL4', 'Asthma'),
  ('AL5', 'Rhinitis');


-- Select data from the Allegy relation:
SELECT * FROM Allergy;


-- The output:


-- Create the Medicine relation:
CREATE TABLE Medicine (
  MedicineID VARCHAR(2) PRIMARY KEY,
  MedicineName VARCHAR(20) NOT NULL
);


-- Populate the Medicine relation with data:
INSERT INTO Medicine (MedicineID, MedicineName)
VALUES
  ('M1', 'Ativan'),
  ('M2', 'Ibuprofen'),
  ('M3', 'Omeprazole'),
  ('M4', 'Metoprolol'),
  ('M5', 'Azithromycin'),
  ('M6', 'Codeine');


-- Select data from the Medicine relation:
SELECT * FROM Medicine;


-- The output:


-- Create the PatientAllergy relation:
CREATE TABLE PatientAllergy (
  AllergyID VARCHAR(2) NOT NULL,
  PatientID VARCHAR(2) NOT NULL,
  PRIMARY KEY (AllergyID, PatientID),
  FOREIGN KEY (AllergyID) REFERENCES Allergy(AllergyID),
  FOREIGN KEY (PatientID) REFERENCES Patient(PatientID)
);


-- Populate the PatientAllergy relation with data:
INSERT INTO PatientAllergy (AllergyID, PatientID)
VALUES
  ('AL4', 'P1'),
  ('AL2', 'P13'),
  ('AL3', 'P11'),
  ('AL4', 'P7'),
  ('AL5', 'P9'),
  ('AL1', 'P3');


-- Select data from the PatientAllergy relation:
SELECT * FROM PatientAllergy;


-- The output:


-- Create the PatientMedicine relation:
CREATE TABLE PatientMedicine (
  AppointmentID VARCHAR(2) NOT NULL,
  MedicineID VARCHAR(2) NOT NULL,
  PRIMARY KEY (AppointmentID, MedicineID),
  FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID),
  FOREIGN KEY (MedicineID) REFERENCES Medicine(MedicineID)
);


-- Populate the PatientMedicine relation with data:
INSERT INTO PatientMedicine (AppointmentID, MedicineID)
VALUES
  ('A15', 'M1'),
  ('A2', 'M6'),
  ('A8', 'M3'),
  ('A6', 'M3'),
  ('A15', 'M2'),
  ('A10', 'M6'),
  ('A10', 'M2'),
  ('A4', 'M5'),
  ('A3', 'M5'),
  ('A1', 'M2');


-- Select data from the PatientMedicine relation:
SELECT * FROM PatientMedicine;


-- The output:



-- References
-- Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M. & Danubianu, M. (2010). Database fundamentals. IBM Canada.

--  words

