package Week5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckExcept {
    public static void main(String[] args) {
        try{
            System.out.println("try block is executed");
            File f = new File("Not.txt");
            @SuppressWarnings({ "resource", "unused" })
            FileReader fr = new FileReader(f);
        }
        catch(FileNotFoundException e){
            System.out.println("catch block is executed");
            System.out.println("Error occurs "+ e.getMessage());
        }
        finally{
            System.out.println("finally block is executed");
        }
    }
}
