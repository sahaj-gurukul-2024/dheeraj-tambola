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
        var res = false
        var itemsRem = 0
        for(i in announcedNumbers.indices) {
            if(row.contains(announcedNumbers[i])) {
                itemsRem++
                if(itemsRem == 5) {
                    res = i == announcedNumbers.size -1
                }
            }
        }

        return res
    }
}