package string_calculator2;

import java.util.Objects;

public class calculator_string {
    private String part1, part2;
    private String operator;


    private String calculate(String part1, String part2, String operator) {
        String calc;
        switch (operator) {
            case "+" -> {
                calc = (part1 + part2);
            }
            case "-" -> {
                if (part1.contains(part2)) {
                    calc = part1.replace(part2, "");
                } else {
                    calc = part1;
                }
            }
            case "*" -> {
                calc = "";
                int n = Integer.parseInt(part2);
                for (int i = 0; i < n; ++i) {
                    calc += part1;
                }
            }
            case "/" -> {
                calc = "";
                int result1 = (part1.length() / Integer.parseInt(part2));
                calc = part1.substring(0, result1);
            }


            default -> throw new IllegalStateException("Недопустимое значение оператора");
        }
        ;
        if (calc.length() > 40) {
            calc = ("\"" + calc.substring(0, 40) + "..." + "\"");
        } else
        {calc = ("\"" + calc + "\"");}
        return calc;
    }
    ;
    public class resultExceptions extends Exception {
        public resultExceptions() {
            System.out.println("Ошибка при вводе данных");
        }
        public resultExceptions (String message){
            this();
            System.out.println(message);
        }
    }

    public String result (String example) throws resultExceptions
    {
        String[] parts = example.split("\"");

        if (example.charAt(0) != ('\"')) {
            throw new resultExceptions("Проверьте правильность ввода данных. Первая операнда всегда строка в ковычках.");
        };
        switch (parts.length) {
            case 4 -> {
                int n = example.length() - 1;
                if (example.charAt(n) != ('\"')) {throw new resultExceptions("Проверьте правильность ввода данных.");};
                String part1 = parts[1].replace("\"", "");
                String part2 = parts[3].replace("\"", "");
                String operator = parts[2].replace(" ", "");
                if (part1.length()>10 || part2.length()>10) {throw new resultExceptions("Проверьте правильность ввода данных. Длина строки не может быть более 10 символов.");};
                if (Objects.equals(operator, "+") || Objects.equals(operator, "-")) {
                   String calc = calculate(part1, part2, operator);
                   return calc; }
                else {
                    throw new resultExceptions("Проверьте правильность ввода данных.");
                }
            }
            case 3 -> {
                String part1 = parts[1];
                String part3 = parts[2];
                String[] parts2split = part3.split(" ");
                String operator = parts2split[1];
                String part2 = parts2split[2];
                if (part1.length()>10) {throw new resultExceptions("Проверьте правильность ввода данных. Длина строки не может быть более 10 символов");};

                if ((Objects.equals(operator, "*") || Objects.equals(operator, "/")) && (Integer.parseInt(part2)>0 && Integer.parseInt(part2)<= 10))
                {try {
                        Integer.parseInt(part2);
                    } catch (NumberFormatException e) {
                        System.out.println("Проверьте правильность ввода данных. При данной операции второй операндой могут быть только числа от 0 до 10.");
                    }
                    String calc = calculate(part1, part2, operator);
                    return calc;
                    }

                else {
                    throw new resultExceptions("Проверьте правильность ввода данных.");
                }
            }

            default -> throw new IndexOutOfBoundsException("Проверьте правильность ввода данных.");
        }
    }
}