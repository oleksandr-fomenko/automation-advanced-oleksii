package org.training.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.training.BaseTest;
import org.training.api.converted.RequestConductor;
import org.training.api.converted.ServiceResponse;
import org.training.api.converted.converter.Converter;
import org.training.api.converted.converter.HttpClientConverter;
import org.training.api.converted.converter.RestAssuredConverter;
import org.training.api.converted.ServiceRequestBuilder;
import org.training.api.converted.requests.GetAllLaunchesServiceRequest;
import org.training.api.converted.requests.ServiceRequest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchesServiceTestsWithConverter extends BaseTest {

    static final protected Logger LOGGER = LogManager.getLogger(LaunchesServiceTestsWithConverter.class);

    static Stream<Converter> converters() {
        return Stream.of(
                new RestAssuredConverter(),
                new HttpClientConverter()
        );
    }

    @ParameterizedTest
    @DisplayName("Launches Service basic Get request check")
    @MethodSource("converters")
    public void checkGetLaunchesServiceResponse(Converter converter) {
        ServiceRequest request = new ServiceRequestBuilder(configHelper, new GetAllLaunchesServiceRequest(configHelper))
                .build();

        ServiceResponse response = new RequestConductor(converter).execute(request);
        assertEquals(200, response.getResponseCode());

        LOGGER.info("Get Launches Service test passed.");
    }
}
