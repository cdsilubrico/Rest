package com.rest.practiceapp.service.twitterclone

import com.rest.practiceapp.model.twitterclone.Tweet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.rest.practiceapp.dao.twitterclone.TweetRepository

@Service
class TweetService {

    @Autowired
    lateinit var tweetRepository: TweetRepository

    fun tweet(tweet: Tweet) : String
    {
        tweetRepository.save(tweet)
        return "SUCCESS"
    }


}