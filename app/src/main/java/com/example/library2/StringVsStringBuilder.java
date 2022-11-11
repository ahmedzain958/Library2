package com.example.library2;

public class StringVsStringBuilder {
    public static void main(String[] args) {
        String test = "a";
        int firstAddressOfTest = System.identityHashCode(test);
        test += "b";
        int secondAddressOfTest = System.identityHashCode(test);
        System.out.println(firstAddressOfTest == secondAddressOfTest);

        StringBuilder test2 = new StringBuilder();
        test2.append("a");
        int firstAddressOfTest2 = System.identityHashCode(test);
        test2.append("b");
        int secondAddressOfTest2 = System.identityHashCode(test);

        System.out.println(firstAddressOfTest2 == secondAddressOfTest2);
    }
}
