package uk.ac.bcu.oluwatobi.hrapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyInfo extends BaseModel {

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "date_founded")
    @JsonProperty("date_founded")
    private Date dateFounded;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "mission_statement")
    @JsonProperty("mission_statement")
    private String missionStatement;

    @Column(name = "company_culture_statement")
    @JsonProperty("company_culture_statement")
    private String cultureStatement;

    @Column(name = "vision")
    private String vision;
}
