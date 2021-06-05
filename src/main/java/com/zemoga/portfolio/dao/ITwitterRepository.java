package com.zemoga.portfolio.dao;

import org.springframework.social.twitter.api.Tweet;

import java.util.List;

public interface ITwitterRepository {
    List<Tweet> getUserLastFiveTweets(String username);
}
