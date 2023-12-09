package uk.ac.bcu.oluwatobi.hrapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uk.ac.bcu.oluwatobi.hrapp.DataValidationException;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobApplicationDTO;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobDescriptionDTO;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobPostDTO;
import uk.ac.bcu.oluwatobi.hrapp.model.JobApplication;
import uk.ac.bcu.oluwatobi.hrapp.model.JobDescription;
import uk.ac.bcu.oluwatobi.hrapp.model.JobPost;
import uk.ac.bcu.oluwatobi.hrapp.repository.CompanyInfoRepository;
import uk.ac.bcu.oluwatobi.hrapp.repository.JobApplicationRepository;
import uk.ac.bcu.oluwatobi.hrapp.repository.JobDescriptionRepository;
import uk.ac.bcu.oluwatobi.hrapp.repository.JobPostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobDescriptionRepository jobDescriptionRepository;
    private final CompanyInfoRepository companyInfoRepository;
    private final JobPostRepository jobPostRepository;

    public JobService(JobApplicationRepository jobApplicationRepository,
                      JobDescriptionRepository jobDescriptionRepository,
                      CompanyInfoRepository companyInfoRepository,
                      JobPostRepository jobPostRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobDescriptionRepository = jobDescriptionRepository;
        this.companyInfoRepository = companyInfoRepository;
        this.jobPostRepository = jobPostRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public void createJobPost(JobPostDTO dto) throws DataValidationException, EntityNotFoundException {
        var jdRef = jobDescriptionRepository.findById(dto.getJobDescriptionID());
        if(jdRef.isEmpty()) {
          throw new DataValidationException("Job description specified does not exist");
        }
        var jobPost = new JobPost();
        jobPost.setTitle(dto.getTitle().isEmpty() ? jdRef.get().getJobTitle(): dto.getTitle());
        jobPost.setSalaryRange(dto.getSalaryRange());
        jobPost.setJobDescription(jdRef.get());
        jobPost.setCreatedDate(dto.getCreatedDate() == null ? new Date() : dto.getCreatedDate());
        jobPostRepository.save(jobPost);
    }


    public List<JobPostDTO> getAllJobPosts() {
        return jobPostRepository.getAllJobPosts();
    }

    public void saveJobApplication(JobApplicationDTO dto) throws DataValidationException {
        var postRef = jobPostRepository.findById(dto.getJobPostID());
        if(postRef.isEmpty()) {
            throw new DataValidationException("Job post with specified value does not exist!");
        }
        var jobApp = new JobApplication();
        var date = dto.getCreatedDate() != null ? dto.getCreatedDate() : new Date();
        jobApp.setCandidateEmail(dto.getCandidateEmail());
        jobApp.setCandidateName(dto.getCandidateName());
        jobApp.setResumeLink(dto.getResumeLink());
        jobApp.setJobPost(postRef.get());
        jobApp.setCreatedDate(date);
        jobApplicationRepository.save(jobApp);
    }

    public List<JobApplicationDTO> getAllJobApplications() {
        return jobApplicationRepository.getAllApplications();
    }

    public void saveJobDescription(JobDescriptionDTO dto) throws DataValidationException {
        var companyRef = companyInfoRepository.findById(dto.getCompanyID());
        if(companyRef.isEmpty()) {
            throw new DataValidationException("Company must be specified for job description");
        }
        var jd = new JobDescription();
        jd.setJobTitle(dto.getJobTitle());
        jd.setJobDescriptionFile(dto.getJobDescriptionFile());
        jd.setCompany(companyRef.get());
        jd.setCreatedDate(new Date());
        jobDescriptionRepository.save(jd);
    }

    public List<JobDescriptionDTO> getAllJobDescriptions() {
        return jobDescriptionRepository.getAllJDs();
    }


}
