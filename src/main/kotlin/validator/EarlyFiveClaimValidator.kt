package org.example.validator

import org.example.Claim

class EarlyFiveClaimValidator: ClaimValidator {
    override fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {
        val row = mutableSetOf<Int>()
        for(firstIndex in ticket.indices) {
            for(secondIndex in ticket[firstIndex].indices) {
                if(ticket[firstIndex][secondIndex] != -1) {
                    row.add(ticket[firstIndex][secondIndex])
                }
            }
        }
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