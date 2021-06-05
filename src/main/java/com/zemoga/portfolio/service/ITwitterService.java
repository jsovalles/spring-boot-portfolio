package com.zemoga.portfolio.service;

import org.springframework.social.twitter.api.Tweet;

import java.util.List;

public interface ITwitterService {
    List<Tweet> getUserLastFiveTweets(String username);
}
