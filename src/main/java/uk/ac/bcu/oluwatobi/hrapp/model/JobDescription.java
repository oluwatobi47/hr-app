package uk.ac.bcu.oluwatobi.hrapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class JobDescription extends BaseModel {
    @JsonProperty("company_id")
    @JoinColumn(name = "company_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CompanyInfo company;

    @JsonProperty("job_title")
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @JsonProperty("job_description_file")
    @Column(name = "job_description_file", nullable = false)
    private String jobDescriptionFile;
}
