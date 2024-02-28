package src;

public class Operator {
    private Calculator calculator = new Calculator();
    IStack<Character> stack;

    public Operator(IStack<Character> stack){
        this.stack = stack;
    }

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