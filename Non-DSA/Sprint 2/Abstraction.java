abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("The dog " + name + " says : Woof!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("The cat " + name + " says : Meow!");
    }
}

class Abstraction {
    public static void main(String[] args) {

    }
}

/*
 * You are required to design a program that utilizes an abstract class Animal
 * to serve as the foundation for specific animal classes. The objective is to
 * demonstrate runtime polymorphism where derived classes override the behaviour
 * of the abstract method makeSound(). The program should include:
 * 
 * An abstract class Animal :
 * 
 * Attributes :
 * 
 * name (string) : Represents the name of the animal.
 * Abstract Method :
 * 
 * makeSound() : To print the sound specific to the animal.
 * Derived Classes :
 * 
 * Dog class : Inherits class Animal and overrides the makeSound() method to
 * print "Woof!".
 * Cat class : Inherits class Animal and overrides the makeSound() method to
 * print "Meow!".
 * Refer sample example to understand about the output format.
 * 
 * Refer the commented code on IDE to view the output statements.
 * 
 * Example 1:
 * Input : d_name = "Buddy" , c_name = 'Whiskers"
 * 
 * Output :
 * 
 * The dog Buddy says : Woof!
 * 
 * The cat Whiskers says : Meow!
 * 
 * Explanation :
 * 
 * First the object of Dog class is created with the name provided for the dog.
 * Then the dog object is used to call the makeSound() method to print the
 * output for the dog.
 * Now the object of Cat class is created with name provided for the cat.
 * Then the cat object is used to call the makeSound() method to print the
 * output for the cat.
 */