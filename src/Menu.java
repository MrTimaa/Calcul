import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    HashMap<Integer, String> dict = new HashMap<>();
    public Menu() {
        dict.put(1, "HEX");
        dict.put(2, "DEC");
        dict.put(3, "OCT");
        dict.put(4, "BIN");
    }

    public int selectSystem(String numStr, Map<Integer, String> dict) {
        int num = 2;
        if (dict.containsValue(numStr.toLowerCase()) || dict.containsValue(numStr.toUpperCase())) {
            for (Map.Entry<Integer, String> value : dict.entrySet()) {
                if (numStr.equalsIgnoreCase(value.getValue())) {
                    num = value.getKey();
                }
            }
        }
        else {
            System.out.println("Нет такой системы счисления");
        }
        return num;
    }
    public int numSystem() {
        System.out.println("Выберите систему счисления\n" + "1." + dict.get(1) + "\n2." + dict.get(2) + "\n3." + dict.get(3)
                + "\n4." + dict.get(4));
        Scanner scan = new Scanner(System.in);
        int num = 4;
        if (scan.hasNextInt()) {
            num = scan.nextInt();
            if (!dict.containsKey(num)) {
                num = 2;
                System.out.println("Нет такой системы счисления");
            }
        } else if (scan.hasNextLine()) {
            String numStr = scan.nextLine();
            num = selectSystem(numStr, dict);
        }

        System.out.println("Выбрана " + dict.get(num) + " система счисления");
        return num;
    }
    public void printMenu() {
        int num = numSystem();
        while (true) {
            switch (num) {
                case 1:
                    new Hex();
                    break;
                case 2:
                    new Dec();
                    break;
                case 3:
                    new Oct();
                    break;
                case 4:
                    new Bin();
                    break;
                default: break;
            }
            System.out.println("\nПродолжить? (y/n)");
            Scanner s = new Scanner(System.in);
            String key = s.nextLine();
            if (key.equalsIgnoreCase("n") || key.equalsIgnoreCase("exit") || key.equalsIgnoreCase("no")) {
                System.out.println("Завершение работы");
                break;
            }
            System.out.println("\nВы хотите изменить систему счисления? (y/n)");
            String ans = s.nextLine();
            if (ans.equalsIgnoreCase("y")) {
                num = numSystem();
            }
        }
    }
}
