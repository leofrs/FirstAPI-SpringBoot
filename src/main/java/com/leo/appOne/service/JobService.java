package com.leo.appOne.service;

import com.leo.appOne.controller.Job;
import com.leo.appOne.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

interface jobServiceInterface {
    void createJobs(Job job);
    Job getJobsById(Long id);
    boolean deleteById(Long Id);
}

@Service
public class JobService implements jobServiceInterface {

    JobRepository jobRepository;
    Long id = 1L;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void createJobs(Job job) {
        try {
            job.setId(id++);
            jobRepository.save(job);
        } catch (Exception e) {
            System.out.println("O erro encontrado internamente ao criar foi: " + e);
        }

    }

    @Override
    public Job getJobsById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long Id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return  false;
        }
    };
}
