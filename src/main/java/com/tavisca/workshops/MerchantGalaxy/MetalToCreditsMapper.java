package com.tavisca.workshops.MerchantGalaxy;

import java.util.HashMap;

public class MetalToCreditsMapper {
    private static HashMap<String,Double> metalToCredits = new HashMap<>();

    public static void addMetalWithCredits(String metal, double credits){

        metalToCredits.put(metal,credits);

    }

    public static double getMetalCredits(String metal){
//        System.out.println("metal = " + metal + " credits = " + metalToCredits.get(metal));
        return metalToCredits.get(metal);
    }

}
