package org.training.api.converted.converter;

import org.training.api.converted.ServiceResponse;
import org.training.api.converted.requests.ServiceRequest;

public interface Converter {
    public ServiceResponse convert(ServiceRequest request);
}
