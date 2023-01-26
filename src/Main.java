import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        List<String> products = new ArrayList<>();

        reviewOperation();

        while (true) {
            System.out.println("Выберете операцию:");
            String input = scan.nextLine();;
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    addProducts(scan, products);
                    break;
                case 2:
                    seeProducts(products);
                    break;
                case 3:
                    deleteProducts(scan, products);
                    break;
                case 4:
                    searchProduct(scan, products);
                    break;
            }
        }
        scan.close();
    }

    private static void reviewOperation() {
        System.out.println();
        System.out.println("\t" + "Здравствуйте! ");
        System.out.println();
        System.out.println("Доступные команды: " + "\n" + "1. Добавить товар; " + "\n" + "2. Показать товар; " + "\n"
                + "3. Удалить товар;" + "\n" + "4. Поиск.");

        System.out.println("--------------------------------------------");
    }

    private static void addProducts(Scanner scan, List<String> products) {
        System.out.println("Какую покупку хотите добавить? (перечислите через запятую)" );
        String input = scan.nextLine();;
        String[] product = input.split(",");
        for (int i = 0; i < product.length; i++)
            products.add(product[i]);
        System.out.println("Итого в списке покупок: " + products.size());
    }

    private static void seeProducts(List<String> products) {
        if (products.isEmpty()) {
            System.out.println("Список покупок пуст, добавьте товар!!!");
        } else {
            System.out.println();
            System.out.println("Список покупок:");
            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i);
                System.out.println((i + 1) + ". " + product);
            }
        }
    }

    private static void deleteProducts(Scanner scan, List<String> products) {
        final char dm = (char) 34;
        System.out.println();
        System.out.println("Список покупок:");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            System.out.println((i + 1) + ". " + product);
        }
        System.out.println("Какую хотите удалить? Введите номер или название");
        String input = scan.nextLine();;
        try {
            int num = Integer.parseInt(input);
            System.out.println("Покупка " + ANSI_RED + dm + (products.get(num - 1)) + dm + ANSI_RESET + " удалена, список покупок:");
            products.remove(num - 1);

        } catch (NumberFormatException exception) {
            products.remove(input);
            System.out.println("Покупка " + ANSI_RED + dm + input + dm + ANSI_RESET + " удалена, список покупок:");

        } catch (RuntimeException exception) {
            System.out.println("Такого номера нет!!!");

        } finally {
            System.out.println("Список покупок:");
            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i);
                System.out.println((i + 1) + ". " + product);

            }
        }
    }

    private static void searchProduct(Scanner scan, List<String> products) {
        System.out.println("Введите текст для поиска:");
        String input = scan.nextLine();;
        String queryLower = input.toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < products.size(); i++) {
            String itemLower = products.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + "." + products.get(i));
            }
        }
    }
}







