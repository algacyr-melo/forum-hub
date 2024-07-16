-- Create topic table with embedded author and course information
CREATE TABLE topic (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    author_username VARCHAR(50) NOT NULL UNIQUE,
    author_display_name VARCHAR(100),
    course_id VARCHAR(10) NOT NULL,
    course_name VARCHAR(100) NOT NULL
);
