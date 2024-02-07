/**
 * @author tommy_lean
 * @link http:/devonline.academy/java
 */
public class CalculationArabic {

    public int calculation(char sign, int num1, int num2) throws Exception {
        int result = switch (sign) {
            case '+' -> sum(num1, num2);
            case '-' -> sub(num1, num2);
            case '/' -> division(num1, num2);
            case '*' -> multiply(num1, num2);
            default -> throw new Exception("Введите корректную операцию над числами: +,-,/,*");
        };
        return result;
    }

    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public int division(int num1, int num2) {
        return num1 / num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}
