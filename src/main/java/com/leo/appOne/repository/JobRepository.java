package com.leo.appOne.repository;

import com.leo.appOne.controller.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
