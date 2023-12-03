package uk.ac.bcu.oluwatobi.hrapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    public void createJobPost(JobPostDTO dto) throws DataValidationException {
        var jd = jobDescriptionRepository.getReferenceById(dto.getJobDescriptionID());
        if(jd == null) {
          throw new DataValidationException("Job description specified does not exist");
        }
        var jobPost = new JobPost();
        jobPost.setTitle(dto.getTitle().isEmpty() ? jd.getJobTitle(): dto.getTitle());
        jobPost.setSalaryRange(dto.getSalaryRange());
        jobPost.setJobDescription(jd);
        jobPost.setCreatedDate(dto.getCreatedDate());
        jobPostRepository.save(jobPost);
    }


    public List<JobPostDTO> getAllJobPosts() {
        return jobPostRepository.getAllJobPosts();
    }

    public void saveJobApplication(JobApplicationDTO dto) throws DataValidationException {
        var post = jobPostRepository.getReferenceById(dto.getJobPostID());
        if(post == null) {
            throw new DataValidationException("Job post with specified value does not exist!");
        }
        var mapper = new ObjectMapper();
        var jobApp = mapper.convertValue(dto, JobApplication.class);
        var date = dto.getCreatedDate() != null ? dto.getCreatedDate() : new Date();
        jobApp.setJobPost(post);
        jobApp.setCreatedDate(date);
        jobApplicationRepository.save(jobApp);
    }

    public List<JobApplicationDTO> getAllJobApplications() {
        return jobApplicationRepository.getAllApplications();
    }


    public void saveJobDescription(JobDescriptionDTO dto) throws DataValidationException {
        var company = companyInfoRepository.getReferenceById(dto.getCompanyID());
        if(company == null) {
            throw new DataValidationException("Company must be specified for job description");
        }
        var jd = new JobDescription();
        jd.setJobTitle(dto.getJobTitle());
        jd.setJobDescriptionFile(dto.getJobDescriptionFile());
        jd.setCompany(company);
        jd.setCreatedDate(new Date());
    }

    public List<JobDescriptionDTO> getAllJobDescriptions() {
        return jobDescriptionRepository.getAllJDs();
    }


}
