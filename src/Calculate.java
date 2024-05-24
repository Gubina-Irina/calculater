
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
class Basket{
    String product;
    double price;
    public Basket (String product, double price){
        this.product = product;
        this.price = price;

    }
}
class Format {
    public static String imposeRub(double rub) {
        int intPart = (int) Math.floor(rub);
        int lastDigit = intPart % 10;
        int lastDigit_2 = intPart % 100;
        String form = "%.2f рублей";

        if (lastDigit_2 >= 11 && lastDigit_2 <= 14) {
            String.format(form, rub);
        } else {
            switch (lastDigit) {
                case 1:
                    form = "%.2f рубль";
                case 2, 3, 4:
                    form = "%.2f рубля";
                default:
                    form = "%.2f рублей";
            }
        }
        return String.format(form, rub);
    }
}

    class Calculate {

        Scanner scan = new Scanner(System.in);

         public static void devide(double totalSum){

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Hа сколько человек разделить счёт?");
            int quan = scan.nextInt();

            if (quan<1){
                System.out.println("Невернное колличество. Попробуйте ещё раз");
            }

            if (quan == 1) {
                System.out.println("Ты платишь за себя сам " +Format.imposeRub(totalSum));
                break;
            } else {
                double total=totalSum/quan;
                System.out.println("Каждому из вас нужно заплатить "+Format.imposeRub(total));
                break;
            }
        }
    }

    public void count() {
       ArrayList<String> products = new ArrayList<>();
       ArrayList<Double> prices = new ArrayList<>();
       Scanner scan = new Scanner(System.in);


        while (true) {

            System.out.println("Напишите название товара:");
            String product = scan.next();
            System.out.println("Напишите стоимость продукта в формате рубли.копейки, например 10.45 или 11.40: ");
            double price = scan.nextDouble();

            try {
                if (price < 0) {
                    System.out.println("Стоимость не может быть отрицательной, попробуйте ещё раз");
                    continue;
                }
                if (price==0){
                    System.out.println("Товар не бесплатный, попробуйте ещё раз");
                   continue;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Вы ввели неверное число");
                scan.next();
                continue;
            }

            Basket basket = new Basket(product, price);
            products.add(product);
            prices.add(price);

            System.out.println("Товар успешно добавлен");
            scan.nextLine();
            System.out.println("Нажмите enter для добавления товара или введите 'завершить' для завершения");

            String end = scan.nextLine().trim().toLowerCase();
            if (end.equalsIgnoreCase("завершить")) {
                for (String productList : products) {
                    System.out.println("Вы добавили товары: " + productList);
                }
                double totalSum=0.0;
                for(Double priceList: prices){
                    totalSum+=price;
                System.out.println("Общая стоимость: " + totalSum);
               devide(totalSum);
                break;
            }
                break;
            }
        }
    }
}