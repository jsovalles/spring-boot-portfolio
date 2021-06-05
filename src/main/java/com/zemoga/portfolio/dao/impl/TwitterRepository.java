package com.zemoga.portfolio.dao.impl;

import com.zemoga.portfolio.dao.ITwitterRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TwitterRepository implements ITwitterRepository {

    public final static int TWEET_VALUE = 5;

    @Value("${twitter.apiKey}")
    private String consumerKey;

    @Value("${twitter.secretKey}")
    private String consumerSecret;

    @Override
    public List<Tweet> getUserLastFiveTweets(String username) {
        Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret);
        return twitter.timelineOperations().getUserTimeline(username, TWEET_VALUE);
    }
}
