package Week5;

class InvalidAgeException extends Exception{
    public InvalidAgeException (String message) {
        super(message);
    }
}

class Check {
    public void Age(int age) throws InvalidAgeException {
        if (age < 18){
            throw new InvalidAgeException("Invalid age! Age should be greater than 18");
        }
        else{
            System.out.println("Eligible!");
        }
    }
}

public class CustomExcept {
    public static void main(String[] args) {
        try{
            Check obj = new Check();
            obj.Age(16);
        }
        catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
}