package com.rest.practiceapp.service.encrypt

import org.springframework.stereotype.Service
import java.math.BigInteger
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

@Service
class PasswordService {

    fun hash(password: String, salt: ByteArray): ByteArray {
        val spec = PBEKeySpec(password.toCharArray(), salt, 1000, 256)
        try {
            val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            return skf.generateSecret(spec).encoded
        } catch (e: NoSuchAlgorithmException) {
            throw AssertionError("Error while hashing a password: " + e.message, e)
        } catch (e: InvalidKeySpecException) {
            throw AssertionError("Error while hashing a password: " + e.message, e)
        } finally {
            spec.clearPassword()
        }
    }

    //@Throws(NoSuchAlgorithmException::class)
    fun hashPassword(salt:ByteArray,password:String): String {
        val hashed = hash(password, salt)
        val bigInt = BigInteger(1, hashed)
        val inHex = bigInt.toString(16)
        val paddingLength = hashed.size * 2 - inHex.length
        return if (paddingLength > 0) {
            String.format("%0" + paddingLength + "d", 0) + inHex
        } else {
            inHex
        }
    }

    fun isExpectedPassword(password: String, salt: ByteArray, expectedHash: ByteArray): Boolean {
        val pwdHash = hash(password, salt)
        if (pwdHash.size != expectedHash.size) return false
        return pwdHash.indices.all { pwdHash[it] == expectedHash[it] }
    }
}