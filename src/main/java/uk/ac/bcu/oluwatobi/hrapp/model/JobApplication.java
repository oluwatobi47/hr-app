package uk.ac.bcu.oluwatobi.hrapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class JobApplication extends BaseModel{

    @NotEmpty
    @Column(name = "candidate_email", nullable = false)
    private String candidateEmail;

    @NotEmpty
    @Column(name = "candidate_name", nullable = false)
    private String candidateName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_post_id", nullable = false)
    private JobPost jobPost;

    @Column(name = "active")
    private boolean active = true;

    @NotEmpty
    @Column(name = "resume_link", nullable = false)
    private String resumeLink;

}
