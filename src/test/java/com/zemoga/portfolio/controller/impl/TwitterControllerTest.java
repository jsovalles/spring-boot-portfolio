package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.service.impl.TwitterServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerTest {

    @InjectMocks
    private TwitterController controller;

    @Mock
    private TwitterServiceImpl service;

    @Test
    public void getUserLastFiveTweetsOkResponse() {
        when(service.getUserLastFiveTweets(any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<Tweet>> tweets = controller.getUserLastFiveTweets("GoT_Tyrion");
        Assert.assertNotNull(tweets);
        Assert.assertEquals(tweets.getStatusCode(), HttpStatus.OK);
    }
}