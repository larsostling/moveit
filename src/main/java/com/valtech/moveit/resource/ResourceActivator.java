package com.valtech.moveit.resource;

import com.valtech.moveit.service.PricingCalculator;
import com.valtech.moveit.service.QuotationService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ResourceActivator extends Application {
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(
                Arrays.asList(QuotationResource.class, QuotationService.class, PricingCalculator.class));
    }
}
