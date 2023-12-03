package uk.ac.bcu.oluwatobi.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class JobPostDTO implements Serializable {

    private String id;

    @JsonProperty("title")
    private String title;

    @NotEmpty
    @JsonProperty("job_description_id")
    private String jobDescriptionID;

    private boolean active = true;

    @NotEmpty
    @JsonProperty("salary_range")
    private String salaryRange;

    @JsonProperty("created_date")
    private Date createdDate;
}
