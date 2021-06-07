package com.zemoga.portfolio.dao.impl;

import com.zemoga.portfolio.dao.ITwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TwitterRepository implements ITwitterRepository {

    public final static int TWEET_VALUE = 5;

    @Autowired
    private Twitter twitter;

    @Override
    public List<Tweet> getUserLastFiveTweets(String username) {

        return twitter.timelineOperations().getUserTimeline(username, TWEET_VALUE);
    }
}
