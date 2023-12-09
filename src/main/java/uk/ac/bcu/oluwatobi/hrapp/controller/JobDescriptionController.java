package uk.ac.bcu.oluwatobi.hrapp.controller;

import org.springframework.web.bind.annotation.*;
import uk.ac.bcu.oluwatobi.hrapp.dto.DataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.IDataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobDescriptionDTO;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobPostDTO;
import uk.ac.bcu.oluwatobi.hrapp.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/job-description")
public class JobDescriptionController {
    private final JobService jobService;

    public JobDescriptionController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public IDataResponse<List<JobDescriptionDTO>> getJobDescriptions() {
        return new DataResponse<>(jobService.getAllJobDescriptions(), true);
    }

    @PostMapping()
    public IDataResponse<?> createJobDescription(@RequestBody JobDescriptionDTO dto) {
        jobService.saveJobDescription(dto);
        return new DataResponse<>(true, "Created Successfully!");
    }
}
