# --- !Ups
ALTER TABLE user ADD role VARCHAR(50) DEFAULT 'Student';

# --- !Downs
ALTER TABLE user DROP COLUMN role;