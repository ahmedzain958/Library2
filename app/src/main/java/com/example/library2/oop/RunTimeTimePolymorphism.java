package com.example.library2.oop;
//  Compile-time Polymorphism in java Example:

public class RunTimeTimePolymorphism {

    public class Animal {
        public void sound() {
            System.out.println("Animal makes a sound");
        }
    }

    public class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("Dog barks");
        }
    }

    public class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("Cat meows");
        }
    }

    class Main {
        public void main() {
            Animal animal1 = new Dog();
            animal1.sound(); // Output: "Dog barks"
            Animal animal2 = new Cat();
            animal2.sound(); // Output: "Cat meows"
        }
    }
}
