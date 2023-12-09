package uk.ac.bcu.oluwatobi.hrapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobPostDTO;
import uk.ac.bcu.oluwatobi.hrapp.model.JobPost;

import java.util.List;

@Repository
public interface JobPostRepository extends CrudRepository<JobPost, String> {

    @Query("select new uk.ac.bcu.oluwatobi.hrapp.dto.JobPostDTO(j.id, j.title, j.jobDescription.id, j.active, j.salaryRange, j.createdDate) from JobPost j")
    List<JobPostDTO> getAllJobPosts();
}
