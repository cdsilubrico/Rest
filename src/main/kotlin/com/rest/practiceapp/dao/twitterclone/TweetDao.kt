package com.rest.practiceapp.dao.twitterclone

import com.rest.practiceapp.model.twitterclone.Tweet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TweetRepository : JpaRepository<Tweet, Long> {
}