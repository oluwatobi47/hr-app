package uk.ac.bcu.oluwatobi.hrapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class JobPost extends BaseModel{

    @Column(name = "title")
    private String title;

    @ManyToOne
    @NotFound(action = NotFoundAction.EXCEPTION)
    @JoinColumn(name = "job_description_id", nullable = false)
    private JobDescription jobDescription;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "salary_range")
    private String salaryRange;
}
