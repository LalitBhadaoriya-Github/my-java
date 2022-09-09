import java.util.*;

public class roman {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number 1 to 500: ");
        int num = sc.nextInt();
        roman roman = new roman();
        roman.numb(num);
    }

    static void numb(int number){
        char c[] = new char[10001];
        int i = 0;

        if (number <= 0) {
            System.out.printf("Invalid number");
            return;
        }

        while (number != 0) {

            if (number >= 500) {
                i = digit('D', number / 500, i, c);
                number = number % 500;
            }
            else if (number >= 100) {

                if (number < 400) {
                    i = digit('C', number / 100, i, c);
                    number = number % 100;
                }
                else {
                    i = sub_digit('C', 'D', i, c);
                    number = number % 100;
                }
            }
            else if (number >= 50) {

                if (number < 90) {
                    i = digit('L', number / 50, i, c);
                    number = number % 50;
                }
                else {
                    i = sub_digit('X', 'C', i, c);
                    number = number % 10;
                }
            }
            else if (number >= 10) {

                if (number < 40) {
                    i = digit('X', number / 10, i, c);
                    number = number % 10;
                }
                else {
                    i = sub_digit('X', 'L', i, c);
                    number = number % 10;
                }
            }
            else if (number >= 5) {
                if (number < 9) {
                    i = digit('V', number / 5, i, c);
                    number = number % 5;
                }
                else {
                    i = sub_digit('I', 'X', i, c);
                    number = 0;
                }
            }
            else if (number >= 1) {
                if (number < 4) {
                    i = digit('I', number, i, c);
                    number = 0;
                }
                else {
                    i = sub_digit('I', 'V', i, c);
                    number = 0;
                }
            }
        }

        System.out.printf("Roman numeral is: ");
        for (int j = 0; j < i; j++) {
            System.out.printf("%c", c[j]);
        }
    }

    static int sub_digit(char num1, char num2, int i, char[] c) {
        c[i++] = num1;
        c[i++] = num2;
        return i;
    }

    static int digit(char ch, int n, int i, char[] c) {
        for (int j = 0; j < n; j++) {
            c[i++] = ch;
        }
        return i;
    }
}
