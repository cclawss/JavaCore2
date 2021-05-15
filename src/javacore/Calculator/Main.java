package javacore.Calculator;

//Проблема была в том что на 0 делить нельзя, поэтому я добавил обработку ошибок.

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        try {
            int a = calc.plus.apply(1, 2);
            int b = calc.minus.apply(1, 1);
            if (b == 0) {
                throw new ArithmeticException("На ноль делить нельзя!");
            }
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException ae) {
            System.out.println("Арифметическая ошибка");
            System.out.println(ae.getMessage());
        }
    }
}
