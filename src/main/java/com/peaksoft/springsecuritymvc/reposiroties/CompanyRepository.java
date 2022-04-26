package com.peaksoft.springsecuritymvc.reposiroties;

import com.peaksoft.springsecuritymvc.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}