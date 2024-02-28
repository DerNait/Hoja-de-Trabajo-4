package src;

public class StackFactory {
    
    public static final int STACK_WITH_ARRAY = 1;
    public static final int STACK_WITH_VECTOR = 2;  
    public static final int STACK_WITH_SINGLE_LIST = 3;
    public static final int STACK_WITH_DOUBLE_LIST = 4;  

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