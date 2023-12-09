package uk.ac.bcu.oluwatobi.hrapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.ac.bcu.oluwatobi.hrapp.model.CompanyInfo;

import java.util.List;

@Repository
public interface CompanyInfoRepository extends CrudRepository<CompanyInfo, String> {
    @Query("select i from CompanyInfo i where i.id = ?1")
    CompanyInfo getCompanyInfoById(String s);

    @Query("select i from CompanyInfo i")
    List<CompanyInfo> getAllCompanyInfo();
}
