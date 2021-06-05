package com.zemoga.portfolio.controller;

import com.zemoga.portfolio.service.ITwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/twitter")
public class TwitterController {

    @Autowired
    private ITwitterService twitterService;

    @GetMapping("/{username}/tweets")
    public List<Tweet> getUserLastFiveTweets(@PathVariable(name = "username") String username) {
        return twitterService.getUserLastFiveTweets(username);
    }

}
