package helpers;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class IntApiHelper {
    private static IntApiHelper intApiHelper;

    private String apiUrl;
    private HttpClient httpClient;

    private IntApiHelper(String apiUrl, HttpClient httpClient) {
        this.apiUrl = apiUrl;
        this.httpClient = httpClient;
    }

    public static void init(String apiUrl, String apiUser, String apiPass) {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(apiUser, apiPass);
        provider.setCredentials(AuthScope.ANY, credentials);

        HttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();

        intApiHelper = new IntApiHelper(apiUrl, httpClient);
    }

    public static String createRequest(String customerCode, String description, String email, String firstName, String lastName,
                                       String orderReference, String requestType, String shipmentReference, String username) {
        try {
            HttpPost httpPost = new HttpPost(intApiHelper.apiUrl);

            JSONObject requestData = new JSONObject();
            requestData.put("customerCode", customerCode);
            requestData.put("description", description);
            requestData.put("email", email);
            requestData.put("firstName", firstName);
            requestData.put("lastName", lastName);
            requestData.put("orderReference", orderReference);
            requestData.put("requestType", requestType);
            requestData.put("shipmentReference", shipmentReference);
            requestData.put("username", username);

            httpPost.setEntity(new StringEntity(requestData.toString()));
            httpPost.setHeader(org.apache.http.HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());

            HttpResponse response = intApiHelper.httpClient.execute(httpPost);

            String respBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("Error creating request through int_api: " + respBody);
            } else {
                return respBody;
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error creating request through int_api", ex);
        }
    }
}
