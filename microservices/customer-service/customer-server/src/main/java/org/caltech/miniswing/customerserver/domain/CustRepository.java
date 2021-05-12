package org.caltech.miniswing.customerserver.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CustRepository extends JpaRepository<Cust, Long> {
    List<Cust> findByCustNmAndBirthDtOrderByCustRgstDtDesc(String custNm, LocalDate birthDt);
}
