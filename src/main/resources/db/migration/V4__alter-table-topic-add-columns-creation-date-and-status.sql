-- Alter table to add creation_date and status columns
ALTER TABLE topic
ADD creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
ADD status VARCHAR(20) DEFAULT 'OPEN' NOT NULL;
