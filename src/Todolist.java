import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Todolist {
    public static void main(String[] args) {
        ArrayList<String> businessList = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        while(true) {
            String[] t = scanner.nextLine().split("\\s+", 3);
            switch (t[0]) {
                case ("LIST"): {
                    for (int i = 0; i < businessList.size(); i++) {
                        if (businessList.get(i) != null) {
                            System.out.println(i + " - " +  businessList.get(i));
                        }
                    }
                    break;
                }
                case ("ADD"): {
                    if (Pattern.matches("[0-9]", t[1])) {
                        if (Integer.parseInt(t[1]) < businessList.size() && Integer.parseInt(t[1]) >= 0) {
                            businessList.add(Integer.parseInt(t[1]), t[2]);
                        } else {
                            businessList.add(t[2]);
                        }
                    } else {
                        if (t.length > 2) {
                            String conc = t[1] + t[2];
                            businessList.add(conc);
                        } else {
                            businessList.add(t[1]);
                        }
                    }
                    break;
                }
                case ("EDIT"): {
                    if (Pattern.matches("[0-9]", t[1])) {
                        int num = Integer.parseInt(t[1]);
                        if (num < businessList.size() && num > 0) {
                            businessList.set(num, t[2]);
                        } else {
                            System.out.println("Такой записи не существует");
                        }
                        break;
                    }
                }
                case ("DELETE"): {
                    if (Pattern.matches("[0-9]", t[1])) {
                        int num = Integer.parseInt(t[1]);
                        if (num < businessList.size() && num > 0) {
                            businessList.remove(num);
                        } else {
                            System.out.println("Такой записи не существует");
                        }
                        break;
                    }
                }
                default: {
                    System.out.println("Неверный ввод" );
                    break;
                }
            }
        }


    }
}