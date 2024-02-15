package org.example

import org.example.validator.BottomRowClaimValidator
import org.example.validator.ClaimValidator
import org.example.validator.EarlyFiveClaimValidator
import org.example.validator.TopRowClaimValidator

enum class Claim {
    TOP_ROW,
    BOTTOM_ROW,
    EARLY_FIVE
}

class Tambola {

    private var claimValidator:ClaimValidator? = null
    private fun setClaimValidator(claimValidator:ClaimValidator) {
        this.claimValidator = claimValidator
    }
    fun validateClaim(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {

        when(claim) {
            Claim.TOP_ROW -> {
                setClaimValidator(TopRowClaimValidator())
            }
            Claim.BOTTOM_ROW -> {
                setClaimValidator(BottomRowClaimValidator())
            }
            Claim.EARLY_FIVE -> {
                setClaimValidator(EarlyFiveClaimValidator())
            }
            else -> {
                throw Exception("Invalid Claim")
            }
        }

        return claimValidator!!.validate(ticket, announcedNumbers, claim)
    }
}