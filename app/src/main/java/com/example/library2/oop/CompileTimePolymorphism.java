package com.example.library2.oop;
//  Compile-time Polymorphism in java Example:

public class CompileTimePolymorphism {

    public class PolymorphismExample {
        public static void main(String[] args) {
            int sum1 = add(5, 3);
            int sum2 = add(5, 3, 2);

            System.out.println("Sum 1: " + sum1); // Output: Sum 1: 8
            System.out.println("Sum 2: " + sum2); // Output: Sum 2: 10
        }

        public static int add(int a, int b) {
            return a + b;
        }

        public static int add(int a, int b, int c) {
            return a + b + c;
        }
    }
}
