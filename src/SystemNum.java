import java.util.Scanner;

public abstract class SystemNum {
    private Long result;
    private int a;
    private int b;
    private String operator;

    protected SystemNum() {
        a = inputNum();
        inputOper();
        b = inputNum();
        calculationValues();
    }

    public void inputOper() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математический оператор: ");
        while (true) {
            operator = scanner.nextLine();
            if (operator.matches("[+\\-*/]")) {
                break;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите один из следующих операторов: +, -, *, /");
            }
        }
    }
    public abstract int inputNum();

    public void calculationValues() {
        try {
            switch (operator) {
                case "+":
                    result = (long) a + (long) b;
                    break;
                case "-":
                    result = (long) a - (long) b;
                    break;
                case "/":
                    result = (long) a / (long) b;
                    break;
                case "*":
                    result = (long) a * (long) b;
                    break;
                default:
                    break;
            }
            printResult();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    protected void printResult() {
        System.out.println("Результат:");
        System.out.println("HEX\t" + (Long.toHexString(result)));
        System.out.println("DEC\t" + (result));
        System.out.println("OCT\t" + (Long.toOctalString(result)));
        System.out.println("BIN\t" + (Long.toBinaryString(result)));
    }

}
