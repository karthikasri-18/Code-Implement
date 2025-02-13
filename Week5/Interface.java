package Week5;

interface Greek {
    void speak();
}
class Language implements Greek {
    public void speak(){
        System.out.println("People speak Greek in Greece");
    }
}

public class Interface {
    public static void main(String[] args) {
        Language obj = new Language();
        obj.speak();
    }
}