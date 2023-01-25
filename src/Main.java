import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        List<String> products = new ArrayList<>();

        System.out.println();
        System.out.println("\t" + "Здравствуйте! ");
        System.out.println();
        System.out.println("У нас вы можете: " + "\n" + "\t" + "1. Добавить товар; "
                + "\n" + "\t" + "2. Показать товар; " + "\n" + "\t" + "3. Удалить товар;" +
                "\n" + "\t" + "4. Поиск.");

        System.out.println("--------------------------------------------");

        while (true) {
            System.out.println("Выберете операцию:");
            String input = scan.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            if (operation == 1) {
                System.out.println("Какую покупку хотите добавить?");
                String input1 = scan.nextLine();
                String[] product = input1.split(" ");
                for (int i = 0; i < product.length; i++)
                    products.add(product[i]);
                System.out.println("Итого в списке покупок: " + products.size());

            }
            if (operation == 2)
                if (products.isEmpty()) {
                    System.out.println("Список покупок пуст, добавьте товар!!!");
                } else {
                    System.out.println();
                    System.out.println("Список покупок:");
                    for (int i = 0; i < products.size(); i++) {
                        String product1 = products.get(i);
                        System.out.println((i + 1) + ". " + product1);
                    }
                }
            if (operation == 3) {
                final char dm = (char) 34;
                System.out.println();
                System.out.println("Список покупок:");
                for (int i = 0; i < products.size(); i++) {
                    String product1 = products.get(i);
                    System.out.println((i + 1) + ". " + product1);
                }
                System.out.println("Какую хотите удалить? Введите номер или название");
                String input2 = scan.nextLine();
                try {
                    int num = Integer.parseInt(input2);
                    System.out.println("Покупка " + ANSI_RED + dm + (products.get(num - 1)) + dm + ANSI_RESET + " удалена, список покупок:");
                    products.remove(num - 1);


                } catch (NumberFormatException exception) {
                    products.remove(input2);
                    System.out.println("Покупка " + ANSI_RED + dm + input2 + dm + ANSI_RESET + " удалена, список покупок:");

                } catch (RuntimeException exception) {
                    System.out.println("Такого номера нет!!!");
                } finally {
                    System.out.println("Список покупок:");
                    for (int i = 0; i < products.size(); i++) {
                        String product1 = products.get(i);
                        System.out.println((i + 1) + ". " + product1);

                    }
                }
            }
            if (operation == 4) {
                System.out.println("Введите текст для поиска:");
                String input3 = scan.nextLine();
                String queryLower = input3.toLowerCase();
                System.out.println("Найдено:");
                for (int i = 0; i < products.size(); i++) {
                    String itemLower = products.get(i).toLowerCase();
                    if (itemLower.contains(queryLower)) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                }
            }
        }
        scan.close();
    }
}






