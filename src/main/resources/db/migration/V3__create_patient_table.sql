CREATE TABLE patients (
    id BINARY(16) PRIMARY KEY,
    date_of_birth DATE,
    CONSTRAINT fk_patient_user FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);