package com.tavisca.workshops.MerchantGalaxy.Mapper;

import java.util.HashMap;

public class MetalToCreditsMapper implements IMapper {
    private static HashMap<String,String> metalToCredits;

    public MetalToCreditsMapper(){
        metalToCredits = new HashMap<>();
    }

    public boolean selectMapper(String mapperName) {
        return mapperName.equalsIgnoreCase(MappersName.metalMapperName);
    }

    public void addItemWithCredits(String metal, String metalCredits){

        metalToCredits.put(metal,metalCredits);

    }

    public String get(String metal){
        return metalToCredits.get(metal);
    }

}
