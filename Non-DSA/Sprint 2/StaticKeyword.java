class Counter {
    static int count = 0;

    Counter() {
        count++;
    }

    static void displayCount() {
        System.out.println("Count =" + count);
    }

}

class Example {
    int instanceVar = 10;

    static void staticMethod() {
        // Creating an instance to access non-static members
        Example obj = new Example();

        System.out.println("Instance variable: " + obj.instanceVar);
    }
}

public class StaticKeyword {
    static {
        System.out.println("Block 1");
    }
    static {
        System.out.println("Block 2");
    }
    // Static blocks are executed in the order they appear in the class.

    public static void main(String[] args) {
        Example.staticMethod();

    }
}
