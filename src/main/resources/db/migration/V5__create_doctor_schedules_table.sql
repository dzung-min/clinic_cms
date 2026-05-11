CREATE TABLE IF NOT EXISTS doctor_schedules (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    doctor_id BINARY(16) NOT NULL,
    monthly_plan_id BINARY(16) NOT NULL, 
    day_of_week TINYINT NOT NULL, -- 1 (Mon) to 7 (Sun)
    start_time TIME NOT NULL,     -- e.g., '09:00:00'
    end_time TIME NOT NULL,       -- e.g., '17:00:00'
    slot_duration INT DEFAULT 45, -- Duration in minutes
    buffer_time INT DEFAULT 15,   -- time for taking note, break...
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_schedule_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    CONSTRAINT fk_schedule_plan FOREIGN KEY (monthly_plan_id) REFERENCES monthly_plans(id) ON DELETE CASCADE
);