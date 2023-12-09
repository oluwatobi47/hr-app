package uk.ac.bcu.oluwatobi.hrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobApplicationDTO;
import uk.ac.bcu.oluwatobi.hrapp.model.JobApplication;

import java.util.List;

@Repository
public interface JobApplicationRepository extends CrudRepository<JobApplication, String> {

    @Query("select new uk.ac.bcu.oluwatobi.hrapp.dto.JobApplicationDTO(j.id, j.candidateEmail, j.candidateName, j.jobPost.id, j.jobPost.title, j.active, j.createdDate, j.resumeLink) from JobApplication j")
    public List<JobApplicationDTO> getAllApplications();
}
