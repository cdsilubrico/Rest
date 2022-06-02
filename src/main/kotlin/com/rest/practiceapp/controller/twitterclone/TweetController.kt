package com.rest.practiceapp.controller.twitterclone

import com.rest.practiceapp.model.twitterclone.Tweet
import com.rest.practiceapp.service.twitterclone.TweetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/app")
class TweetController {

    @Autowired
    val tweetService = TweetService()

    @PostMapping("/tweet")
    fun tweet(@RequestBody tweet: Tweet):  String{
        return tweetService.tweet(tweet)
    }









}