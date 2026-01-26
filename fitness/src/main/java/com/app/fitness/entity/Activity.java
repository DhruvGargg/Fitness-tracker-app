package com.app.fitness.entity;

import com.app.fitness.enums.ActivityType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_user"))
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Recommendation> recommendations = new ArrayList<>();

    private Integer duration;
    private Integer caloriesBurnt;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String, Object> additionalMetrics;
}
