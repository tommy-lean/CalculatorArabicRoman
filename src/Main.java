import java.util.Scanner;

/**
 * @author tommy_lean
 * @link http:/devonline.academy/java
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Здравствуйте! Это калькулятор арабских и римских чисел.\n" +
                "Введите выражение строго в виде \"3 + 3\" либо в виде \"V + I\"");

        String input = new Scanner(System.in).nextLine();

        System.out.println(calc4(input));
    }

    public static String calc4(String input) throws Exception {
        ValidationInputChecker check = new ValidationInputChecker();

        if (check.isValidationInput(input)) {
            String[] values = getNumbersAndSign(input);
                if (check.isArabicNumerals(values)) {
                    check.isMixedNumberSystem(values);
                    if (check.isNumbersFrom1to10(values)) {
                        CalculationArabic calculation = new CalculationArabic();
                        int result = calculation.calculation(values[1].charAt(0), Integer.parseInt(values[0]), Integer.parseInt(values[2]));
                        return Integer.toString(result);
                    }
                } else {
                    if(check.isValidRomanNumber(values))
                    check.isMixedNumberSystem(values);
                    RomanCalculation calc = new RomanCalculation();
                    return calc.convertingRomanNumber(values);
                }
        }
            return null;
    }

    public static String[] getNumbersAndSign(String input) {
        return input.split(" ");
    }

}
