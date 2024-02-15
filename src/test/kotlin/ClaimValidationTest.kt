import org.example.Claim
import org.example.validateClaim
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ClaimValidationTest {

    @Test
    fun `check if top row wins`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(90, 4, 46, 63, 89, 16, 76, 48)
        val claim = Claim.TOP_ROW

        val result = validateClaim(ticket, announcedNumbers, claim)

        assertTrue(result)
    }

    @Test
    fun `check if top row losses`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(90, 4, 46, 63, 89, 16, 76, 48, 12)
        val claim = Claim.TOP_ROW

        val result = validateClaim(ticket, announcedNumbers, claim)

        assertFalse(result)
    }
}