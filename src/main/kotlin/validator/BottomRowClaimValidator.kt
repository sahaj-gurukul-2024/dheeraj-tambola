package org.example.validator

import org.example.Claim

class BottomRowClaimValidator : ClaimValidator {
    override fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val row = mutableSetOf<Int>()
        for(i in ticket[ticket.size -1]) {
            if(i != -1) {
                row.add(i)
            }
        }
        var res = false
        for(i in announcedNumbers.indices) {
            if(row.contains(announcedNumbers[i])) {
                row.remove(announcedNumbers[i])
                if(row.isEmpty()) {
                    res = i == announcedNumbers.size -1
                }
            }
        }

        return res
    }
}