package com.rest.practiceapp.model.twitterclone

import com.rest.practiceapp.generators.TweetIdGenerator
import javax.persistence.*

@Entity
@Table(name = "practice_app_one_tweet")
data class Tweet(
    val created_at: String = TweetIdGenerator().createdAt,
    @Id
    val id: Long = TweetIdGenerator().generate().toLong(),
    val idStr: String = id.toString(),
    val text: String,
    val inReplyToStatusId: Int,
    val inReplyToStatusStr: String = inReplyToStatusId.toString(),
    val inReplyToUserId: Int,
    val inReplyToUserIdStr: String = inReplyToUserId.toString(),
    val accountId: Int ,
    val favorite: Boolean,
    val retweeted: Boolean,
    val replyCount: Int,
    val favoriteCount: Int,
    val retweetCount: Int
) {
}