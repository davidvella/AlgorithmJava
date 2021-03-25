package com.david.vella.algorithms;

import java.util.ArrayList;

public class ValidIpAddress {

    public static void main(String[] args){
        ArrayList<String> ipAddress = validIPAddresses("1921680");
    }

    /**
     * You're given a string of length 12 or smaller, containing only digits. Write a
     * function that returns all the possible IP addresses that can be created by
     * inserting three .s in a string.
     * An IP address is a sequence of four positive integers that are separated by .s,
     * where each individual integer is within the range 0 - 255 inclusive.
     *
     * An IP address isn't valid if any of the individual integers contains leading 0s
     *
     * A valid IPV4 is: 192.168.55.1
     */
    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> result = new ArrayList<>();
        int length = string.length();
        // To get a list of ip address we need to check numbers up to 4 parts with most of 255
        // so we cannot have 4 characters
        for (int part1Index = 1; part1Index <= Math.min(4,length); part1Index++){
            String[] ipAddressPart = new String[4];
            String part1 = string.substring(0, part1Index);

            // If not valid part then go to next String
            if(!isValidPart(part1)){
                continue;
            }
            ipAddressPart[0] = part1;

            for (int part2Index = part1Index + 1; part2Index <= Math.min(part1Index +4,length); part2Index++){
                String part2 = string.substring(part1Index, part2Index);

                // If not valid part then go to next String
                if(!isValidPart(part2)){
                    continue;
                }
                ipAddressPart[1] = part2;

                for (int part3Index = part2Index + 1; part3Index <= Math.min(part2Index +4,length); part3Index++){
                    String part3 = string.substring(part2Index, part3Index);

                    // If not valid part then go to next String
                    if(!isValidPart(part3)){
                        continue;
                    }
                    ipAddressPart[2] = part3;


                    for (int part4Index = part3Index + 1; part4Index <= Math.min(part3Index +4,length); part4Index++){
                        if(part4Index != length){
                            continue;
                        }

                        String part4 = string.substring(part3Index, length);
                        // If not valid part then go to next String
                        if(!isValidPart(part4)){
                            continue;
                        }
                        ipAddressPart[3] = part4;
                        result.add(String.join(".", ipAddressPart));
                    }
                }
            }
        }
        return result;
    }

    static boolean isValidPart(String part){
        Integer intPart = Integer.parseInt(part);
        if(intPart > 255){
            return false;
        }
        return part.length() == intPart.toString().length();
    }


}
