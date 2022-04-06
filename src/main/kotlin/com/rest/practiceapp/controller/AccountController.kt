package com.rest.practiceapp.controller

import com.rest.practiceapp.model.Account
import com.rest.practiceapp.model.Salt
import com.rest.practiceapp.model.parameters.LoginParameters
import com.rest.practiceapp.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AccountController {

    @Autowired
    val accountService = AccountService()

    @RequestMapping(value= ["/signup"], method = [RequestMethod.POST])
    fun signup(@RequestBody account: Account): ResponseEntity<String> {
        return accountService.signup(account)
    }

    @RequestMapping(value=["/login"], method = [RequestMethod.POST])
    fun login(@RequestBody loginParameters: LoginParameters): ResponseEntity<Iterable<Account>> {
        return accountService.login(loginParameters)
    }
}