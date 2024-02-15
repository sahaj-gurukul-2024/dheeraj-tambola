package org.example.validator

import org.example.Claim

class TopRowClaimValidator : ClaimValidator {
    override fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val row = mutableSetOf<Int>()
        for(index in ticket[0]) {
            if(index != -1) {
                row.add(index)
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