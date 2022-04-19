package com.rest.practiceapp.service

import com.rest.practiceapp.model.Account
import com.rest.practiceapp.dao.AccountRepository
//import com.rest.practiceapp.dao.SaltRepository
import com.rest.practiceapp.model.parameters.LoginParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
//import com.rest.practiceapp.service.encrypt.PasswordService
//import com.rest.practiceapp.service.encrypt.SaltService

@Service
class AccountService {

    @Autowired
    lateinit var accountRepository: AccountRepository

    fun signup(account: Account) : ResponseEntity<String>
    {
        return if(accountRepository.existsByEmail(account.email)) ResponseEntity<String>("Email already exist",HttpStatus.OK) else {

            accountRepository.save(account)

            ResponseEntity<String>("Account Created Successfully",HttpStatus.CREATED)
        }
    }

    fun login(loginParameters: LoginParameters): ResponseEntity<Account> {
        val emailExist = accountRepository.existsByEmail(loginParameters.email)
        val account = accountRepository.findByEmail(loginParameters.email)

        if(emailExist && (account.password == loginParameters.password))
        {
            return ResponseEntity<Account>(account,HttpStatus.OK)
        }else {
            return ResponseEntity<Account>(HttpStatus.OK)
        }

    }

    fun accounts(): ResponseEntity<List<Account>>{
        val account = accountRepository.findAll()
        return ResponseEntity<List<Account>>(account,HttpStatus.OK)
    }


}