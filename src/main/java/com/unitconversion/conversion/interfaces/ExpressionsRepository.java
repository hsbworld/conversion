package com.unitconversion.conversion.interfaces;

import com.unitconversion.conversion.entities.Expressions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpressionsRepository extends JpaRepository<Expressions, String> {
}
