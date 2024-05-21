import java.util.Scanner;

public class Hex extends SystemNum {
    private int a;
    private int b;
    private String operator;
    public Hex() {
        a = inputNum();
        operator = inputOper();
        b = inputNum();
        calculationValues();
    }
    public int inputNum() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("[0-9A-Fa-f]+")) { // Проверка, что введены только цифры
                try {
                    number = Integer.parseInt(input, 16);
                    break;
                }
                catch (Exception e) {
                    System.out.println("Слишком большое число, введите заново");
                }
            } else {
                System.out.println("Неверный ввод. Вводите только цифры.");
            }
        }
        return number;
    }
    @Override
    public void calculationValues() {
        long result = 0;

        if (operator.equals("/") && b == 0) {
            setResult("Деление на ноль невозможно");
            return;
        }

        switch (operator) {
            case "+":
                result = (long)a + (long)b;
                break;
            case "-":
                result = (long)a - (long)b;
                break;
            case "/":
                result = (long)a / (long)b;
                break;
            case "*":
                result = (long)a * (long)b;
                break;
            default:
                break;
        }
        setResult(Long.toHexString(result));
    }
}