package com.zemoga.portfolio.service.impl;

import com.zemoga.portfolio.dao.ITwitterRepository;
import com.zemoga.portfolio.service.ITwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitterServiceImpl implements ITwitterService {

    @Autowired
    ITwitterRepository twitterRepository;

    @Override
    public List<Tweet> getUserLastFiveTweets(String username) {
        return twitterRepository.getUserLastFiveTweets(username);
    }
}
