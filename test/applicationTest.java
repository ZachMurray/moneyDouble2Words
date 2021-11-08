import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class applicationTest {

    @Test
    void tens2Words() {
        String moneyWords = application.Tens2Words(123);
        System.out.println("moneyWords:\t" + moneyWords);
        assertEquals("twenty three",
                moneyWords.trim());
    }

    @Test
    void hundreds2Words() {
        String moneyWords = application.Hundreds2Words(123456);
        System.out.println("moneyWords:\t" + moneyWords);
        assertEquals("four hundred fifty six",
                moneyWords.trim());
    }

    @Test
    void thousands2Words() {
        String moneyWords = application.Thousands2Words(
                BigInteger.valueOf(123456789));
        System.out.println("moneyWords:\t" + moneyWords);
        assertEquals("one hundred twenty three million " +
                        "four hundred fifty six thousand " +
                        "seven hundred eighty nine",
                moneyWords.trim()

        );
    }


    @Test
    void double2Words() {
        String moneyWords = application.Double2Words(
                BigDecimal.valueOf(123456789123456.123));
        System.out.println("moneyWords:\t" + moneyWords);
        assertEquals("one hundred twenty three septillion " +
                        "four hundred fifty six billion " +
                        "seven hundred eighty nine million " +
                        "one hundred twenty three thousand " +
                        "four hundred fifty six dollars " +
                        "and twelve cents",
                moneyWords.trim());
    }
}