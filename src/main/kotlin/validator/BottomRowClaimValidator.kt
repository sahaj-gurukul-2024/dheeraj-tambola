package org.example.validator

import org.example.Claim

class BottomRowClaimValidator : ClaimValidator {
    override fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val row = mutableSetOf<Int>()
        for(index in ticket[ticket.size -1]) {
            if(index != -1) {
                row.add(index)
            }
        }
        var res = false
        for(index in announcedNumbers.indices) {
            if(row.contains(announcedNumbers[index])) {
                row.remove(announcedNumbers[index])
                if(row.isEmpty()) {
                    res = index == announcedNumbers.size -1
                }
            }
        }

        return res
    }
}