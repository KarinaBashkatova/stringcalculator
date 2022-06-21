package string_calculator2;

import java.util.Scanner;

public class calculator {
        public static void main(String[] args) throws calculator_string.resultExceptions {
        try {
                System.out.print("Введите пример: ");
                Scanner scanner = new Scanner(System.in);
                String example = scanner.nextLine();
                calculator_string calc1 = new calculator_string();
                String result = calc1.result(example);
                System.out.println(result);
            } catch (NumberFormatException resultExceptions) {
            throw new RuntimeException(resultExceptions);
        }
            ; }; }





