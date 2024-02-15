package org.example.validator

import org.example.Claim

class FullHouseClaimValidator: ClaimValidator {
    override fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val fullTicket = ticket.flatten()
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
        println(result)
        return result
    }
}