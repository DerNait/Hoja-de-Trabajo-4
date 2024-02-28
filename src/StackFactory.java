package src;

public class StackFactory {
    
    public static final int STACK_WITH_ARRAY = 1;
    public static final int STACK_WITH_VECTOR = 2;  
    public static final int STACK_WITH_SINGLE_LIST = 3;
    public static final int STACK_WITH_DOUBLE_LIST = 4;  

    /**
     * The function `getStackInstance` returns an instance of a stack implementation based on the
     * specified type.
     * 
     * @param stackType The `stackType` parameter is an integer value that determines the type of stack
     * implementation to be returned. Here are the possible values for `stackType`:
     * @return The method `getStackInstance` returns an instance of a stack based on the `stackType`
     * parameter provided. The returned stack instance will be of type `IStack<T>`, which is a generic
     * interface for a stack data structure. The specific type of stack returned depends on the value
     * of the `stackType` parameter:
     */
    public static <T> IStack<T> getStackInstance(int stackType){
        int qty = 50;
        switch (stackType) {
            case STACK_WITH_ARRAY:
                return new StackWithArray<T>(qty);    

            case STACK_WITH_VECTOR:
                return new StackWithVector<T>(qty);

            case STACK_WITH_SINGLE_LIST:
                return new StackWithSingleList<T>();    

            case STACK_WITH_DOUBLE_LIST:
                return new StackWithDoubleList<T>();
            default:
                return new StackWithArray<T>(qty);
        }
    }
}
