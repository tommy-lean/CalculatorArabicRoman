import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tommy_lean
 * @link http:/devonline.academy/java
 */
public class ValidationInputChecker {
    public boolean isArabicDigit(String num) {
        return Character.isDigit(num.charAt(0));
    }

    public  boolean isValidRomanNumber(String[] values) {
        String romanNumberPattern = "^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$";
        Pattern pattern = Pattern.compile(romanNumberPattern);
        Matcher matcher = pattern.matcher(values[0]);
        Matcher matcher2 = pattern.matcher(values[2]);

        return matcher.matches() && matcher2.matches();
    }

    public void isMixedNumberSystem(String[] values) throws Exception {
        String num1 = values[0];
        String num2 = values[2];
        int idNum1 = 1;
        int idNum2 = 1;
         if (isArabicDigit(num1)) {
            idNum1 = 0;
        }

         if (isArabicDigit(num2)) {
            idNum2 = 0;
        }

        if (idNum1 != idNum2) {
            throw new Exception("Вы ввели и римскую и арабскую цифру. Введите одинаковые цифры.");
        }
    }

    public boolean isValidArabicNumber(String[] values) {
        String arabicNumberPattern = "^[0-9]+$";

        Pattern pattern = Pattern.compile(arabicNumberPattern);
        Matcher matcher = pattern.matcher(values[0]);
        Matcher matcher2 = pattern.matcher(values[2]);

        return matcher.matches() && matcher2.matches();
    }

    public boolean isArabicNumerals(String[] values) throws Exception {
        if(isValidArabicNumber(values)){
            return isNumbersInInput(values);
        }
        else {
            return false;
        }
    }

    public boolean isValidationInput(String input) {
        return input.matches("^\\S+\\s[+\\-*/]\\s\\S+$");
    }

    public boolean isNumbersFrom1to10(String[] values) throws Exception {
        if (isNumbersInInput(values)) {
            int num1 = Integer.parseInt(values[0]);
            int num2 = Integer.parseInt(values[2]);
            if ((num1 <= 10 && num1 >= 1) && (num2 <= 10 && num2 >= 1)) {
                return true;
            }
        }
        throw new Exception("Введите, пожалуйста, число от 1 до 10!");
    }

    private boolean isNumbersInInput(String[] values) {
        return Character.isDigit(values[0].charAt(0)) && Character.isDigit(values[2].charAt(0));
    }
}
