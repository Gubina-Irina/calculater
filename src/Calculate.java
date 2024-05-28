

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
class Calculate {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Basket> basketList = new ArrayList<>();

    public void devideBill(double totalSum) {
        while (true) {
            System.out.println("Hа сколько человек разделить счёт?");
            int quantity = scanner.nextInt();

            if (quantity < 1) {
                System.out.println("Невернное колличество. Попробуйте ещё раз");
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

    public void addBasket() {

        while (true) {

            System.out.println("Напишите название товара:");
            String product = scanner.next();
            System.out.println("Напишите стоимость продукта в формате рубли.копейки, например 10.45 или 11.40: ");
            double price = scanner.nextDouble();

            try {
                if (price < 0) {
                    System.out.println("Стоимость не может быть отрицательной, попробуйте ещё раз");
                    continue;
                }
                if (price == 0) {
                    System.out.println("Товар не бесплатный, попробуйте ещё раз");
                    continue;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Вы ввели неверное число");
                scanner.next();
                continue;
            }

            Basket basket = new Basket(product, price);
            basketList.add(basket);
            System.out.println("Товар успешно добавлен");
            scanner.nextLine();
            System.out.println("Нажмите enter для добавления товара или введите 'завершить' для завершения");
            String end = scanner.nextLine().trim().toLowerCase();
            if (end.equalsIgnoreCase("завершить")) {
                double totalSum = 0.0;
                for (Basket total : basketList) {
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