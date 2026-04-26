package io.dzung.clinic_cms.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {
    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String specialty;
    private String bio;
    private int yearsOfExperience;

    @Builder
    public Doctor(User user, String specialty, String bio, int yearsOfExperience) {
        this.user = user;
        this.specialty = specialty;
        this.bio = bio;
        this.yearsOfExperience = yearsOfExperience;
    }

    
}
