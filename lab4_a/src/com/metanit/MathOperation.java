package com.metanit;

abstract class MathOperation {
    MyElem process(MyElem e1, MyElem e2, String type) {return new MyElem(); }

    boolean checkIllegalArgs(MyElem e1, MyElem e2) {
        if (e1 == null)
            return true;
        if (e2 == null)
            return true;
        return false;
    }
}

class MathSum extends MathOperation {
    @Override
    public MyElem process(MyElem e1, MyElem e2, String type) {
        if (checkIllegalArgs(e1, e2))
            throw new IllegalArgumentException("Разные типы элементов!");
        MyElem res = new MyElem();
        if (type == "Integer") {
            int s = e1.getValue().intValue() + e2.getValue().intValue();
            res.setValue(s);
        }
        if (type == "Double") {
            double s = e1.getValue().doubleValue() + e2.getValue().doubleValue();
            res.setValue(s);
        }
        return res;


    }
}

class MathSubstruct extends MathOperation {
    @Override
    public MyElem process(MyElem e1, MyElem e2, String type) {
        if (checkIllegalArgs(e1, e2))
            throw new IllegalArgumentException("Разные типы элементов!");
        MyElem res = new MyElem();
        if (type == "Integer") {
            int s = e1.getValue().intValue() - e2.getValue().intValue();
            res.setValue(s);
        }
        if (type == "Double") {
            double s = e1.getValue().doubleValue() - e2.getValue().doubleValue();
            res.setValue(s);
        }
        return res;
    }
}

class MathMultiply extends MathOperation {
    @Override
    public MyElem process(MyElem e1, MyElem e2, String type) {
        if (checkIllegalArgs(e1, e2))
            throw new IllegalArgumentException("Разные типы элементов!");
        MyElem res = new MyElem();
        if (type == "Integer") {
            int s = e1.getValue().intValue() * e2.getValue().intValue();
            res.setValue(s);
        }
        if (type == "Double") {
            double s = e1.getValue().intValue() * e2.getValue().intValue();
            res.setValue(s);
        }
        return res;
    }
}