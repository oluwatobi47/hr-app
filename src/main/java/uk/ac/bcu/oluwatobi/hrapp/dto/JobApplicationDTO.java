package uk.ac.bcu.oluwatobi.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class JobApplicationDTO implements Serializable {

    private String id;

    @JsonProperty("candidate_email")
    @NotEmpty
    @Email
    private String candidateEmail;

    @NotEmpty
    @JsonProperty("candidate_name")
    private String candidateName;

    @NotEmpty
    @JsonProperty("job_post_id")
    private String jobPostID;

    @JsonProperty("job_post_title")
    private String jobPostTitle;

    @JsonProperty(value = "active")
    private boolean active = true;

    @JsonProperty("salary_range")
    private String salaryRange;

    @JsonProperty("created_date")
    private Date createdDate;

}
