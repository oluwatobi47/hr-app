package uk.ac.bcu.oluwatobi.hrapp.service;

import org.springframework.stereotype.Service;
import uk.ac.bcu.oluwatobi.hrapp.model.CompanyInfo;
import uk.ac.bcu.oluwatobi.hrapp.repository.CompanyInfoRepository;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyInfoRepository companyInfoRepository;

    public CompanyService(CompanyInfoRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    public List<CompanyInfo> getCompanyInfo() {
        return companyInfoRepository.getAllCompanyInfo();
    }

}
