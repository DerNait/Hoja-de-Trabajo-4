/*Hoja de Trabajo #4
Camila Richter - 23138
Kevin Villagrán - 23584
 */

 package src;

 public class Calculator implements ICalculator{
 
     @Override
 
     /**
      * @param  n1 The first number to be added upon  by the calculator
      * @param  n2 The second number which will be used in conjunction with n1
      * @return An integer value representing the addition of n1 and n2
      */
     public int add(int n1, int n2) {
         // Method add
         return n1 + n2;
     }
 
     @Override
     /**
      * @param  n1 The first number to be substracted upon  by the calculator
      * @param  n2 The second number which will be used in conjunction with n1
      * @return An integer value representing the substraction of n1 and n2
      */
     public int substraction(int n1, int n2) {
         //Method sub
         return n1 - n2;
     }
 
     @Override
     /**
      * @param  n1 The first number to be multiplied upon  by the calculator
      * @param  n2 The second number which will be used in conjunction with n1
      * @return An integer value representing the multiplication of n1 and n2
      */
     public int multiplication(int n1, int n2) {
         //Method mult
         return n1 * n2;
     }
 
     @Override
     /**
      * @param  n1 The first number to be divided upon  by the calculator
      * @param  n2 The second number which will be used in conjunction with n1
      * @return  A double value representing the division of n1 and n2.
      * If n2 is equal to zero an error message will appear.
      */
     public int division(int n1, int n2) throws ArithmeticException{
         // Method div
         if(n2 == 0)
             throw new ArithmeticException("Divido cero");
         return n1/n2;
     }
 
     @Override
     /**
      * @param  n1 The first number to be divided upon by the calculator
      * @param  n2 The second number which will be used in conjunction with n1
      * @return  A float that represents the result of the modulo operation between n1 and n2.
      *          If n2 is zero an ArithmeticException will be thrown.
      */
     public int residue(int n1, int n2) throws ArithmeticException{
         // Method residue
         if(n2==0)
             throw new ArithmeticException("Residuo cero");
         return n1 % n2;
         
     }
 }