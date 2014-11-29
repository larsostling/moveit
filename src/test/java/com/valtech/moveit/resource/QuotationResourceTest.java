package com.valtech.moveit.resource;

import com.valtech.moveit.model.Quotation;
import org.junit.Before;
import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class QuotationResourceTest {

    private QuotationResource underTest;

    @Before
    public void setUp() {
        underTest = new QuotationResource();
    }

    @Test
    public void addQuotation() {
        Quotation quotation = new Quotation(49, 0, 0, false);
        Response response = underTest.addQuotation(quotation);
        assertThat(response.getStatus(), is(Response.Status.CREATED));
        assertThat(response.getMediaType(), is(MediaType.APPLICATION_JSON));
        JsonObject json = (JsonObject) response.getEntity();
        assertThat(json.getInt("distanceInKilometers"), is(quotation.getDistanceInKilometers()));
        assertThat(json.getInt("areaInSquareMeters"), is(quotation.getAreaInSquareMeters()));
        assertThat(json.getInt("storageAreaInKilometers"), is(quotation.getStorageAreaInSquareMeters()));
        assertThat(json.getBoolean("includePiano"), is(quotation.isIncludePiano()));
        assertThat(json.getString("quotationId"), is(notNullValue()));
        assertThat(json.getInt("price"), is(1100));
    }
}
