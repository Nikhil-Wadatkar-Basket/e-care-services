use mysql;

select * from Patient_Details;
delete from Patient_Details where patientid=24;
select * from spring_session;
select * from spring_session_attributes;


delete from spring_session_attributes;

select * from doctor_Details;
select * from  user_Details;
update user_details set app_create_flag = 'N' where userid=1;

update user_details set app_create_flag = 'Y' where userid=22;













alter table user_details add access_code varchar(2);

select * from Appointment_Details;
select * from Medicine_Details;

select * from Medicine_Patient;
select * from Medicine_Counter;

select * from visiting_doctor_Details;
delete from visiting_doctor_Details;

desc visiting_doctor_Details;

delete from Medicine_Patient;
delete from Medicine_Counter;

alter table Medicine_Patient add receiptDate varchar(20);


INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (1,NULL,NULL,'09:00 AM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (2,NULL,NULL,'09:30 AM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (3,NULL,NULL,'10:00 AM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (4,NULL,NULL,'10:30 AM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (5,NULL,NULL,'11:00 AM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (6,NULL,NULL,'11:30 AM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (7,NULL,NULL,'12:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (8,NULL,NULL,'12:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (9,NULL,NULL,'01:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (10,NULL,NULL,'01:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (11,NULL,NULL,'02:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (12,NULL,NULL,'02:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (13,NULL,NULL,'03:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (14,NULL,NULL,'03:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (15,NULL,NULL,'04:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (16,NULL,NULL,'04:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (17,NULL,NULL,'05:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (18,NULL,NULL,'05:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (19,NULL,NULL,'06:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (20,NULL,NULL,'06:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (21,NULL,NULL,'07:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (22,NULL,NULL,'07:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (23,NULL,NULL,'08:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (24,NULL,NULL,'08:30 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Appointment_Details (`appid`,`age`,`app_date`,`app_time`,`app_time_statue`,`blood_group`,`bp`,`city`,`contact`,`doctorid`,`doctor_name`,`fees`,`height`,`meeting_type`,`patient_name`,`sugar`,`userid`,`weight`) VALUES (25,NULL,NULL,'09:00 PM','free',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

insert into ICUDetails values(1,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (2,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (3,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (4,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (5,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (6,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (7,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (8,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (9,NULL,NULL,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (10,NULL,NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (11,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (12,NULL,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (13,NULL,NULL,13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (14,NULL,NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);
INSERT INTO ICUDetails VALUES (15,NULL,NULL,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'FREE',NULL,NULL,NULL);

INSERT INTO doctor_Details (`docid`,`appid`,`designation`,`doc_contact`,`doc_name`) VALUES (4,NULL,'MD','1234567890','Dr. Agrawal');
INSERT INTO doctor_Details VALUES (5,NULL,'MBBS','9876543211','Dr. Pathak');
INSERT INTO doctor_Details VALUES (6,NULL,'MS','9898767654','Dr. Rathi');
INSERT INTO doctor_Details VALUES (2,NULL,'MD','33','Agarwal');
INSERT INTO doctor_Details VALUES (1,NULL,'MBBS','1','Rathi');

INSERT INTO Medicine_Details  VALUES (1,'2023-05-06','Nise',100,100);
INSERT INTO Medicine_Details VALUES (2,'2023-07-26','Combiflame',20,20);
commit;