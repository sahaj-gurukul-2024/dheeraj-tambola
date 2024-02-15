package org.example.validator

import org.example.Claim

interface ClaimValidator {
    fun validate(ticket: List<List<Int>>, announcedNumbers: List<Int>, claim: Claim): Boolean
}