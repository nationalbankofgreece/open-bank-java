// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
package com.sourcelair.openbankjava;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JavaSample {
    public static void main(String[] args) {
        String resourcePath = "/api/banks/rest";

        try {
            HttpResponse response = getResource(resourcePath);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("Wrong URI \"" + resourcePath + "\" given:\n" + e.getMessage());
        }
    }

    private static HttpResponse getResource(String resourcePath)
        throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder(
            "https://nbgdemo.azure-api.net/nodeopenapi" + resourcePath);
        URI uri = builder.build();

        HttpGet request = new HttpGet(uri);
        addHeaders(request);

        HttpClient httpclient = HttpClients.createDefault();
        return httpclient.execute(request);
    }

    private static void addHeaders(HttpRequestBase request) {
        String nbgApiKey = System.getenv().get("NBG_SECONDARY_KEY");
        request.setHeader("Ocp-Apim-Subscription-Key", nbgApiKey);
        request.setHeader("Content-Type", "application/json");
    }
}
