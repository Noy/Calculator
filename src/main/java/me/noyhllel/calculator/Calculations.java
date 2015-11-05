package me.noyhllel.calculator;

/**
 * Created by Noy on 22/02/2015.
 */
public enum Calculations {

    ADD(new CalculatorDelegate() {
        public Double performCalculations(Double x, Double y) throws ArithmeticException {
            return x+y;
        }
    }, "+"),
    SUBTRACT(new CalculatorDelegate() {
        public Double performCalculations(Double x, Double y) throws ArithmeticException {
            return x-y;
        }
    }, "-"),
    MULTIPLY(new CalculatorDelegate() {
        public Double performCalculations(Double x, Double y) throws ArithmeticException {
            return x*y;
        }
    }, "*"),
    DIVIDE(new CalculatorDelegate() {
        public Double performCalculations(Double x, Double y) throws ArithmeticException {
            return x/y;
        }
    }, "/"),
    SQUARE_ROOT(new CalculatorDelegate() {
        public Double performCalculations(Double x, Double y) throws ArithmeticException {
            return Math.sqrt(y);
        }
    }, ">"),
    POWER_OF(new CalculatorDelegate() {
        public Double performCalculations(Double x, Double y) throws ArithmeticException {
            return Math.pow(x, y);
        }
    }, "^");

    final CalculatorDelegate delegate;
    final String key;

    Calculations(CalculatorDelegate x, String y) {
        this.key = y;
        this.delegate = x;
    }


}
