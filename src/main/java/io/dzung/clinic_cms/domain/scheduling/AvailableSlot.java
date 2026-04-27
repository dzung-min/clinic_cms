package io.dzung.clinic_cms.domain.scheduling;

import java.time.LocalDateTime;

import io.dzung.clinic_cms.common.enums.SlotStatus;
import io.dzung.clinic_cms.common.model.BaseEntity;
import io.dzung.clinic_cms.domain.identity.Doctor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "available_slots")
@Getter
@Setter
@NoArgsConstructor
public class AvailableSlot extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_plan_id", nullable = false)
    private MonthlyPlan monthlyPlan;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private SlotStatus status;

    @Builder
    public AvailableSlot(Doctor doctor, MonthlyPlan monthlyPlan, LocalDateTime startTime, LocalDateTime endTime,
            SlotStatus status) {
        this.doctor = doctor;
        this.monthlyPlan = monthlyPlan;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status != null ? status : SlotStatus.AVAILABLE;
    }
}
