package com.rest.practiceapp.model.twitterclone

import com.rest.practiceapp.generators.Generator
import com.rest.practiceapp.model.Account
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "practice_app_one_tweet")
data class Tweet(
    val created_at: String,
    @Id
    val id: Long = Generator().generateID().toLong(),
    val idStr: String,
    val text: String,
    val inReplyToStatusId: Int,
    val inReplyToStatusStr: String,
    val inReplyToUserId: Int,
    val inReplyToUserIdStr: String,
    @ManyToOne
    val account: Account,
    val favorite: Boolean,
    val retweeted: Boolean,
    val replyCount: Int,
    val favoriteCount: Int,
    val retweetCount: Int
)