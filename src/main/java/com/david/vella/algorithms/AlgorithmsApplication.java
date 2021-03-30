package com.david.vella.algorithms;

import com.david.vella.algorithms.bst.BinarySearchTree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.david.vella.algorithms.ReverseWordsInString.reverseWordsInString;

@SpringBootApplication
public class AlgorithmsApplication {

    public static void main(String[] args) {
        String test = reverseWordsInString("String is a test");
    }

}
