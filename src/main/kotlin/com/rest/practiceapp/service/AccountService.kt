package com.rest.practiceapp.service

import com.rest.practiceapp.model.Account
import com.rest.practiceapp.controller.dao.AccountRepository
import com.rest.practiceapp.model.parameters.LoginParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AccountService {

    @Autowired
    lateinit var accountRepository: AccountRepository

    fun signup(account: Account): ResponseEntity<String> {
        return if (accountRepository.existsByEmail(account.email)) ResponseEntity<String>(
            "Email already exist",
            HttpStatus.OK
        ) else {

            accountRepository.save(account)

            ResponseEntity<String>("Account Created Successfully", HttpStatus.CREATED)
        }
    }

    fun login(loginParameters: LoginParameters): ResponseEntity<Any> {
        val emailExist = accountRepository.existsByEmail(loginParameters.email)

        if (emailExist) {
            val account = accountRepository.findByEmail(loginParameters.email)
            if (account.password == loginParameters.password) {
                return ResponseEntity.ok().body(account)
            }
        }
        return ResponseEntity.ok().body("Invalid User/Password")
    }

    fun accounts(): ResponseEntity<List<Account>> {
        val account = accountRepository.findAll()
        return ResponseEntity<List<Account>>(account, HttpStatus.OK)
    }

}