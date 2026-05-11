CREATE TABLE IF NOT EXISTS users (
    -- Using BINARY(16) for performance or CHAR(36) for readability --
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())), 
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE, -- Added Unique Constraint --
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'DOCTOR', 'PATIENT') NOT NULL DEFAULT 'PATIENT', -- Uppercase for Spring Security --
    is_active BOOLEAN DEFAULT TRUE, -- For soft deleting the User itself --
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);