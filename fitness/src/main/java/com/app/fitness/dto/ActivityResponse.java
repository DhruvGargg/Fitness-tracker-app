package com.app.fitness.dto;

import com.app.fitness.entity.Activity;
import com.app.fitness.entity.User;
import com.app.fitness.enums.ActivityType;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse {

    private String id;
    private User user;
    private ActivityType activityType;
    private Map<String, Object> additionalMetrics;
    private Integer duration;
    private Integer caloriesBurnt;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
