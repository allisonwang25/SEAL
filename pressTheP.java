import java.util.*;

public class pressTheP {

    public static void run()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("hello there~ looking for a meaningless task?");
        input.nextLine();
        System.out.println("well if all your keyboard keys are intact, you've come to the right place ;))\n");
        System.out.println("how many times can you hit the p key? ready, go! (to quit press q)");
        int count =0;
        String s = "";
        while(true)
        {
            System.out.println("prEsS tHe p KeY");
            s = input.nextLine();
            if(s.equals("q"))
            {
                System.out.println("aww--i didn't know you were a quitter");
                break;
            }
            if(s.equals("p"))
                count++;
            else
            {
                System.out.println("wrong key dummy--shame on you!");
                break;
            }
            System.out.println(count);
        }
    }

}
