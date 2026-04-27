package io.dzung.clinic_cms.domain.appointment;

import java.time.LocalDateTime;

import io.dzung.clinic_cms.common.enums.AppointmentStatus;
import io.dzung.clinic_cms.common.model.BaseEntity;
import io.dzung.clinic_cms.domain.identity.Doctor;
import io.dzung.clinic_cms.domain.identity.Patient;
import io.dzung.clinic_cms.domain.scheduling.AvailableSlot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
public class Appointment extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id", nullable = false)
    private AvailableSlot slot;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(columnDefinition = "TEXT")
    private String prescription;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Builder
    public Appointment(Doctor doctor, Patient patient, AvailableSlot slot, LocalDateTime startTime,
            LocalDateTime endTime, String note, String prescription, AppointmentStatus status) {
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
        this.prescription = prescription;
        this.status = status != null ? status : AppointmentStatus.SCHEDULED;
    }
}
