package com.metanit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class MyArray {
    protected int dimensions;
    protected String type;
    public MyArray() {}

    public abstract void create();

    public void output() {
        System.out.println(dimensions + "-мерный массив:");
        System.out.print(" [");
    }
}

public class OneDimArray extends MyArray {
    protected int numberOfElems;
    protected List<MyElem> elements;

    public OneDimArray() {
        dimensions = 1;
        elements = new ArrayList<>();
    }

    public OneDimArray(int numberOfElems, String type) {
        this();
        this.type = type;
        this.numberOfElems = numberOfElems;
    }

    public void setNumberOfElems(int numberOfElems) {
        this.numberOfElems = numberOfElems;
    }

    @Override
    public void create() {}

    @Override
    public void output() {
        super.output();
    }

    // finds sum of 2 arrays
    public void addArrays(OneDimArray arr1, OneDimArray arr2) {
        checkArrays(arr1);
        checkArrays(arr2);
        int i = 0;
        for (MyElem element : elements) {
            MyElem e1 = arr1.elements.get(i);
            MyElem e2 = arr2.elements.get(i++);
            element.setValue(e1.sum(e2, type).getValue());
        }
    }

    // finds subtract of 2 arrays
    public void subtractArrays(OneDimArray arr1, OneDimArray arr2) {
        checkArrays(arr1);
        checkArrays(arr2);
        int i = 0;
        for (MyElem element : elements) {
            MyElem e1 = arr1.elements.get(i);
            MyElem e2 = arr2.elements.get(i++);
            element.setValue(e1.subs(e2, type).getValue());
        }
    }

    // finds multiplication of 2 arrays
    public void multArrays(OneDimArray arr1, OneDimArray arr2) {
        checkArrays(arr1);
        checkArrays(arr2);
        int i = 0;
        for (MyElem element : elements) {
            MyElem e1 = arr1.elements.get(i);
            MyElem e2 = arr2.elements.get(i++);
            element.setValue(e1.mult(e2, type).getValue());
        }
    }

    // checks array if it has legal arguments
    private void checkArrays(OneDimArray array) {
        if (checkNull(array))
            throw new IllegalArgumentException("Null addend array!");
        if (type != array.type)
            throw new IllegalArgumentException("Different types of Numbers!");
        if (numberOfElems != array.numberOfElems)
            throw new IllegalArgumentException("Different number of MyElems!");
    }

    private boolean checkNull(OneDimArray arrAdded) {
        return arrAdded == null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        OneDimArray that = (OneDimArray) obj;
        if (numberOfElems != that.numberOfElems) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return elements != null ? elements.equals(that.elements) : that.elements == null;

    }

    @Override
    public int hashCode() {
        int result = numberOfElems;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (elements != null ? elements.hashCode() : 0);
        return result;
    }
}

class OneDimArrayOfInt extends OneDimArray {

    public OneDimArrayOfInt(int numberOfElems, String type) {
        super(numberOfElems, type);
    }

    // creates random array of int elements
    @Override
    public void create() {
        super.create();
        Random rand = new Random();
        for (int i = 0; i < numberOfElems; i++) {
            int val = rand.nextInt(MyElem.MAX_VALUE);
            elements.add(new MyElem(val));
        }
    }

    // prints array of int elements
    @Override
    public void output() {
        super.output();
        for (MyElem element : elements) {
            System.out.print(String.format(" %7d", element.getValue()));
        }
        System.out.println(" ]");
    }
}

class OneDimArrayOfDouble extends OneDimArray {

    public OneDimArrayOfDouble(int numberOfElems, String type) {
        super(numberOfElems, type);
    }

    // creates random array of double elements
    @Override
    public void create() {
        super.create();
        Random rand = new Random();
        for (int i = 0; i < numberOfElems; i++) {
            double val = rand.nextDouble() * MyElem.MAX_VALUE;
            elements.add(new MyElem(val));
        }
    }

    // prints array of double elements
    @Override
    public void output() {
        super.output();
        for (MyElem element : elements) {
            System.out.print(String.format(" %10.3f", (double) element.getValue()));
        }
        System.out.println(" ]");
    }
}