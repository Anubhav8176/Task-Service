package com.anucodes.trackerservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String userId;
    private String title;
    private String description;
    private Boolean status;
}
