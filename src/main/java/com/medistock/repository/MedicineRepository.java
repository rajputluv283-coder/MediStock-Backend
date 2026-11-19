
package com.medistock.repository;

import com.medistock.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    List<Medicine> findByQuantityLessThan(Integer quantity);

    List<Medicine> findByExpiryDateBefore(LocalDate date);

    @Query("SELECT m FROM Medicine m WHERE m.expiryDate BETWEEN :today AND :futureDate")
    List<Medicine> findExpiringSoon(
            @Param("today") LocalDate today,
            @Param("futureDate") LocalDate futureDate
    );
}
