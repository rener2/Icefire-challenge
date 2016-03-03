
package ee.icefire.test;

import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// The test class is not part of the code
public class SecureDoorLockTest {

    SecureDoorLock lock = new SecureDoorLock();

    @Test
    public void testOpensForAllowedVisitors() {
        assertTrue(lock.shouldOpen("John", "Smith"));
        assertTrue(lock.shouldOpen("Jane", "Doe"));

        // Type in your name instead of placeholders. We hope that your name is not
        // Ice Cube, because that would make this assignment too easy for you.
        assertTrue(lock.shouldOpen("Rene", "Räkk"));
    }

    private SecureRandom random = new SecureRandom();

    private String getRandomString() {
        return new BigInteger(130, random).toString(32);
    }

    @Test
    public void testStaysClosedForIntruders() {
        // This test would benefit from a good random name generator
        assertFalse(lock.shouldOpen("Sneaky", "Bastard"));
        assertFalse(lock.shouldOpen(getRandomString(), getRandomString()));
    }
}