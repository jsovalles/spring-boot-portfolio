package com.zemoga.portfolio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@SpringBootApplication
public class PortfolioApplication {

	@Value("${twitter.apiKey}")
	private String consumerKey;

	@Value("${twitter.secretKey}")
	private String consumerSecret;

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Bean
	public Twitter restTemplate() {
		return new TwitterTemplate(consumerKey, consumerSecret);
	}
}
