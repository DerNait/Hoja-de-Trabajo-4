package src;

public class Operator {
    private Calculator calculator = new Calculator();
    IStack<Character> stack;

    public Operator(IStack<Character> stack){
        this.stack = stack;
    }

    /**
     * The function `infixToPostfix` converts an infix expression to a postfix expression while
     * handling parentheses and operators with proper precedence.
     * 
     * @param expression Is a method that converts an infix expression to a
     * postfix expression using a stack data structure. The method processes each character in the
     * input expression and performs different actions based on the type of character encountered.
     * @return The method `infixToPostfix` returns a `String` which is the postfix notation of the
     * input infix expression.
     */
    public String infixToPostfix(String expression) throws InvalidExpressionException {
        StringBuilder result = new StringBuilder();

        for (char character : expression.toCharArray()) {
            if (Character.isDigit(character)) {
                result.append(character);
            } else if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop(); // Pop '('
                else throw new InvalidExpressionException("Mismatched parentheses in expression.");
            } else if (isOperator(character)) {
                while (!stack.isEmpty() && precedence(character) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(character);
            } else {
                // Lanza una excepción si el caracter no es un operador válido ni un dígito
                throw new InvalidCharacterException("Invalid character found: " + character);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') throw new InvalidExpressionException("Mismatched parentheses in expression.");
            result.append(stack.pop());
        }
        return result.toString();
    }

    /**
     * The function evaluates a postfix expression containing arithmetic operations and returns the
     * result.
     * 
     * @param postfix Gets the postfix expression to evaluate
     * @return The method `evaluatePostfix` is returning the result of evaluating the postfix
     * expression provided as input. This result is the final value after performing all the arithmetic
     * operations specified in the postfix expression.
     */
    public int evaluatePostfix(String postfix) throws ArithmeticException {
        StackWithDoubleList<Integer> intStack = new StackWithDoubleList<>();
        for (int i = 0; i < postfix.length(); i++) {
            char character = postfix.charAt(i);
            if (Character.isDigit(character)) {
                intStack.push(Character.getNumericValue(character));
            } else {
                if (intStack.count() < 2) throw new InvalidExpressionException("Invalid postfix expression.");
                int val1 = intStack.pop();
                int val2 = intStack.pop();
                switch (character) {
                    case '+':
                        intStack.push(calculator.add(val2, val1));
                        break;
                    case '-':
                        intStack.push(calculator.substraction(val2, val1));
                        break;
                    case '*':
                        intStack.push(calculator.multiplication(val2, val1));
                        break;
                    case '/':
                        if (val1 == 0) throw new ArithmeticException("Division by zero.");
                        intStack.push(calculator.division(val2, val1));
                        break;
                    case '%':
                        if (val1 == 0) throw new ArithmeticException("Division by zero for modulus operation.");
                        intStack.push(calculator.residue(val2, val1));
                        break;
                    default:
                        throw new InvalidCharacterException("Invalid operator found: " + character);
                }
            }
        }
        return intStack.pop();
    }

    /**
     * The function determines the precedence of arithmetic operators in an expression.
     * 
     * @param ch The parameter `ch` in the `precedence` method is a character representing an operator
     * (+, -, *, /, %) for which we want to determine the precedence level.
     * @return The method `precedence` returns the precedence value of the given operator character. 
     * - If the character is '+' or '-', it returns 1.
     * - If the character is '*', '/', or '%', it returns 2.
     * - If the character is none of the above, it returns -1.
     */
    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return -1;
    }

    /**
     * The function checks if a given character is an operator by comparing it to a string of operator
     * characters.
     * 
     * @param ch The `ch` parameter in the `isOperator` method is a character that will be checked to
     * see if it is one of the arithmetic operators: '+', '-', '*', '/', or '%'. The method will return
     * `true` if the character is one of these operators, and `false` otherwise.
     * @return The method isOperator() returns a boolean value indicating whether the input character
     * is an operator (+, -, *, /, %) or not.
     */
    private boolean isOperator(char ch) {
        return "+-*/%".indexOf(ch) != -1;
    }
}

// Excepciones personalizadas
class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}

class InvalidCharacterException extends RuntimeException {
    public InvalidCharacterException(String message) {
        super(message);
    }
}