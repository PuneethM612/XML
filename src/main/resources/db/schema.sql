-- Drop tables if they exist
DROP TABLE IF EXISTS marks;
DROP TABLE IF EXISTS subject;
DROP TABLE IF EXISTS student;
-- Create student table
CREATE TABLE IF NOT EXISTS student (
    roll_number VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
-- Create subject table
CREATE TABLE IF NOT EXISTS subject (
    subject_id SERIAL PRIMARY KEY,
    subject_name VARCHAR(50) NOT NULL
);
-- Create marks table
CREATE TABLE IF NOT EXISTS marks (
    mark_id SERIAL PRIMARY KEY,
    roll_number VARCHAR(20) NOT NULL,
    exam_type VARCHAR(20) NOT NULL,
    subject_id INTEGER NOT NULL,
    marks INTEGER NOT NULL,
    FOREIGN KEY (roll_number) REFERENCES student(roll_number),
    FOREIGN KEY (subject_id) REFERENCES subject(subject_id)
);