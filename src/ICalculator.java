/*Hoja de Trabajo #4
Camila Richter - 23138
Kevin Villagrán - 23584
 */

package src;

public interface ICalculator {
    
    /**
     * 
     * @param n1
     * @param n2
     * @return  la suma de los dos numeros recibidos como parametros
     */
    public int add(int n1, int n2);// +

    /**
     * 
     * @param n1
     * @param n2
     * @return  el resultado de restarle a n1 el valor de n2
     */
    public int substraction(int n1, int n2);// -

    /**
     * 
     * @param n1
     * @param n2
     * @return  devuelve el producto entre n1 y n2
     */
    public int multiplication(int n1, int n2);// *

    /**
     * 
     * @param n1
     * @param n2
     * @return  El cociente de dividir n1 por n2. Si n2 es cero lanza una excepcion de division por cero
     *          en caso contrario retorna el cociente
     * @throws Exception
     */
    public int division(int n1, int n2) throws Exception;// /

    /**
     * 
     * @param n1
     * @param n2
     * @return  Retorna el residuo de la division de n1 entre n2. Si n2 es cero lanza una excepcion de division por cero
     * @return Devuelve el residuo que queda cuando se divide n1 entre n2. Si n2 es cero lanza una excepcion de division por c
     * @return Devuelve el residuo de la division de n1 entre n2
     * @throws Exception
     */
    public int residue(int n1, int n2) throws Exception;// %
}
