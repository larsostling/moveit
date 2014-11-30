package com.valtech.moveit.resource;

import com.valtech.moveit.model.Quotation;
import com.valtech.moveit.service.PricingCalculator;
import com.valtech.moveit.service.QuotationService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
@RunAsClient
public class QuotationResourceIntegrationTest {

    private static final String QUOTATION_RESOURCE_PATH = "/rest/quotation";

    private WebTarget webTarget;
    private Client client;

    @ArquillianResource
    URL deploymentUrl;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(Quotation.class)
                .addClass(QuotationResource.class)
                .addClass(ResourceActivator.class)
                .addClass(QuotationService.class)
                .addClass(PricingCalculator.class);
    }

    @Before
    public void setUp() throws URISyntaxException {
        this.client = ClientBuilder.newBuilder().build();
        this.webTarget = client.target(deploymentUrl.toExternalForm() + QUOTATION_RESOURCE_PATH);
    }

    @Test
    public void addQuotation() {
        Quotation quotation = new Quotation(49, 0, 0, false);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).
                post(Entity.entity(quotation, MediaType.APPLICATION_JSON));
        assertThat(response.getStatus(), is(Response.Status.CREATED.getStatusCode()));
        assertThat(response.getLocation(), is(notNullValue()));
        assertThat(response.getLocation().toString(), startsWith(deploymentUrl.toString()));

        Quotation returnedQuotation = response.readEntity(Quotation.class);
        assertThat(returnedQuotation.getDistanceInKilometers(), is(quotation.getDistanceInKilometers()));
        assertThat(returnedQuotation.getAreaInSquareMeters(), is(quotation.getAreaInSquareMeters()));
        assertThat(returnedQuotation.getStorageAreaInSquareMeters(), is(quotation.getStorageAreaInSquareMeters()));
        assertThat(returnedQuotation.getIncludePiano(), is(quotation.getIncludePiano()));
        assertThat(returnedQuotation.getPrice(), is(1490));
        assertThat(returnedQuotation.getQuotationId(), is(notNullValue()));
    }
}
