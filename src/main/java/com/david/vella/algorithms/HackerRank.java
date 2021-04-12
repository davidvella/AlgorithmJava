package com.david.vella.algorithms;


import java.util.*;

public class HackerRank {
    // Char to check dots
    private static final Character DOT_CHAR = '.';

    public static List<String> typosquats(List<String> companyDomains, List<String> newDomains) {
        // I realised when looking at the other scenarios that I need to change my approach
        Set<String> companySet = new HashSet<>(companyDomains);
        Set<String> domainSet = new HashSet<>(newDomains);
        Set<String> newPossibleDomainsSet = new HashSet<>();

        // for each rule return a set of matching rules and add to new possibleDomains set

        // For each domain check against list of valid domains
        for (String newDomain:
                newDomains) {
            // Check new domain matches company domain. No need to add twice
            for (String companyDomain:
                    companyDomains) {
                // Make sure both domains are not null
                if(companyDomain != null && newDomain != null){

                }
            }
        }
        // All the domains that match
        newPossibleDomainsSet.retainAll(domainSet);
        // Remove duplicate domains from company domain
        newPossibleDomainsSet.removeAll(companySet);
        return new ArrayList<>(newPossibleDomainsSet);
    }

    /**
     * Check same company Name
     */
    public static boolean isWordReplacement(String original, String str2){
        String[] originalArray =  original.split("\\.",2);
        String[] str2Array =  str2.split("\\.",2);
        try{
            String originalCompanyName = originalArray[0];
            String str2Name = str2Array[0];

            String originalCompanyNameDeword = originalCompanyName.replaceAll("[lsoae]", "#");
            String secondCompanyNameDeword = str2Name.replaceAll("[lsoae]", "#");

            return originalCompanyNameDeword.equalsIgnoreCase(secondCompanyNameDeword);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){
            // if not valid
        }
        return false;
    }



    public static void main(String[] args) {
        List<String> companyDomains = Arrays.asList("palantir.com");
        List<String> domains = Arrays.asList("paiantir.com");
        List<String> res = typosquats(companyDomains,domains);
    }
}
