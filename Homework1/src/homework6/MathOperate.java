package homework6;

@FunctionalInterface
public interface MathOperate {

    int getResult(int value1, int value2);

    default void getInfo(){
        System.out.println("Hey there! You are using method");
    }
}
