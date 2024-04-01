package com.application.application.Models.Times;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "times")
public class Times implements Serializable {
    @Serial
    private static final long serialVersionUID = -2332958218623060491L;

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "time_ampm", nullable = false, length = 80)
    private String timeAmPm;


    @Column(name = "time_military", nullable = false, length = 80)
    private String timeMilitary;


    public Times() {
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTimeAmPm() {
        return timeAmPm;
    }

    public void setTimeAmPm(String timeAmPm) {
        this.timeAmPm = timeAmPm;
    }

    public String getTimeMilitary() {
        return timeMilitary;
    }

    public void setTimeMilitary(String timeMilitary) {
        this.timeMilitary = timeMilitary;
    }
}
