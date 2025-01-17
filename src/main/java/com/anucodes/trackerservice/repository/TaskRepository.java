package com.anucodes.trackerservice.repository;

import com.anucodes.trackerservice.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findTaskEntitiesByUserId(String userId);

}
