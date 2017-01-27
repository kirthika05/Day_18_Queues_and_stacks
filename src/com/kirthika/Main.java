package com.kirthika;

import java.util.*;

public class Main {

    char[] stringStack;
    char[] stringQueue;
    int currStack;
    int currQueue;

    public Main(){
        currStack=0;
        currQueue=0;
        stringStack=new char[10];
        stringQueue=new char[10];
    }

    void pushCharacter(char c){
        stringStack[currStack]=c;
        currStack++;
    }

    void enqueueCharacter(char c){
        for(int i=currQueue;i>0;i--){


            stringQueue[i]=stringQueue[i-1];
        }
        stringQueue[0]=c;
        currQueue++;
    }

    char popCharacter(){
        char curr = stringStack[0];
        for(int i=0;i<currStack;i++){
            stringStack[i]=stringStack[i+1];
        }
        currStack--;
        return curr;
    }

    char dequeueCharacter(){
        char curr = stringQueue[0];
        for(int i=0;i<currQueue;i++){
            stringQueue[i]=stringQueue[i+1];
        }
        currQueue--;
        return curr;
    }


    public static void main(String[] args) {
	// write your code here

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Main object:
        Main p = new Main();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}
