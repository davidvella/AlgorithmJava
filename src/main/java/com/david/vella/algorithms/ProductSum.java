package com.david.vella.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.

    /**
     * O(n) time | O(d) space - where n is the total number of elements in the array, including sub-elements,
     * and d is the greatest depth of "special" arrays in the array
     */
    public static int productSum(List<Object> array) {

        // Write your code here.
        return productSumHelper(array, 1);
    }

    public static int productSumHelper(List<Object> array, int multiplier){
        int sum = 0;
        for (Object element:
                array) {
            if(element instanceof ArrayList){
                sum += productSumHelper((ArrayList)element, multiplier + 1);
            }
            else if (element instanceof Integer){
                sum += (int) element;
            }
        }
        return sum * multiplier;
    }

}
