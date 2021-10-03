package com.example.kforcepractice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FleetDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int drivers;
    private double distance;
    private double averageSpeed;
    private int workingHours;
    private double travelTime;

    public FleetDTO(int drivers, double distance, double averageSpeed, int workingHours) {
        this.drivers = drivers;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
        this.workingHours = workingHours;
    }

    public FleetDTO(int drivers, double distance, double averageSpeed, int workingHours, double travelTime) {

        this.drivers = drivers;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
        this.workingHours = workingHours;
        this.travelTime = travelTime;
    }
}
