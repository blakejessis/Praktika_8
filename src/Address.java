import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Address {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> mailSet = new TreeSet<>();

        String[] s;

        while (true) {
            s = sc.nextLine().split("\\s+");
            switch (s[0]) {
                case ("ADD"):
                    if (isMailCorrect(s[1]))
                        mailSet.add(s[1]);
                    else
                        System.out.println("Неверный ввод");
                    break;

                case ("LIST"):
                    for (String mail : mailSet)
                        System.out.println(mail);

                    break;

                default:
                    System.out.println("Данная команда отсутствует");
            }
        }
    }


    static boolean isMailCorrect(String s) {
        return Pattern.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", s);
    }
}