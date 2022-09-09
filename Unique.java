import java.util.*;

public class Unique {
    public static void main(String[] args)
    {
        Scanner a = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String strin= a.nextLine();
        Unique unique = new Unique();
        unique.combination(strin,"");
    }


    static void combination(String str, String ans)
    {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String all = str.substring(0, i) + str.substring(i + 1);
            Unique.combination(all, ans + ch);
        }
    }

}
