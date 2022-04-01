package com.rest.practiceapp.model

import javax.persistence.*

@Entity
@Table(name = "practice_app_one_account")
data class Account(
    var firstName: String,
    var lastName: String,
    val email:String,
    var password: String,
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    val id: Long = -1
)