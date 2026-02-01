package com.app.fitness.repository;

import com.app.fitness.dto.ActivityRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository {

    void save(ActivityRequest activityRequest);
}
