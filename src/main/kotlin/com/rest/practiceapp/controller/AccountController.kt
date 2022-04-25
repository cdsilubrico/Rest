package com.rest.practiceapp.controller

import com.rest.practiceapp.model.Account
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

    @PostMapping(value= ["/signup"])
    fun signup(@RequestBody account: Account): ResponseEntity<String> {
        return accountService.signup(account)
    }

    @PostMapping(value=["/login"])
    fun login(@RequestBody loginParameters: LoginParameters): ResponseEntity<Any> {
        return accountService.login(loginParameters)
    }

    @GetMapping(value=["/accounts"])
    fun accounts(): ResponseEntity<List<Account>> {
        return accountService.accounts()
    }

}