import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

class application {

    static Map<Integer, String> number2Word = new HashMap<Integer, String>() {{
        put(0, "");
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
        put(10, "ten");
        put(11, "eleven");
        put(12, "twelve");
        put(13, "thirteen");
        put(14, "fourteen");
        put(15, "fifteen");
        put(16, "sixteen");
        put(17, "seventeen");
        put(18, "eighteen");
        put(19, "nineteen");
        put(20, "twenty");
        put(30, "thirty");
        put(40, "forty");
        put(50, "fifty");
        put(60, "sixty");
        put(70, "seventy");
        put(80, "eighty");
        put(90, "ninety");
        put((int) Math.pow(10, 2), "hundred");
        put((int) Math.pow(10, 3), "thousand");
        put((int) Math.pow(10, 6), "million");
        put((int) Math.pow(10, 9), "billion");
        put((int) Math.pow(10, 12), "trillion");
        put((int) Math.pow(10, 15), "quadrillion");
        put((int) Math.pow(10, 18), "quintillion");
        put((int) Math.pow(10, 21), "sextillion");
        put((int) Math.pow(10, 24), "septillion");
    }};

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Print in Double / Big-Decimal: ");

        BigDecimal doubleValue = reader.nextBigDecimal();
        System.out.println(Double2Words(doubleValue));
    }

    public static String Double2Words(BigDecimal inputBigDecimal) {
        String[] inputStringArray = String.valueOf(inputBigDecimal).split("[.]");
        inputStringArray[1] = inputStringArray[1].substring(0, 2);
        int[] inputIntegerArray = Stream.of(inputStringArray).mapToInt(Integer::parseInt).toArray();

        String returnString = (inputIntegerArray[0] < 0) ? "negative " : "";
        if (inputIntegerArray[0] != 0)
            returnString += Thousands2Words(inputIntegerArray[0]) + "dollars";
        if (inputIntegerArray[1] != 0)
            returnString += " and " + Tens2Words(inputIntegerArray[1]) + " cents";
        return returnString;
    }

    public static String Tens2Words(Integer inputInt) {
        if (inputInt % 100 >= 20)
            return number2Word.get((inputInt % 100 / 10) * 10) + " " + number2Word.get(inputInt % 10);
        else
            return number2Word.get(inputInt);
    }

    public static String Hundreds2Words(Integer inputInt) {
        String returnString = "";
        if (inputInt >= 100)
            returnString += Tens2Words(inputInt % 1000 / 100) + " " + number2Word.get((inputInt / 100 > 0) ? 100 : 0) + " ";
        if (inputInt % 100 >= 20)
            returnString += Tens2Words((inputInt % 100 / 10) * 10);
        return returnString;
    }

    public static String Thousands2Words(Integer inputInt) {
        StringBuilder returnString = new StringBuilder();
        int magnitude10 = String.valueOf(inputInt).length()-1;
        for (int i = (magnitude10 / 3) * 3; i >= 0; i -= 3) {
            returnString.append(Hundreds2Words((int) (inputInt / Math.pow(10, i))));
            if (number2Word.get((int) Math.pow(10, i)) == null)
                returnString.append("10^").append(i);
            else
                returnString.append(number2Word.get((int) Math.pow(10, i)));
            returnString.append(" ");
        }
        return returnString.toString();
    }
}
