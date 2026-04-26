package io.dzung.clinic_cms.model;

import io.dzung.clinic_cms.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private Boolean isActive;

    @Builder
    public User(String firstName, String lastName, String phone, String email, Role role, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }
}
