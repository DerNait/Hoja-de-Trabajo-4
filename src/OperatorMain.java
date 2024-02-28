/*Hoja de Trabajo #4
Camila Richter - 23138
Kevin Villagrán - 23584
 */
package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de la pila que desea usar:");
        System.out.println("1. Stack con Array");
        System.out.println("2. Stack con Vector");
        System.out.println("3. Stack con Lista Simple");
        System.out.println("4. Stack con Lista Doble");
        
        int stackChoice = scanner.nextInt();
        IStack<Character> stack = StackFactory.getStackInstance(stackChoice);
        
        Operator operator = new Operator(stack);

        // Leer expresiones desde el archivo
        ArrayList<String> expressions;
        try {
            expressions = Reader.readExpression("datos.txt");
            for (String expression : expressions) {
                String postfix = operator.infixToPostfix(expression);
                System.out.println("\nExpresión: " + expression);
                System.out.println("Postfix: " + postfix);
                int result = operator.evaluatePostfix(postfix);
                System.out.println("Resultado: " + result);
                System.out.println(); // Espacio entre evaluaciones
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
