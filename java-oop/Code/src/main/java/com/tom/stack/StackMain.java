package com.tom.stack;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack <Character> characterStack= new Stack<>();
        characterStack.push('T');
        characterStack.push('h');
        characterStack.push('o');
        characterStack.push('r');

        int characterStackSize = characterStack.size();
        for (int i = 0; i < characterStackSize; i++) {
            System.out.println(characterStack.pop());
        }
    }
}
