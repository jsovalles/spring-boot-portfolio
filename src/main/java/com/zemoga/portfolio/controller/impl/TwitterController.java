package com.zemoga.portfolio.controller.impl;

import com.zemoga.portfolio.service.ITwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Tweet>> getUserLastFiveTweets(@PathVariable(name = "username") String username) {
        return new ResponseEntity<>(twitterService.getUserLastFiveTweets(username), HttpStatus.OK);
    }

}
