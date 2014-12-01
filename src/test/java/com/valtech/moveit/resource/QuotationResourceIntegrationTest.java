package com.valtech.moveit.resource;

import com.valtech.moveit.RestApplication;
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

import static com.valtech.moveit.TestHelper.assertThatActualQuotationEqualsExpectedQuotation;
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
                .addClass(RestApplication.class)
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
        Quotation quotation = new Quotation("rName", "rEmail", "fromAddress", "toAddress", 49, 0, 0, false);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).
                post(Entity.entity(quotation, MediaType.APPLICATION_JSON));
        assertThat(response.getStatus(), is(Response.Status.CREATED.getStatusCode()));
        assertThat(response.getLocation(), is(notNullValue()));
        assertThat(response.getLocation().toString(), startsWith(deploymentUrl.toString()));

        Quotation returnedQuotation = response.readEntity(Quotation.class);
        assertThatActualQuotationEqualsExpectedQuotation(returnedQuotation, quotation);
        assertThat(returnedQuotation.getPrice(), is(1490));
        assertThat(returnedQuotation.getQuotationId(), is(notNullValue()));
    }

    @Test
    public void getQuotationById() {
        Quotation quotation = new Quotation("rName", "rEmail", "fromAddress", "toAddress", 49, 0, 0, false);
        Response response = webTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(quotation, MediaType.APPLICATION_JSON));
        Quotation addedQuotation = response.readEntity(Quotation.class);
        Quotation returnedQuotation = client.target(response.getLocation())
                .request().accept(MediaType.APPLICATION_JSON).get(Quotation.class);
        assertThatActualQuotationEqualsExpectedQuotation(returnedQuotation, addedQuotation);
        assertThat(returnedQuotation.getPrice(), is(1490));
        assertThat(returnedQuotation.getQuotationId(), is(addedQuotation.getQuotationId()));
    }
}
