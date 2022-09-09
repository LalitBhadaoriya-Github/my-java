import java.util.*;

public class bodmas {

    public static int solved(String equation){
        char[] arr_val = equation.toCharArray();
        String sg = "";
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> sym_obj = new Stack<Character>();
        for (int i = 0; i < arr_val.length; i++){
            if (arr_val[i] == ' ')
                continue;
            if (arr_val[i] >= '0' && arr_val[i] <= '9'){
                sg += arr_val[i];
                values.push(Integer.parseInt(sg.toString()));
                sg = "";
            }
            else if (arr_val[i] == '(')
                sym_obj.push(arr_val[i]);
            else if (arr_val[i] == ')') {
                while (sym_obj.peek() != '(')
                    values.push(operat(sym_obj.pop(), values.pop(), values.pop()));
                sym_obj.pop();
            }
            else if (arr_val[i] == '+' || arr_val[i] == '-' ||
                    arr_val[i] == '*' || arr_val[i] == '/')
            {
                while (!sym_obj.empty() && Precedence(arr_val[i], sym_obj.peek()))
                    values.push(operat(sym_obj.pop(), values.pop(), values.pop()));
                sym_obj.push(arr_val[i]);
            }
        }
        while (!sym_obj.empty())
            values.push(operat(sym_obj.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean Precedence(char oper_1, char oper_2){
        if (oper_2 == '(' || oper_2 == ')')
            return false;
        if ((oper_1 == '*' || oper_1 == '/') && (oper_2 == '+' || oper_2 == '-'))
            return false;
        else
            return true;
    }

    public static int operat(char oper, int var2, int var1)
    {
        switch (oper){
            case '+':
                return var1 + var2;
            case '-':
                return var1 - var2;
            case '*':
                return var1 * var2;
            case '/':
                if (var2 == 0)
                    throw new
                            ArithmeticException("division by zero.. impossible!");
                return var1 / var2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the equation: ");
        String str = input.nextLine();
        System.out.println(com.company.Bodmass.solved(str));
    }
}