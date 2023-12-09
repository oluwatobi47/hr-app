package uk.ac.bcu.oluwatobi.hrapp.controller;

import org.springframework.web.bind.annotation.*;
import uk.ac.bcu.oluwatobi.hrapp.dto.DataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.IDataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.JobDescriptionDTO;
import uk.ac.bcu.oluwatobi.hrapp.model.CompanyInfo;
import uk.ac.bcu.oluwatobi.hrapp.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public IDataResponse<List<CompanyInfo>> getCompanyInfo() {
        return new DataResponse<>(companyService.getCompanyInfo());
    }

}
