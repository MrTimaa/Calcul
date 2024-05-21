import java.util.Scanner;

public class Dec extends SystemNum {

    private int a;
    private int b;
    private String operator;
    public Dec() {
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

            if (input.matches("\\d+")) {
                try {
                    number = Integer.parseInt(input, 10);
                    if (String.valueOf(number).charAt(0) == '0' && String.valueOf(number).length()>1){
                        System.out.println("Число не может начинаться с нуля");
                        inputNum();
                    }
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
        setResult(Long.toString(result));
    }
}
