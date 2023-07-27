package com.unitconversion.conversion.service;

import com.unitconversion.conversion.entities.Expressions;
import com.unitconversion.conversion.interfaces.ExpressionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressionsService {

    private final ExpressionsRepository expressionsRepository;

    @Autowired
    public ExpressionsService(ExpressionsRepository expressionsRepository) {
        this.expressionsRepository = expressionsRepository;
    }

    public Expressions getExpression(String conversionType) {
        return expressionsRepository.findById(conversionType).orElse(null);
    }

}
