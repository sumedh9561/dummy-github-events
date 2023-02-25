package com.pullpush.Client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;

public class GithubApiClient {

    private static final Logger logger = LoggerFactory.getLogger(GithubApiClient.class);

    private final OkHttpClient httpClient;
    private final String authToken;
    private final String apiUrl;

    public GithubApiClient(@Value("${github.api.token}") String authToken, @Value("${github.api.url}") String apiUrl) {
        this.httpClient = new OkHttpClient();
        this.authToken = authToken;
        this.apiUrl = apiUrl;
    }

    public void listCommits(String repositoryName) throws IOException {
    	 Request request = new Request.Builder()
                 .url(apiUrl + "/repos/" + repositoryName + "/commits")
                 .header("Authorization", "Bearer " + authToken)
                 .build();
    	 try (Response response = httpClient.newCall(request).execute()) {
    	        if (!response.isSuccessful()) {
    	            throw new IOException("Unexpected code " + response);
    	        }

    	        String responseBody = response.body().string();
    	        logger.info("List of commits for repository {}: {}", repositoryName, responseBody);
    	    }
    	}
}
    	 
    	 
