-- Insert sample subjects
INSERT INTO subject (subject_name)
VALUES ('Maths');
INSERT INTO subject (subject_name)
VALUES ('Science');
INSERT INTO subject (subject_name)
VALUES ('Marathi');
INSERT INTO subject (subject_name)
VALUES ('Social');
INSERT INTO subject (subject_name)
VALUES ('Kannada');
INSERT INTO subject (subject_name)
VALUES ('Hindi');
INSERT INTO subject (subject_name)
VALUES ('English');
-- Insert sample students
INSERT INTO student (roll_number, name)
VALUES ('S001', 'Rahul Sharma');
INSERT INTO student (roll_number, name)
VALUES ('S002', 'Priya Patel');
INSERT INTO student (roll_number, name)
VALUES ('S003', 'Amit Kumar');
INSERT INTO student (roll_number, name)
VALUES ('S004', 'Sneha Reddy');
INSERT INTO student (roll_number, name)
VALUES ('S005', 'Kiran Rao');
-- Insert sample marks for Monthly exam
-- Rahul Sharma
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MONTHLY', 1, 85);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MONTHLY', 2, 78);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MONTHLY', 3, 82);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MONTHLY', 4, 75);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MONTHLY', 5, 80);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MONTHLY', 6, 90);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MONTHLY', 7, 88);
-- Priya Patel
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MONTHLY', 1, 90);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MONTHLY', 2, 92);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MONTHLY', 3, 85);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MONTHLY', 4, 88);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MONTHLY', 5, 78);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MONTHLY', 6, 82);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MONTHLY', 7, 95);
-- Amit Kumar
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S003', 'MONTHLY', 1, 75);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S003', 'MONTHLY', 2, 80);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S003', 'MONTHLY', 3, 72);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S003', 'MONTHLY', 4, 78);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S003', 'MONTHLY', 5, 85);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S003', 'MONTHLY', 6, 80);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S003', 'MONTHLY', 7, 82);
-- Insert sample marks for Mid exam
-- Rahul Sharma
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MID', 1, 80);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MID', 2, 82);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MID', 3, 85);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MID', 4, 78);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MID', 5, 88);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MID', 6, 92);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S001', 'MID', 7, 90);
-- Priya Patel
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MID', 1, 95);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MID', 2, 90);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MID', 3, 88);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MID', 4, 92);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MID', 5, 85);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MID', 6, 87);
INSERT INTO marks (roll_number, exam_type, subject_id, marks)
VALUES ('S002', 'MID', 7, 94);