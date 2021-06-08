package com.zemoga.portfolio.utils;

import com.zemoga.portfolio.controller.dto.DTOPortfolio;
import com.zemoga.portfolio.dao.entity.Portfolio;
import org.springframework.social.twitter.api.Tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DummyMock {

    public DTOPortfolio getDTOPortfolio() {
        DTOPortfolio portfolio = new DTOPortfolio();
        portfolio.setDescription("Tyrion of House Lannister. Imp, Halfman. Never forget what you are, for surely the world will not. Not affiliated with #GameofThrones or HBO ++++--2");
        portfolio.setImageUrl("https://pbs.twimg.com/profile_images/668279339838935040/8sUE9d4C_400x400.jpg");
        portfolio.setTwitterUserName("GoT_Tyrion");
        portfolio.setTitle("Tyrion Lannister");
        return portfolio;
    }

    public Portfolio getPortfolio() {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(1);
        portfolio.setDescription("Tyrion of House Lannister. Imp, Halfman. Never forget what you are, for surely the world will not. Not affiliated with #GameofThrones or HBO ++++--2");
        portfolio.setImageUrl("https://pbs.twimg.com/profile_images/668279339838935040/8sUE9d4C_400x400.jpg");
        portfolio.setTwitterUserName("GoT_Tyrion");
        portfolio.setTitle("Tyrion Lannister");
        return portfolio;
    }

    public List<Tweet> getTweets(){
        List<Tweet> tweets = new ArrayList<>();
        Tweet tweet = new Tweet(138, "RT @GameOfThrones: He drinks, and he knows things. Tyrion of House Lannister. \n#GameofThrones is now streaming on @HBOMax. https://t.co/bSS…",
                new Date(), "GoT_Tyrion", "http://pbs.twimg.com/profile_images/668279339838935040/8sUE9d4C_normal.jpg",
                Long.valueOf(0), 963558768, "en", "<a href=\\\"http://twitter.com/download/iphone\\\" rel=\\\"nofollow\\\">Twitter for iPhone</a>");
        tweets.add(tweet);
        tweets.add(tweet);
        return tweets;
    }

    public Portfolio getPortfolioDatabaseTest() {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(37);
        portfolio.setDescription("Technoking of Tesla, Imperator of Mars and Saturn");
        portfolio.setImageUrl("https://pbs.twimg.com/profile_images/1383184766959120385/MM9DHPWC_normal.jpg");
        portfolio.setTwitterUserName("elonmusk");
        portfolio.setTitle("Elon Musk");
        return portfolio;
    }
}
