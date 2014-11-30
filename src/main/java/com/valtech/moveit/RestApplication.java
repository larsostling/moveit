package com.valtech.moveit;

import com.valtech.moveit.resource.QuotationResource;
import com.valtech.moveit.service.PricingCalculator;
import com.valtech.moveit.service.QuotationService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(QuotationResource.class, QuotationService.class, PricingCalculator.class));
    }
}
