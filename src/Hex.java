import java.util.Scanner;

public class Hex extends SystemNum {
    public Hex() {
        super();
    }
    public int inputNum() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("[0-9A-Fa-f]+")) { // Проверка, что введены только цифры
                if (input.length() > 1 && input.charAt(0) == '0') {
                    System.out.println("Неверное значение. Убери 0 в начале.");
                }
                else {
                    try {
                        number = Integer.parseInt(input, 16);
                        break;
                    } catch (Exception e) {
                        System.out.println("Слишком большое число, введите значение заново");
                    }
                }
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите только цифры.");
            }
        }
        return number;
    }
}
