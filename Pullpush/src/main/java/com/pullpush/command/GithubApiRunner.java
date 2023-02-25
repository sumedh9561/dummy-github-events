package com.pullpush.command;
import com.pullpush.Client.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pullpush.Client.GithubApiClient;
@Component
public class GithubApiRunner implements CommandLineRunner {

    private final GithubApiClient githubApiClient;

    public GithubApiRunner(GithubApiClient githubApiClient) {
        this.githubApiClient = githubApiClient;
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	githubApiClient.listCommits("dummy-github-events");
    	
    }
}
