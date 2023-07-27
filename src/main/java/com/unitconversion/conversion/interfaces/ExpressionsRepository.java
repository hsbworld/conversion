package com.unitconversion.conversion.interfaces;

import com.unitconversion.conversion.entities.Expressions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpressionsRepository extends JpaRepository<Expressions, String> {
//    Optional<Object> findById();
//      Optional<Object> findById(String conversionType);
}
