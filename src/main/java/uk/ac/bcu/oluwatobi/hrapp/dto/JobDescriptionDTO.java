package uk.ac.bcu.oluwatobi.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import uk.ac.bcu.oluwatobi.hrapp.model.CompanyInfo;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class JobDescriptionDTO implements Serializable {

    private String id;

    @JsonProperty("company_id")
    @NotEmpty
    private String companyID;

    @JsonProperty("job_title")
    @NotEmpty
    private String jobTitle;

    @JsonProperty("job_description_file")
    @NotEmpty
    private String jobDescriptionFile;

    @JsonProperty("created_date")
    private Date createdDate;
}
