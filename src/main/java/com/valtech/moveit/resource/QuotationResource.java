package com.valtech.moveit.resource;

import com.valtech.moveit.model.Quotation;
import com.valtech.moveit.service.QuotationService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Singleton
@Path("quotation")
public class QuotationResource {

    @Inject
    QuotationService quotationService;

    @POST
    public Response addQuotation(Quotation request, @Context UriInfo uriInfo) {
        Quotation quotation = quotationService.addQuotation(request);
        URI uri = uriInfo.getAbsolutePathBuilder().path("/" + quotation.getQuotationId()).build();
        JsonObject response = convertToJsonObject(quotation);
        return Response.created(uri).entity(response).build();
    }

    private JsonObject convertToJsonObject(Quotation quotation) {
        return Json.createObjectBuilder().
                add("distanceInKilometers", quotation.getDistanceInKilometers()).
                add("areaInSquareMeters", quotation.getAreaInSquareMeters()).
                add("storageAreaInSquareMeters", quotation.getStorageAreaInSquareMeters()).
                add("includePiano", quotation.getIncludePiano()).
                add("price", quotation.getPrice()).
                add("quotationId", quotation.getQuotationId()).build();
    }
}
