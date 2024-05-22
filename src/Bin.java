import java.util.Scanner;

public class Bin extends SystemNum {
    public Bin() {
        super();
    }

    public int inputNum() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("[0-1]+")) { // Проверка, что введены только цифры
                try {
                    number = Integer.parseInt(input, 2);
                    break;
                }
                catch (Exception e) {
                    System.err.println("Слишком большое число, введите значение заново");
                }
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите только цифры.");
            }
        }
        return number;
    }
}
