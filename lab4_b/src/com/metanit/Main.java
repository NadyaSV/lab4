package com.metanit;
/**
 * 	Фургон кофе. Загрузить фургон определенного объема грузом на
 * определенную сумму из различных сортов кофе, находящихся в тому же
 * в разных физических состояниях (зерно, молотый, растворимый в банках
 * и пакетиках). Учитывать объем кофе вместе с упаковкой.
 * Провести сортировку товаров на основе соотношения цены и веса.
 * Найти товар в фургоне, соответствующий заданному диапазону параметров
 * качества.
 *
 * @author Надя
 */

import wagon.Wagon;
import product.Product;
import product.Coffee;


public class Main {
    // размер вагона
    static final double totalVolume = 2;   // в m^3

    // сколько можно вместить в вагон
    static final double totalAmaunt = 20000; // в USD

    static Coffee CreateProduct(String sort, Coffee.CoffeeType type,
                                Double price, Double netWeight,
                                Coffee.CoffeePack pack)
            throws IllegalArgumentException{
        validation (sort, price, netWeight);
        return new  Coffee(sort, type, price, netWeight, pack);
    }


    static void validation (String sort, Double price, Double netWeight)
            throws IllegalArgumentException{
        if(price <= 0) {
            throw new IllegalArgumentException("Illegal argument 'price' = " + price);
        }

        if(netWeight <= 0){
            throw new IllegalArgumentException("Illegal argument 'netWeight' = " + netWeight);
        }

        if(sort.isEmpty()) {
            throw new IllegalArgumentException("Illegal argument 'sort'  Empty string" );
        }
    }


    public static void main(String... args) {


        /* Создание вагона */
        Wagon wagon = new Wagon(totalVolume, totalAmaunt);

        /* Создание разных видов кофе */
        Product coffee1 = CreateProduct("Arabika",Coffee.CoffeeType.Зерно,
                70.0, 0.2, Coffee.CoffeePack.Банка);

        Product coffee2 = CreateProduct("Robusta",Coffee.CoffeeType.Молотый,
                71.5, 0.1, Coffee.CoffeePack.Банка);

        Product coffee3 = CreateProduct("Santos",Coffee.CoffeeType.Растворимый,
                58.0, 0.05, Coffee.CoffeePack.Банка);

        Product coffee4 = CreateProduct("Arabika",Coffee.CoffeeType.Растворимый,
                70.0, 0.2, Coffee.CoffeePack.Пакет);

        Product coffee5 = CreateProduct("Robusta",Coffee.CoffeeType.Молотый,
                71.5, 0.2, Coffee.CoffeePack.Пакет);

        Product coffee6 = CreateProduct("Robusta",Coffee.CoffeeType.Зерно,
                71.5, 0.2, Coffee.CoffeePack.Банка);

        /* Loading the wagon */
        for (; ;){
            if (!wagon.addPack(coffee1, 8)) {  // wagon is full
                break;
            }
            if (!wagon.addPack(coffee2, 6)) {
                break;
            }
            if (!wagon.addPack(coffee3, 8)) {
                break;
            }
            if (!wagon.addPack(coffee4, 5)) {
                break;
            }
            if (!wagon.addPack(coffee5, 7)) {
                break;
            }
            if (!wagon.addPack(coffee6, 12)) {
                break;
            }
        }

        /* Сортировка по соотношению  цены и веса */
        System.out.println(wagon.selectByPrice(3.0, 10.0).toString());

        /* Сортировка по заданному качеству */
        System.out.println(wagon.sortByQuality().toString());

        System.out.println("Вагон содержит: \n" + wagon.toString());

    }

}