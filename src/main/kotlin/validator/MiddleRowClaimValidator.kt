package org.example.validator

import org.example.Claim

class MiddleRowClaimValidator: ClaimValidator {
    override fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val row = mutableSetOf<Int>()
        for(item in ticket[ticket.size -2]) {
            if(item != -1) {
                row.add(item)
            }
        }
        var result = false
        for(index in announcedNumbers.indices) {
            if(row.contains(announcedNumbers[index])) {
                row.remove(announcedNumbers[index])
                if(row.isEmpty()) {
                    result = index == announcedNumbers.size -1
                }
            }
        }
        return result
    }

}