package org.example

enum class Claim {
    TOP_ROW,
    BOTTOM_ROW,
    EARLY_FIVE
}

fun validateClaim(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {

    val res = when(claim) {
        Claim.TOP_ROW -> {
            val row = mutableSetOf<Int>()
            for(i in ticket[0]) {
                if(i != -1) {
                    row.add(i)
                }
            }
            var res = false
            for(i in announcedNumbers.indices) {
                if(row.contains(announcedNumbers[i])) {
                    row.remove(announcedNumbers[i])
                    println(row)
                    if(row.isEmpty()) {
                        res = i == announcedNumbers.size -1
                    }
                }
            }

            res
        }
        Claim.BOTTOM_ROW -> {
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
                    println(row)
                    if(row.isEmpty()) {
                        res = i == announcedNumbers.size -1
                    }
                }
            }

            res
        }
        Claim.EARLY_FIVE -> {
            val row = mutableSetOf<Int>()
            for(i in ticket.indices) {
                for(j in ticket[i].indices) {
                    if(ticket[i][j] != -1) {
                        row.add(ticket[i][j])
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

            res
        }
    }

    return res
}