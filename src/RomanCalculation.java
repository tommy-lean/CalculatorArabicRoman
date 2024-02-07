/**
 * @author tommy_lean
 * @link http:/devonline.academy/java
 */
public class RomanCalculation {
    public String convertingRomanNumber(String[] values) throws Exception {
        RomanNumber number1 = RomanNumber.valueOf(values[0]);
        RomanNumber number2 = RomanNumber.valueOf(values[2]);


        int num1 = number1.getArabicNumber();
        int num2 = number2.getArabicNumber();

        CalculationArabic calculation = new CalculationArabic();


        int operation = calculation.calculation(values[1].charAt(0), num1, num2);
        if(operation <= 0) throw new Exception("Результат вычислений меньше нуля или ноль.");
        else {
            RomanNumber[] romanNumbers = RomanNumber.values();
            String[] romanArray = getRomanArray(romanNumbers);

            String result = convertingFromArabicToRoman(operation, romanArray);
            return result;
        }

    }


    private String convertingFromArabicToRoman(int operation, String[] array) {
        RomanNumber[] romanNumberArray = RomanNumber.values();
        StringBuilder builder = new StringBuilder();
        String result = getRomanNum(operation, romanNumberArray, builder).toString();
        if (!result.equals("not found")) {
            return result;
        }
            if (operation > 10) {
                result = "";
                builder = new StringBuilder();
                builder.append(operation);
                String digitOfNumber = builder.charAt(1) + "";
                builder.replace(1, 2, "0");
                StringBuilder resultBuilder = new StringBuilder();
                operation = Integer.parseInt(builder.toString());
                builder = new StringBuilder();
                StringBuilder builderNum1 = getRomanNum(operation, romanNumberArray, builder);
                builder = new StringBuilder();
                String digitOfRomanNumber = getRomanNum(Integer.parseInt(digitOfNumber), romanNumberArray, builder).toString();
                result = resultBuilder.append(builderNum1).append(digitOfRomanNumber).toString();
            }

            return result;
    }



    private StringBuilder getRomanNum(int operation, RomanNumber[] romanNumberArray, StringBuilder builder) {
        boolean findSuccess = false;
        for (int i = 0; i < romanNumberArray.length; i++) {
            if (operation == romanNumberArray[i].getArabicNumber()) {
                builder.append(romanNumberArray[i].name());
                findSuccess = true;
            }
        }

        if(findSuccess) {
            return builder;
        }
        else {
            return builder.append("not found");
        }
    }

    public String[] getRomanArray(RomanNumber[] romanNumbers) {
        String[] numbersArray = new String[romanNumbers.length];

        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = romanNumbers[i].name();
        }
        return numbersArray;
    }
}
