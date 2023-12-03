package uk.ac.bcu.oluwatobi.hrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobDescriptionDTO;
import uk.ac.bcu.oluwatobi.hrapp.model.JobDescription;

import java.util.List;

@Repository
public interface JobDescriptionRepository extends JpaRepository<JobDescription, String> {
    @Query("select new uk.ac.bcu.oluwatobi.hrapp.dto.JobDescriptionDTO(j.id, j.company.id, j.jobTitle, j.jobDescriptionFile, j.createdDate) from JobDescription j")
    List<JobDescriptionDTO> getAllJDs();
}
