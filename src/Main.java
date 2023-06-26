import java.util.Random;

/**
 * Задание про интернет-магазин:
 * Класс «Эмуляция интернет-магазина».
 * 1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и
 * заказ (объект покупатель, объект товар, целочисленное количество).
 * 2. Создать массив покупателей (инициализировать 2 элемента), массив товаров
 * (инициализировать 5 элементов) и массив заказов (пустой на 5 элементов).
 * 3. Создать статический метод «совершить покупку» со строковыми параметрами,
 * соответствующими полям объекта заказа. Метод должен вернуть объект заказа.
 * 4. Если в метод передан несуществующий покупатель – метод должен выбросить
 * исключение CustomerException, если передан несуществующий товар, метод
 * должен выбросить исключение ProductException, если было передано отри-
 * цательное или слишком больше значение количества (например, 100), метод
 * должен выбросить исключение AmountException.
 * Вызвать метод совершения покупки несколько раз таким образом, чтобы запол-
 * нить массив покупок возвращаемыми значениями. Обработать исключения сле-
 * дующим образом (в заданном порядке):
 * – если был передан неверный товар – вывести в консоль сообщение об ошиб-
 * ке, не совершать данную покупку;
 * – если было передано неверное количество – купить товар в количестве 1;
 * – если был передан неверный пользователь – завершить работу приложения
 * с исключением.
 * Вывести в консоль итоговое количество совершённых покупок после выполне-
 * ния основного кода приложения.
 */
public class Main {
    static Buyer[] buyers;
    static Product[] products;

    public static void main(String[] args) throws CustomerException, AmountException, ProductException {
        buyers = new Buyer[]{
                new Buyer("Maxim", "Maximow", 32,Gender.MALE, "89204316023"),
                new Buyer("Inna", "Ivanova", 30,Gender.FEMALE, "89204316099"),
        };

        products = new Product[]{
                new Product("Milk", 100),
                new Product("Meat", 500),
                new Product("Soda", 50),
                new Product("Bread", 70),
                new Product("Tea", 200)
        };

        Order[] orders = new Order[5];

        // Совершаем покупки
        Random random;
        for (int i = 0; i < orders.length; i++) {
//            random = new Random();
//            int j = random.nextInt(2);
//            int k = random.nextInt(6);
            // Тест
            int j = 0;
            int k = 3;

            result(orders);
            try {
                if (j == 1 & k != 5) {
                    orders[i] = makePurchase(null, products[k].getProductName(), (50 * i));
                } else if (k == 5 & j != 1) {
                    orders[i] = makePurchase(buyers[j].getPhone(), null, (50 * i));
                } else if (k == 5 && j == 1) {
                    orders[i] = makePurchase(null, null, (50 * i));
                } else {
                    orders[i] = makePurchase(buyers[j].getPhone(), products[k].getProductName(), (50 * i));
                }

            } catch (ProductException e) {
                System.out.println(e.getMessage());
            } catch (AmountException e) {
                e.getMessage();
                if (k == 5 || j == 1) {
                    orders[i] = makePurchase(buyers[j].getPhone(), products[1].getProductName(), 1);
                } else {
                    orders[i] = makePurchase(buyers[j].getPhone(), products[k].getProductName(), 1);
                }

            } catch (CustomerException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public static Order makePurchase(String phone, String productName, int count) throws ProductException, AmountException, CustomerException {
        Buyer buyer = null;
        Product product = null;
        for (Buyer b : buyers) {
            if (b.getPhone().equals(phone)) {
                buyer = b;
            }
        }
        for (Product p : products) {
            if (p.getProductName().equals(productName)) {
                product = p;
            }
        }
        if (buyer == null) {
            throw new CustomerException("Покупатель не найден");
        }
        if (product == null) {
            throw new ProductException("Товар не найден");
        }
        if ((count < 1) || (count >= 100)) {
            throw new AmountException("Не правельное количество товара");
        }


        return new Order(buyer, product, count);
    }


    public static void result(Order[] orders){
        int cnt = 0;
        for (Order o : orders) {
            if (o != null) {
                cnt++;
            }
        }
        System.out.println("Количество совершенных покупок: " + cnt);
    }


}