package com.david.vella.algorithms;

/**
 * There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right.
 * Initially, all the bulbs are turned off.
 *
 * At moment k (for k from 0 to n - 1), we turn on the light[k] bulb.
 * A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.
 *
 * Return the number of moments in which all turned on bulbs are blue.
 */
public class LightBulbSwitcher {
    public int numTimesAllBlue(int[] light) {
        int allBlueCount = 0;
        int maxIndexOn = 0;

        for (int i = 0; i < light.length; i++) {
            // A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.
            maxIndexOn = Math.max(maxIndexOn, light[i]);
            if (i + 1 == maxIndexOn) {
                allBlueCount++;
            }
        }

        return allBlueCount;
    }
}
