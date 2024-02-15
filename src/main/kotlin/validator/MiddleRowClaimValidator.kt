package org.example.validator

import org.example.Claim

class MiddleRowClaimValidator: ClaimValidator {
    override fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val row = mutableSetOf<Int>()
        for(i in ticket[ticket.size -2]) {
            if(i != -1) {
                row.add(i)
            }
        }
        var result = false
        for (index in announcedNumbers.indices) {
            if (row.contains(announcedNumbers[index])){
                for(i in announcedNumbers.indices) {
                    if(row.contains(announcedNumbers[i])) {
                        row.remove(announcedNumbers[i])
                        if(row.isEmpty()) {
                            result = i == announcedNumbers.size -1
                        }
                    }
                }
            }
        }
        return result
    }

}