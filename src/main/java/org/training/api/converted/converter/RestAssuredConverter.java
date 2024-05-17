package org.training.api.converted.converter;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.training.api.converted.ServiceResponse;
import org.training.api.converted.requests.ServiceRequest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredConverter implements Converter {

    @Override
    public ServiceResponse convert(ServiceRequest request) {
        RequestSpecification spec = given()
                .headers(request.getHeaders());

        Map parameters = request.getParameters();

        if (parameters != null) {
            spec.queryParams(parameters);
        }
        String body = request.getBody();

        if (body != null) {
            spec.body(body);
        }
        Response response = spec.request(request.getMethod(), request.getUrl());

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setResponseCode(response.getStatusCode());

        return serviceResponse;
    }
}
