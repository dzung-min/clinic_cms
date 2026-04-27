package io.dzung.clinic_cms.domain.identity;

import io.dzung.clinic_cms.common.enums.Role;
import io.dzung.clinic_cms.common.model.BaseEntity;
import jakarta.persistence.Column;
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
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String phone;

    @Column(nullable = false)
    private String email;
    
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(nullable = false)
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