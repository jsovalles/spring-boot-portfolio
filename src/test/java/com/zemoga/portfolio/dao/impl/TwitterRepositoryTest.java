package com.zemoga.portfolio.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterRepositoryTest {

    @InjectMocks
    private TwitterRepository repository;

    @Mock
    private Twitter twitter;

    @Mock
    private TimelineOperations timelineOperations;

    @Test
    public void getUserLastFiveTweets() {
        when(twitter.timelineOperations()).thenReturn(timelineOperations);
        when(timelineOperations.getUserTimeline(any(), anyInt())).thenReturn(new ArrayList<>());
        List<Tweet> tweets = repository.getUserLastFiveTweets("GoT_Tyrion");
        assertNotNull(tweets);
    }
}