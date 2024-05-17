package org.training.api.converted;

import org.training.api.converted.converter.Converter;
import org.training.api.converted.requests.ServiceRequest;

public class RequestConductor {
    private final Converter converter;

    public RequestConductor(Converter converter) {
        this.converter = converter;
    }

    public ServiceResponse execute(ServiceRequest request) {
        return converter.convert(request);
    }
}
