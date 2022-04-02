package com.rest.practiceapp.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "practice_app_one_account")
data class Account(
    var firstName: String,
    var lastName: String,
    val email:String,
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String,
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    val id: Long = -1
)