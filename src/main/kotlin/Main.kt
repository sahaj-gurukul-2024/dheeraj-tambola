package org.example

enum class Claim {
    TOP_ROW,
    BOTTOM_ROW,
    EARLY_FIVE
}

fun validateClaim(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean {

    val res = when(claim) {
        Claim.TOP_ROW -> {

        }
        Claim.BOTTOM_ROW -> {

        }
        Claim.EARLY_FIVE -> {

        }
    }

    return res
}