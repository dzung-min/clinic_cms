package io.dzung.clinic_cms.domain.scheduling;

import java.time.LocalTime;

import io.dzung.clinic_cms.common.model.BaseEntity;
import io.dzung.clinic_cms.domain.identity.Doctor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_schedules")
@Getter
@Setter
@NoArgsConstructor
public class DoctorSchedule extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_plan_id")
    private MonthlyPlan monthlyPlan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer dayOfWeek;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private Integer slotDuration;

    @Column(nullable = false)
    private Integer bufferTime;

    @Builder
    public DoctorSchedule(Doctor doctor, MonthlyPlan monthlyPlan, Integer dayOfWeek, LocalTime startTime,
            LocalTime endTime, Integer slotDuration, Integer bufferTime) {
        this.doctor = doctor;
        this.monthlyPlan = monthlyPlan;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotDuration = slotDuration != null ? slotDuration : 45;
        this.bufferTime = bufferTime != null ? bufferTime : 15;
    }
}
