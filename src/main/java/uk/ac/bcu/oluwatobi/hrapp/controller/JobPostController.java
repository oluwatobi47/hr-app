package uk.ac.bcu.oluwatobi.hrapp.controller;

import org.springframework.web.bind.annotation.*;
import uk.ac.bcu.oluwatobi.hrapp.dto.DataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.IDataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobPostDTO;
import uk.ac.bcu.oluwatobi.hrapp.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/job-post")
public class JobPostController {
    private final JobService jobService;

    public JobPostController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/all")
    public IDataResponse<List<JobPostDTO>> getJobPosts() {
        return new DataResponse<>(jobService.getAllJobPosts(), true);
    }

    @PostMapping()
    public IDataResponse<?> createJobPost(@RequestBody JobPostDTO dto) {
        jobService.createJobPost(dto);
        return new DataResponse<>(true, "Created Successfully!");
    }
}
