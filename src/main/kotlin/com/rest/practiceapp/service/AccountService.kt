package com.rest.practiceapp.service

import com.rest.practiceapp.model.Account
import com.rest.practiceapp.dao.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import com.rest.practiceapp.service.encrypt.PasswordService

@Service
class AccountService() {

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Autowired
    lateinit var passwordService: PasswordService

    fun signup(account: Account) : ResponseEntity<String>
    {
        try{
            var passwordToBeSaved = passwordService.hashPassword(account.password)
            account.password = passwordToBeSaved
            accountRepository.save(account)
        }catch(e:Exception)
        {
            return ResponseEntity<String>("Email already exist",HttpStatus.OK)
        }
        return ResponseEntity<String>("Sign Up Success",HttpStatus.CREATED)
    }

    fun login(email:String,password:String) : ResponseEntity<Iterable<Account>>
    {
        val account = accountRepository.findByEmail(email)

        return ResponseEntity<Iterable<Account>>(account,HttpStatus.OK)
    }
}