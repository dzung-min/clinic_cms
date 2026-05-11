CREATE TABLE IF NOT EXISTS doctors (
    id BINARY(16) PRIMARY KEY,
    specialty VARCHAR(100) NOT NULL,
    bio TEXT,
    years_of_experience INT DEFAULT 0,
    CONSTRAINT fk_doctor_user FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);