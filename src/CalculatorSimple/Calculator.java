package CalculatorSimple;

public class Calculator {

    private double firstValue;
    private double secondValue;
    private boolean firstValueSet = false;
    private boolean secondValueSet = false;

    public boolean isFirstValueSet() {
        return firstValueSet;
    }

    public void setFirstValueSet(boolean firstValueSet) {
        this.firstValueSet = firstValueSet;
    }

    public boolean isSecondValueSet() {
        return secondValueSet;
    }

    public void setSecondValueSet(boolean secondValueSet) {
        this.secondValueSet = secondValueSet;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public Calculator() {
        this(0.0);
    }

    public Calculator(double firstValue) {
        CalculatorInfo();
        this.firstValue = firstValue;

    }

    public void CalculatorInfo() {
        System.out.println("!!!!!! INFO !!!!!!\nPress \"+\" to ADD \nPress \"-\" to SUB \nPress \"*\" to MUL\nPress \"\\\" to DIV\nPress \"Q\" to Quit\nPress \"R\" to reset Values \n!!!!!! INFO !!!!!!");
        if (!isFirstValueSet()) {
            System.out.println("Enter first Value or Quit: ");
        }
        if (!isSecondValueSet() && isFirstValueSet()) {
            System.out.println("First Value = " + this.firstValue);
            System.out.println("Enter second Value or Quit: ");
        }
    }

    public int TypeOfCalculations(String usersInputString) {
        if (usersInputString.equals("+")){
            return 1;
        } else if (usersInputString.equals("-")) {
            return 2;
        } else if (usersInputString.equals("*")) {
            return 3;
        } else if (usersInputString.equals("/")) {
            return 4;
        } else {
            return -1;
        }
    }

    public double CalculationOfCalculator(int numberOfCalculation) {
        if (numberOfCalculation == 1) {
            System.out.println("Result of addition " + this.getFirstValue() +" and "+this.getSecondValue() +" is:");
            return this.getFirstValue() + this.getSecondValue();
        } else if (numberOfCalculation == 2) {
            System.out.println("Result of substraction " + this.getFirstValue() +" and "+this.getSecondValue() +" is:");
            return this.getFirstValue() - this.getSecondValue();
        } else if (numberOfCalculation == 3) {
            System.out.println("Result of multiply " + this.getFirstValue() +" and "+this.getSecondValue() +" is:");
            return this.getFirstValue() * this.getSecondValue();
        } else if (numberOfCalculation == 4) {
            System.out.println("Result of divide " + this.getFirstValue() +" and "+this.getSecondValue() +" is:");
            return this.getFirstValue() / this.getSecondValue();
        } else {
            return -1;
        }
    }

    public void ResetCalcualorValues(){
        this.firstValue = 0.0;
        this.secondValue = 0.0;
        this.firstValueSet = false;
        this.secondValueSet = false;
    }
}
