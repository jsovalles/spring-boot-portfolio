# spring-boot-portfolio
Spring Boot Project that displays the profile image, name, some text with the experience and a 5 tweet list of the user’s Twitter timeline.

## Installation / Deployment

You require of the following Software/Tools:
* [Maven](https://maven.apache.org/)
* Java 11 JDK (or OpenJDK)

Download the project from GitHub and then perform the following commands
```
mvn clean install

mvn spring-boot:run
```

After the command finishes deploying the corresponding services can be consumed.

## Description of the different services with an example

### Portfolio

Using the follow link you can access to the different portfolios registered in the database:

```
http://localhost:8080/{user-id}
```

Example:

http://localhost:8080/1

![profile image](https://i.ibb.co/rbnjPMY/portfolio.png)

### Rest services

**getUserPortfolio:** Web service responsible to display a single portfolio

```
getUserPortfolio (GET) - http://localhost:8080/portfolio/{user-id}

Example: http://localhost:8080/portfolio/1
```

**modifyUserPortfolio:** Web service responsible to update/modify a single portfolio

```
modifyUserPortfolio (PUT) - http://localhost:8080/portfolio/{user-id}/modify

Example: http://localhost:8080/portfolio/37/modify

Body:
{
    "description": "Technoking of Tesla, Imperator of Mars and Jupiter",
    "imageUrl": "https://pbs.twimg.com/profile_images/1383184766959120385/MM9DHPWC_normal.jpg",
    "twitterUserName": "elonmusk",
    "title": "Elon Musk"
}
```

**getUserLastFiveTweets:** Web service responsible to display the 5 last tweets of the user timeline

```
getUserLastFiveTweets (GET) - http://localhost:8080/twitter/{username}/tweets

Example: http://localhost:8080/twitter/GoT_Tyrion/tweets
```
## Project description

Build a simple portfolio Java web app that displays the profile image, name, some text with the experience and a 5 tweet list of the user’s Twitter timeline.

The second part should be a very simple API with 2 endpoints of the profile content.

###PART I

Build a simple portfolio page with the user info, image, title, text description and a list of 5 tweets of the user timeline. Do not pay much attention to the UI/ design side of things. The focus of the test should be the back-end side of things.

All information must be pulled from the database detailed below in the resources section.

Use the Twitter API for pulling the user tweets. Feel free to use any library or module to make the connection.

The following image is a proposed design but the developer is free to choose any design or layout he/she desires.

![profile image](https://i.ibb.co/C0KcTC7/profile-img.png)

All information must be pulled from the database detailed below in the resources section.

Use the Twitter API for pulling the user
tweets:

https://developer.twitter.com/en/docs/tweets/timelines/api-reference/get-statuses-user_timeline​ 

Feel free to use any library or module to make the connection.

###PART II

Create a very simple REST API with two endpoints that allows the consumer to get and modify the profile information. Make sure it complies with the REST specification.
# Developed in

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - The Java IDE
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK
* total time in project implementation: 12 hours

