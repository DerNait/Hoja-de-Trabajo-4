package TESTS;
import org.junit.Test;
import src.Calculator;
import static org.junit.Assert.*;

public class CalculatorTests {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(-5, calculator.add(-2, -3));
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    public void testSubstraction() {
        Calculator calculator = new Calculator();
        assertEquals(-1, calculator.substraction(2, 3));
        assertEquals(0, calculator.substraction(0, 0));
        assertEquals(1, calculator.substraction(-2, -3));
        assertEquals(5, calculator.substraction(10, 5));
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiplication(2, 3));
        assertEquals(0, calculator.multiplication(0, 0));
        assertEquals(6, calculator.multiplication(-2, -3));
        assertEquals(25, calculator.multiplication(5, 5));
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.division(6, 3));
        assertEquals(0, calculator.division(0, 1));
        assertEquals(-2, calculator.division(6, -3));
        assertEquals(5, calculator.division(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        calculator.division(5, 0);
    }

    @Test
    public void testResidue() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.residue(5, 2));
        assertEquals(0, calculator.residue(4, 2));
        assertEquals(0, calculator.residue(0, 1));
        assertEquals(2, calculator.residue(8, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void testResidueByZero() {
        Calculator calculator = new Calculator();
        calculator.residue(5, 0);
    }
}
