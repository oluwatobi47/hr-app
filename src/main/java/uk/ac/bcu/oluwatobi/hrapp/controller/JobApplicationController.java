package uk.ac.bcu.oluwatobi.hrapp.controller;

import org.springframework.web.bind.annotation.*;
import uk.ac.bcu.oluwatobi.hrapp.dto.DataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.IDataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobApplicationDTO;
import uk.ac.bcu.oluwatobi.hrapp.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/job-application")
public class JobApplicationController {

    private final JobService jobService;

    public JobApplicationController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public IDataResponse<List<JobApplicationDTO>> getJobApplications() {
        return new DataResponse<>(jobService.getAllJobApplications(), true);
    }

    @PostMapping()
    public IDataResponse<?> createJobApplication(@RequestBody JobApplicationDTO dto) {
        jobService.saveJobApplication(dto);
        return new DataResponse<>(true, "Created Successfully!");
    }
}
