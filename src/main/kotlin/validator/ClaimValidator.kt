package org.example.validator

import org.example.Claim
import org.example.TambolaTicket

interface ClaimValidator {
    fun validate(ticket: TambolaTicket, announcedNumbers: List<Int>, claim: Claim): Boolean
}