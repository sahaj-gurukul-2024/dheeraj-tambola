package org.example.validator

import org.example.Claim
import org.example.TambolaTicket

class EarlyFiveClaimValidator: ClaimValidator {
    override fun validate(ticket: TambolaTicket, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val row = ticket.getFullTicket()
        var result = false
        var itemsRemaining = 0
        for(index in announcedNumbers.indices) {
            if(row.contains(announcedNumbers[index])) {
                itemsRemaining++
                if(itemsRemaining == 5) {
                    result = index == announcedNumbers.size -1
                }
            }
        }
        return result
    }
}