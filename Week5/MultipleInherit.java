package Week5;

interface Color {
    void Blue();
}

interface Texture extends Color{
    void Satin();
}

interface Finish {
    void Matte();
}

class Dress implements Texture,Finish {
    public void Blue(){
        System.out.println("The dress is in Powder Blue shade");
    }
    public void Satin(){
        System.out.println("The dress is made with Satin material");
    }
    public void Matte() {
        System.out.println("The dress is in Matte finish");
    }
}
public class MultipleInherit {
    public static void main(String[] args) {
        Dress obj = new Dress();
        obj.Satin();
        obj.Matte();
        obj.Blue();
    }
}
