import CalculatorSimple.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //git coment
    // second git comment


    public static void main(String[] args) {

        boolean isCalculatoCreated = false;
        String stringToQuit = "Q";
        String stringToReset = "R";

        Scanner skanerek = new Scanner(System.in);
        String stringThatRepresentCalculation = null;
        Calculator tempCalculator = null;
        Object[] tableOfObjects = new Object[1];

        try {
            tempCalculator = runCalculator();
            isCalculatoCreated = true;
        } catch (NullPointerException e) {
            System.out.println("Ups, you didn't created calculator");
        }
        // Zrób pętle w której sprawdzasz skanerek.next -> jeśli string to Q/R a jeśli Double to Value1/Value2
        while (isCalculatoCreated) {
            tableOfObjects[0] = skanerek.next();
            // Three statemenst "Q"/"R"/ Next Value
            if (tableOfObjects[0].equals(stringToQuit)) {
                System.out.println("END OF LOOP! \nBYE !");
                break;
            } else if (tableOfObjects[0].equals(stringToReset)) {
                tempCalculator.ResetCalcualorValues();
                System.out.println("Calculator Restarted");
                tempCalculator.CalculatorInfo();
            } else{
                if (!tempCalculator.isFirstValueSet() && !tempCalculator.isSecondValueSet()) {
                    try {
                        tempCalculator.setFirstValue(Double.valueOf(tableOfObjects[0].toString()));
                        tempCalculator.setFirstValueSet(true);
                        System.out.println("First Value = " + tempCalculator.getFirstValue());
                        System.out.println("Enter Second Value");
                        continue;
                    } catch (Exception e) {
                        System.out.println("\nYou pressed wrong value \nPlease insert double value\n");
                        tempCalculator.CalculatorInfo();

                    }
                }

                if (!tempCalculator.isSecondValueSet() && tempCalculator.isFirstValueSet()) {
                    try {
                        tempCalculator.setSecondValue(Double.valueOf(tableOfObjects[0].toString()));
                        tempCalculator.setSecondValueSet(true);
                        System.out.println("First Value = " + tempCalculator.getFirstValue() + ", Second Value = " + tempCalculator.getSecondValue());
                        System.out.println("Enter Calculation type");
                        tempCalculator.CalculatorInfo();
                        continue;
                    } catch (Exception e) {
                        System.out.println("\nYou pressed wrong value \nPlease insert double value\n");
                        tempCalculator.CalculatorInfo();
                    }
                }
            }if(tempCalculator.isFirstValueSet() && tempCalculator.isSecondValueSet()){
                try {
                    Double tempDoubleValue = (tempCalculator.CalculationOfCalculator(tempCalculator.TypeOfCalculations(tableOfObjects[0].toString())));
                    if (Double.valueOf(tempDoubleValue) != -1.0){
                        System.out.println(tempDoubleValue);
                    }else{
                        System.out.println("Please insert correct symbol");
                        continue;
                    }
                    tempCalculator.CalculatorInfo();
                } catch (Exception e) {
                    System.out.println("Please insert correct symbol ");
                    tempCalculator.CalculatorInfo();
                }
            }

            if (skanerek.hasNext()) {
                skanerek.nextLine();
            }
        }
    }


    public static Calculator runCalculator() {
        Calculator calculator = new Calculator();
        return calculator;
    }


}
