package pratice.Test;

/**
 * Created by Amit on 5/6/2015.
 */
public class TestAbstract  extends  TestClass{

    public static void main(String args[])
    {
        System.out.println("Hello works fine");
        TestAbstract tb = new TestAbstract();
        tb.init();
    }

    public void init(){
        System.out.println("inside the init");
    }
}


abstract class TestClass{

            public  abstract void  init();

        }




