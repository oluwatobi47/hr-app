package uk.ac.bcu.oluwatobi.hrapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class JobPost extends BaseModel{

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "job_description_id")
    private JobDescription jobDescription;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "salary_range")
    private String salaryRange;
}
