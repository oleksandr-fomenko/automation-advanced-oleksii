package org.training.api.converted.converter;

import lombok.SneakyThrows;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.training.api.converted.ServiceResponse;
import org.training.api.converted.requests.ServiceRequest;

import java.util.Map;


public class HttpClientConverter implements Converter {
    @Override
    @SneakyThrows
    public ServiceResponse convert(ServiceRequest request) {
        String url = request.getUrl();

        HttpUriRequestBase clientRequest = switch (request.getMethod()) {
            case "PUT" -> new HttpPut(url);
            case "POST" -> new HttpPost(url);
            case "DELETE" -> new HttpDelete(url);
            default -> new HttpGet(url);
        };

        Map headersMap = request.getHeaders();

        for (Object key : headersMap.keySet()) {
            clientRequest.setHeader((String) key, headersMap.get(key));
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(clientRequest)) {

            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setResponseCode(response.getCode());

            return serviceResponse;
        }
    }
}
