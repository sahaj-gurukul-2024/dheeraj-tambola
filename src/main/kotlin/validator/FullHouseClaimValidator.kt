package org.example.validator

import org.example.Claim
import org.example.TambolaTicket

class FullHouseClaimValidator: ClaimValidator {
    override fun validate(ticket: TambolaTicket, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val fullTicket = ticket.topRow + ticket.bottomRow + ticket.middleRow
        val row = mutableSetOf<Int>()
        for (item in fullTicket) {
            if (item != -1) {
                row.add(item)
            }
        }
        var result = false
        if (row.containsAll(announcedNumbers) && (row.size <= announcedNumbers.size)){
            result = true
        }
        return result
    }
}