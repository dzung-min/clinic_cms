package io.dzung.clinic_cms.domain.scheduling;

import java.util.ArrayList;
import java.util.List;

import io.dzung.clinic_cms.common.model.BaseEntity;
import io.dzung.clinic_cms.domain.identity.Doctor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "monthly_plans")
@Getter
@Setter
@NoArgsConstructor
public class MonthlyPlan extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    
    @Column(columnDefinition = "TINYINT", nullable = false)
    private Integer targetMonth;

    @Column(nullable = false)
    private Integer targetYear;

    @OneToMany(mappedBy = "monthlyPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DoctorSchedule> schedules = new ArrayList<>();

    @Builder
    public MonthlyPlan(Doctor doctor, Integer targetMonth, Integer targetYear, List<DoctorSchedule> schedules) {
        this.doctor = doctor;
        this.targetMonth = targetMonth;
        this.targetYear = targetYear;
        if (schedules != null) this.schedules = schedules;
    }
}
