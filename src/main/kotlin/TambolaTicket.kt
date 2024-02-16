package org.example

class TambolaTicket(
    topRow: List<Int>,
    middleRow: List<Int>,
    bottomRow: List<Int>
) {
    val topRow = topRow
    val middleRow = middleRow
    val bottomRow = bottomRow
    fun getFullTicket(): List<Int> {
        return this.topRow + this.middleRow + this.bottomRow
    }
}
