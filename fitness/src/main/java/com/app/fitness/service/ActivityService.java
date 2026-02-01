package com.app.fitness.service;

import com.app.fitness.dto.ActivityRequest;
import com.app.fitness.dto.ActivityResponse;
import com.app.fitness.entity.Activity;
import com.app.fitness.entity.User;
import com.app.fitness.repository.ActivityRepository;
import com.app.fitness.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityService(ActivityRepository activityRepository, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.userRepository = userRepository;
    }

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        User user = userRepository.findById(activityRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Activity activity = Activity.builder()
                .activityType(activityRequest.getActivityType())
                .duration(activityRequest.getDuration())
                .caloriesBurnt(activityRequest.getCaloriesBurnt())
                .startTime(activityRequest.getStartTime())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .updateAt(activityRequest.getUser().getUpdatedAt())
                .build();
        Activity savedActivity = activityRepository.save(activityRequest);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity savedActivity) {
        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setActivityType(savedActivity.getActivityType());
        activityResponse.setDuration(savedActivity.getDuration());
        activityResponse.setCaloriesBurnt(savedActivity.getCaloriesBurnt());
        activityResponse.setStartTime(savedActivity.getStartTime());
        activityResponse.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
        activityResponse.setUser(savedActivity.getUser());
        return activityResponse;
    }
}
