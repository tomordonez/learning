package com.tom.S1_Classes_And_Objects.stack;

import java.util.Stack;

public class Main {
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
