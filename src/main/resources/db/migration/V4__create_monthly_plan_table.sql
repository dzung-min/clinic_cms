CREATE TABLE IF NOT EXISTS monthly_plans (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    doctor_id BINARY(16) NOT NULL,
    target_month TINYINT NOT NULL, -- 1 to 12
    target_year INT NOT NULL, -- eg. 2026
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_plan_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    CONSTRAINT uq_doctor_month_year UNIQUE (doctor_id, target_month, target_year)
);