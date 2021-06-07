package com.zemoga.portfolio.service.impl;

import com.zemoga.portfolio.dao.impl.TwitterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceImplTest {

    @InjectMocks
    private TwitterServiceImpl service;

    @Mock
    private TwitterRepository repository;

    @Test
    public void getUserLastFiveTweets() {
        when(repository.getUserLastFiveTweets(any(String.class))).thenReturn(new ArrayList<>());
        service.getUserLastFiveTweets("GoT_Tyrion");
    }
}