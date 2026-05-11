CREATE TABLE IF NOT EXISTS available_slots (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    doctor_id BINARY(16) NOT NULL,
    monthly_plan_id BINARY(16) NOT NULL,
    start_time DATETIME NOT NULL, -- e.g., '2026-05-01 09:00:00'
    end_time DATETIME NOT NULL,   -- e.g., '2026-05-01 09:30:00'
    status ENUM('AVAILABLE', 'BOOKED', 'LOCKED') DEFAULT 'AVAILABLE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_slot_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    CONSTRAINT fk_slot_plan FOREIGN KEY (monthly_plan_id) REFERENCES monthly_plans(id) ON DELETE CASCADE,
    INDEX (doctor_id, start_time) -- Crucial for search performance
);