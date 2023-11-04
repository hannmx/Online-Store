package org.hannmx;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Customer customer1 = new Customer("Иван");
        Customer customer2 = new Customer("Вася");
        customers.add(customer1);
        customers.add(customer2);

        Product product1 = new Product("Кепка", 300);
        Product product2 = new Product("Штаны", 2500);
        products.add(product1);
        products.add(product2);
        try {
            Order order1 = makeShopping(customer1, product1, 2);
            orders.add(order1);
            System.out.println("Размещенный заказ пользователя " + customer1.getName() + ": Общая стоимость = " + order1.getTotalPrice() + " рублей");

            Order order2 = makeShopping(customer2, product2, 1);
            orders.add(order1);
            System.out.println("Размещенный заказ пользователя " + customer2.getName() + ": Общая стоимость = " + order2.getTotalPrice() + " рублей");
        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Общее количество заказов интернет-магазина: " + orders.size());
    }
    public static Order makeShopping(Customer customer, Product product, int amount) {
        if (!customers.contains(customer)) {
            throw new IllegalArgumentException("Клиент не существует!");
        }
        if (!products.contains(product)) {
            throw new IllegalArgumentException("Продукт не существует!");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Количество должно быть больше 0!");
        }

        Order order = new Order(customer, product, amount);
        return order;
    }
}