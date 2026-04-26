CREATE TABLE monthly_plans (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    doctor_id BINARY(16) NOT NULL,
    target_month TINYINT NOT NULL, -- 1 to 12
    target_year INT NOT NULL, -- eg. 2026
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
    CONSTRAINT fk_plan_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    CONSTRAINT uq_doctor_month_year UNIQUE (doctor_id, target_month, target_year)
);

CREATE TABLE doctor_schedules (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    doctor_id BINARY(16) NOT NULL,
    monthly_plan_id BINARY(16) NOT NULL, 
    day_of_week TINYINT NOT NULL, -- 1 (Mon) to 7 (Sun)
    start_time TIME NOT NULL,     -- e.g., '09:00:00'
    end_time TIME NOT NULL,       -- e.g., '17:00:00'
    slot_duration INT DEFAULT 45, -- Duration in minutes
    buffer_time INT DEFAULT 15,   -- time for taking note, break...
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
    CONSTRAINT fk_schedule_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    CONSTRAINT fk_schedule_plan FOREIGN KEY (monthly_plan_id) REFERENCES monthly_plan(id) ON DELETE CASCADE
);

CREATE TABLE available_slots (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    doctor_id BINARY(16) NOT NULL,
    monthly_plan_id BINARY(16) NOT NULL,
    start_time DATETIME NOT NULL, -- e.g., '2026-05-01 09:00:00'
    end_time DATETIME NOT NULL,   -- e.g., '2026-05-01 09:30:00'
    status ENUM('AVAILABLE', 'BOOKED', 'LOCKED') DEFAULT 'AVAILABLE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
    CONSTRAINT fk_slot_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    CONSTRAINT fk_slot_plan FOREIGN KEY (monthly_plan_id) REFERENCES monthly_plan(id) ON DELETE CASCADE,
    INDEX (doctor_id, start_time) -- Crucial for search performance
);