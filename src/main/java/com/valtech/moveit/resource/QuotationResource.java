package com.valtech.moveit.resource;

import com.valtech.moveit.model.Quotation;
import com.valtech.moveit.service.QuotationService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Singleton
@Path("quotation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuotationResource {

    @Inject
    QuotationService quotationService;

    @POST
    public Response addQuotation(Quotation request, @Context UriInfo uriInfo) {
        Quotation quotation = quotationService.addQuotation(request);
        URI uri = uriInfo.getAbsolutePathBuilder().path("/" + quotation.getQuotationId()).build();
        return Response.created(uri).entity(quotation).build();
    }

    @GET
    @Path("{id}")
    public Response getQuotation(@PathParam("id") String quotationId) {
        Quotation quotation = quotationService.getQuotation(quotationId);
        return Response.ok().entity(quotation).build();
    }
}
