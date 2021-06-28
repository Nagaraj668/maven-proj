package org.example;

import java.util.Stack;

public class CustomStack extends Stack {

    int minElement;

    public static void main(String[] args) {
        CustomStack integers = new CustomStack();
        integers.push(3);
        System.out.println("minElement: " + integers.minElement);
        integers.push(5);
        System.out.println("minElement: " + integers.minElement);
        integers.push(2);
        System.out.println("minElement: " + integers.minElement);
        integers.push(1);
        System.out.println("minElement: " + integers.minElement);

        System.out.println(integers.pop());
        System.out.println("minElement: " + integers.minElement);
        System.out.println(integers.pop());
        System.out.println("minElement: " + integers.minElement);
        System.out.println(integers.pop());
        System.out.println("minElement: " + integers.minElement);
    }

    @Override
    public Object push(Object item) {
        int numInserted = (int) item;
        if (isEmpty()) {
            minElement = numInserted;
            super.push(numInserted);
            return null;
        } else if (numInserted < minElement) {
            super.push((numInserted * 2) - minElement);
            minElement = numInserted;
            return null;
        }
        return super.push(numInserted);
    }

    //test

    @Override
    public synchronized Object pop() {
        int numPopped = (Integer) super.pop();
        int pop = numPopped;
        if (numPopped < minElement) {
            numPopped = minElement;
            minElement = (2 * minElement) - pop;
        }
        return numPopped;
    }
}
