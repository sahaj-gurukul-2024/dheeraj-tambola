import org.example.Claim
import org.example.Tambola
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
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

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
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertFalse(result)
    }

    @Test
    fun `check if bottom row wins`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(9, 25, 46, 56, 89, 64, 76, 83)
        val claim = Claim.BOTTOM_ROW
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertTrue(result)
    }

    @Test
    fun `check if bottom row losses`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(9, 25, 83, 56, 89, 64, 76, 8)
        val claim = Claim.BOTTOM_ROW
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertFalse(result)
    }

    @Test
    fun `check if middle row wins`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(7, 23, 46, 52, 89, 80, 76, 38)
        val claim = Claim.MIDDLE_ROW
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertTrue(result)
    }

    @Test
    fun `check if middle row loses`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(7, 23, 46, 42, 89, 80, 76, 38)
        val claim = Claim.MIDDLE_ROW
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertFalse(result)
    }

    @Test
    fun `check if early five wins`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(4, 3, 9, 56, 64, 100, 80)
        val claim = Claim.EARLY_FIVE
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertTrue(result)
    }

    @Test
    fun `check if early five losses`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(4, 3, 9, 56, 64, 100, 80, 77)
        val claim = Claim.EARLY_FIVE
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertFalse(result)
    }
    @Test
    fun `check if full house claim wins`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83)
        val claim = Claim.FULL_HOUSE
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertTrue(result)
    }

    @Test
    fun `check if late full house clam loses`() {
        val ticket = listOf(
            listOf(4,16,-1,-1,48,-1,63,76,-1),
            listOf(7,-1,23,38,-1,52,-1,-1,80),
            listOf(9,-1,25,-1,-1,56,64,-1,83)
        )
        val announcedNumbers = listOf(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83, 69)
        val claim = Claim.FULL_HOUSE
        val tambola = Tambola()

        val result = tambola.validateClaim(ticket, announcedNumbers, claim)

        assertFalse(result)
    }
}