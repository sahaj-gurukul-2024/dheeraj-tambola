package org.example

import org.example.validator.*

class Tambola {

    private var claimValidator: ClaimValidator? = null
    private fun setClaimValidator(claimValidator: ClaimValidator) {
        this.claimValidator = claimValidator
    }
    fun validateClaim(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {

        when(claim) {
            Claim.TOP_ROW -> setClaimValidator(TopRowClaimValidator())
            Claim.BOTTOM_ROW -> setClaimValidator(BottomRowClaimValidator())
            Claim.MIDDLE_ROW -> setClaimValidator(MiddleRowClaimValidator())
            Claim.EARLY_FIVE -> setClaimValidator(EarlyFiveClaimValidator())
        }

        return claimValidator!!.validate(ticket, announcedNumbers, claim)
    }
}