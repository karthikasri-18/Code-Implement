public class Methods {
	public class A {
	      void plant1 () {
	            System.out.println("Instance method is called");
	      }
	      static void plant2() {
	              System.out.println("Static method is called");  
	      } 
	       final void plant3() {
	             System.out.println("Final Method is called");
	       }
	}
	abstract class B {
	        void wood(){}
	}
	class C extends B{
	         void wood () {
	               System.out.println("Abstract method is implemented");
	         }
	}
	class D extends A{
	      void plant() {
	            System.out.println("Final method cannot override");
	      }
	}

	public static void main (String[] args)  {
            A.plant2();
            Methods methods = new Methods();
            A obj1 = methods.new A();
            obj1.plant1();
            obj1.plant3();
            C obj2 = methods.new C();
            obj2.wood();
     }
}
