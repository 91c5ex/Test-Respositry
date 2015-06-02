package pratice.test1;

/**
 * Created by Amit on 5/10/2015.
 */
public class abc {


    public static void main(String args[])
    {


        if("String".endsWith(""))
        {
            System.out.print("a");
        }
        else
        {
            System.out.print("b");
        }

        Hello h = new Hello();

    }

}

class Hello{

    private void show(Object obj)
    {
        Hello h = (Hello)obj;
        System.out.println(h.toString());
    }
}