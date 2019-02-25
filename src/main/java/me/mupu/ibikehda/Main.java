package me.mupu.ibikehda;

import lombok.Getter;
import lombok.val;
import lombok.var;

public class Main {


    public static void main(String[] args) {
        val testPW = "test1234";
        val encoder = new HashPasswordEncoder();
        val hashedPW = encoder.encode(testPW);
        System.out.println(testPW);
        System.out.println(hashedPW);
        System.out.println(encoder.matches(testPW, hashedPW));
    }
}
