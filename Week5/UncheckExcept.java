package Week5;

public class UncheckExcept {
    public static void main(String[] args) {
        try {
            System.out.println("try block is exexcuted");
            int arr[] = {2,6,3,1,7};
            //int a = 10/0;
            System.out.println(arr[5]);
        }
        catch(ArithmeticException e){
            System.out.println("catch block is exexcuted");
            System.out.println(e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("catch block is exexcuted");
            System.out.println(e.getMessage());
        }
    }
}