package com.anucodes.trackerservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskEntity {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NonNull
    private String userId;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private Boolean status;

    public TaskEntity(@NonNull String userId, @NonNull String title, @NonNull String description, @NonNull Boolean status) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public @NonNull String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public @NonNull String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public @NonNull String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public @NonNull Boolean getStatus() {
        return status;
    }

    public void setStatus(@NonNull Boolean status) {
        this.status = status;
    }
}
