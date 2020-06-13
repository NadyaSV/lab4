package com.metanit;

public class MyElem <T extends Number> {
    public static final int MAX_VALUE = 1000;
    private T value;

    public MyElem() {}

    public MyElem (T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    // возвращает сумму Elem and given
    public MyElem sum(MyElem addend, String type) {
        MathOperation op = new MathSum();
        return op.process(this, addend, type);
    }

    // возвращает разность  Elem and given
    public MyElem subs(MyElem deducted, String type) {
        MathOperation op = new MathSubstruct();
        return op.process(this, deducted, type);
    }

    // возвращает произведение Elem and given
    public MyElem mult(MyElem multiplier, String type) {
        MathOperation op = new MathMultiply();
        return op.process(this, multiplier, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MyElem<?> myElem = (MyElem<?>) obj;
        return value.equals(myElem.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}