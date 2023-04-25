import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

// 3*дополнительно. К калькулятору из предыдущего дз добавить логирование.
// 1 + 3 = 4
// 4 + 3 = 7
/**
 * Task03
 */
public class Task03 {

    public static void main(String[] args) throws IOException{

        Scanner iScanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Task03.class.getName());
        FileHandler fh = new FileHandler("Task03.log.txt");
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        System.out.println("Калькулятор инициирован.");
        CalcIt(iScanner, logger);
        iScanner.close();
    }

    public static void CalcIt(Scanner scanIt, Logger logger) {
        

        System.out.println("Введите число 1: ");

        int num1 = scanIt.nextInt();

        System.out.println("Введите действие: ");
        char my_char = scanIt.next().charAt(0);
        System.out.println("Введите число 2: ");
        int num2 = scanIt.nextInt();

        System.out.println("Ваш результат: ");

        switch (my_char) {
            case '+':
                System.out.println(num1 + num2);
                logger.log(Level.INFO, "Результат " + num1 + " + " + num2 + " = " + (num1 + num2));
                CalcIt(scanIt,logger);
            case '-':
                System.out.println(num1 - num2);
                logger.log(Level.INFO, "Результат " + num1 + " - " + num2 + " = " + (num1 - num2));
                CalcIt(scanIt,logger);
            case '*':
                System.out.println(num1 * num2);
                logger.log(Level.INFO, "Результат " + num1 + " * " + num2 + " = " + num1 * num2);
                CalcIt(scanIt,logger);
            case '%':
                System.out.println(num1 % num2);
                logger.log(Level.INFO, "Результат " + num1 + " % " + num2 + " = " + num1 % num2);
                CalcIt(scanIt,logger);
            case '/':
                if (num1 == 0 || num2 == 0) {
                    System.out.println("Нельзя делить на ноль.\nПопробуй еще.");
                    logger.info("Пользователь - банан.");
                    CalcIt(scanIt,logger);
                }
                System.out.println(num1 / num2);
                logger.log(Level.INFO, "Результат " + num1 + " / " + num2 + " = " + num1 / num2);
                CalcIt(scanIt,logger);
        }
    }
}