package com.rest.practiceapp.dao

import com.rest.practiceapp.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByEmail(email: String):Iterable<Account>
}