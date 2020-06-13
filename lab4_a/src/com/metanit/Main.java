package com.metanit;
/**
 * Создать объект класса Одномерный массив, используя классы Массив,
 *  Элемент. Методы: создать, вывести на консоль, выполнить операции (сложить, вычесть, перемножить).
 *
 * @author Надя
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Массив из целых чисел:");
        run(10, "Integer");
        System.out.println("Arrays of double:");
        run(10, "Double");
    }

    // process arrays with specified type of Numbers
    public static void run(int numberOfElems, String type) {
        OneDimArray arr1 = null;
        OneDimArray arr2 = null;
        OneDimArray arr3 = null;
        if (type.equals("Integer")) {
            arr1 = new OneDimArrayOfInt(numberOfElems, type);
            arr2 = new OneDimArrayOfInt(numberOfElems, type);
            arr3 = new OneDimArrayOfInt(numberOfElems, type);
        }
        if (type.equals("Double")) {
            arr1 = new OneDimArrayOfDouble(numberOfElems, type);
            arr2 = new OneDimArrayOfDouble(numberOfElems, type);
            arr3 = new OneDimArrayOfDouble(numberOfElems, type);
        }
        arr1.create();
        System.out.print("Массив №1: ");
        arr1.output();
        arr2.create();
        System.out.print("Массив №2: ");
        arr2.output();
        arr3.create();
        arr3.addArrays(arr1, arr2);
        System.out.print("Сумма массивов: ");
        arr3.output();
        arr3.subtractArrays(arr1, arr2);
        System.out.print("Разность массивов: ");
        arr3.output();
        arr3.multArrays(arr1, arr2);
        System.out.print("Произведение массивов: ");
        arr3.output();
    }
}
