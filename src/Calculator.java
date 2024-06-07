

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
class Calculator {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Items> itemsList = new ArrayList<>();

    public void devideBill(double totalSum) {
        while (true) {
            System.out.println("Hа сколько человек разделить счёт?");
            int quantity = 0;
            try {
                quantity = scanner.nextInt();

                if (quantity < 1) {
                    System.out.println("Невернное колличество. Попробуйте ещё раз");
                    continue;
                }
            }
            catch (InputMismatchException ime) {
                System.out.println("Вы ввели неверное число");
                scanner.nextLine();
                continue;
            }
            if (quantity == 1) {
                System.out.println("Ты платишь за себя сам " + Format.installPadezh(totalSum));
                break;
            } else {
                double total = totalSum / quantity;
                System.out.println("Каждому из вас нужно заплатить " + Format.installPadezh(total));
                break;
            }

        }
    }

    public void addItems() {

        while (true) {

            System.out.println("Напишите название товара:");
            String product = scanner.next();
            System.out.println("Напишите стоимость продукта в формате рубли.копейки, например 10.45 или 11.40: ");
            double price = 0.0;
            try {
                price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Стоимость не может быть отрицательной, попробуйте ещё раз");
                    continue;
                } else if (price == 0) {
                    System.out.println("Товар не бесплатный, попробуйте ещё раз");
                    continue;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Вы ввели неверное число");
                scanner.nextLine();
                continue;
            }
            Items basket = new Items(product, price);
            itemsList.add(basket);
            System.out.println("Товар успешно добавлен");
            scanner.nextLine();
            System.out.println("Нажмите enter для добавления товара или введите 'завершить' для завершения");
            String end = scanner.nextLine().trim().toLowerCase();
            if (end.equalsIgnoreCase("завершить")) {
                double totalSum = 0.0;
                for (Items total : itemsList) {
                    System.out.println("Вы добавили товар: " + total.product);
                    totalSum += total.price;
                }
                System.out.println("Общая стоимость: " + totalSum);
                devideBill(totalSum);
                break;
            }
        }
    }
}
