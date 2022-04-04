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

//    @Autowired
//    lateinit var saltRepository: SaltRepository

//    @Autowired
//    lateinit var passwordService: PasswordService

//    @Autowired
//    lateinit var saltService: SaltService

    fun signup(account: Account) : ResponseEntity<String>
    {
        return if(accountRepository.existsByEmail(account.email)) ResponseEntity<String>("Email already exist",HttpStatus.OK) else {

            //val salt = saltService.generateSalt()

            //val passwordToBeSaved = passwordService.hash(account.password,salt)

            //account.password = passwordToBeSaved

            //saltRepository.save((Salt(account.email,salt,passwordService.hash(account.password,salt))))

            accountRepository.save(account)

            ResponseEntity<String>("Account Created Successfully",HttpStatus.CREATED)
        }
    }

    fun login(loginParameters: LoginParameters): ResponseEntity<Iterable<Account>> {
        val account = accountRepository.findByEmail(loginParameters.email)

        if(!account.iterator().hasNext())
        {
            return ResponseEntity<Iterable<Account>>(HttpStatus.OK)
        }else
        {
            if(loginParameters.password == account.iterator().next().password)
                return ResponseEntity<Iterable<Account>>(account,HttpStatus.OK)
        }
        return ResponseEntity<Iterable<Account>>(HttpStatus.OK)
    }
}