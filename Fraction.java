/**
 * @author Roby Ferrer Soriano
 */
public class Fraction {
    private int numerator;
    private int denominator;

    // default constructor
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    // parameterized constructor
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction other) {
        this.checkFraction();
        other.checkFraction();
        int num = this.numerator * other.denominator + this.denominator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den).reduce().checkFraction();
    }

    public Fraction subtract(Fraction other) {
        this.checkFraction();
        other.checkFraction();
        int num = this.numerator * other.denominator - this.denominator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den).reduce().checkFraction();
    }

    public Fraction multiply(Fraction other) {
        this.checkFraction();
        other.checkFraction();
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den).reduce().checkFraction();
    }

    public Fraction divide(Fraction other) {
        this.checkFraction();
        other.checkFraction();
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        return new Fraction(num, den).reduce().checkFraction();
    }

    public int computeGCD(int numerator, int denominator) {
        int gcd;
        while (denominator != 0) {
            gcd = denominator;
            denominator = numerator % denominator;
            numerator = gcd;
        }
        return numerator;
    }

    public Fraction reduce() {
        int gcd = computeGCD(numerator, denominator);
        int num = numerator /= gcd;
        int den = denominator /= gcd;
        return new Fraction(num, den);
    }

    public Fraction checkFraction() {
        /*
         * If the denominator is negative, make it positive and move the
         * negative sign from the denominator to the numerator.
         *
         * Else if both numerator and denominator is negative,
         * make them both positive (RULE IN FRACTION)
         */
        if (getDenominator() < 0) {
            setNumerator(-1 * getNumerator());
            setDenominator(-1 * getDenominator());
        // this part is optional, since the "if" statement can make both the num and den positive.    
        } else if (getDenominator() < 0 && getNumerator() < 0) {
            setNumerator(-1 * getNumerator());
            setDenominator(-1 * getDenominator());
        }
        return new Fraction(getNumerator(), getDenominator());
    }

    public String toString() {
        return numerator + " / " + denominator;
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public static void main(String[] args) {
        // You may change the values of f1 and f2 for testing it.
        Fraction f1 = new Fraction(1, 444);
        Fraction f2 = new Fraction(5, 888);

        Fraction sum = f1.add(f2);
        System.out.println(f1.toString() + " + " + f2.toString() + " = " + sum.toString() + " or " + sum.toDecimal());

        Fraction difference = f1.subtract(f2);
        System.out.println(f1.toString() + " - " + f2.toString() + " = " + difference.toString() + " or " + difference.toDecimal());

        Fraction product = f1.multiply(f2);
        System.out.println(f1.toString() + " * " + f2.toString() + " = " + product.toString() + " or " + product.toDecimal());

        Fraction quotient = f1.divide(f2);
        System.out.println(f1.toString() + " / " + f2.toString() +  " = " + quotient.toString() + " or " + quotient.toDecimal());
    }
}
