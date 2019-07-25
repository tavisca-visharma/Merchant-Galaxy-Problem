package com.tavisca.workshops.MerchantGalaxy.Mapper;

import java.util.ArrayList;
import java.util.List;

//Singleton Class

public class Mapper {
    private List<IMapper> mappers;
    private static Mapper mapper = null;

    private Mapper() {
        mappers = new ArrayList<>();
        mappers.add(new MetalToCreditsMapper());
        mappers.add(new WordToRomanNumeralMapper());
        mappers.add(new RomanNumeralToCreditMapper());
    }

    public static Mapper getInstance(){
        if(mapper == null)
            mapper = new Mapper();
        return mapper;
    }

    private IMapper getMapper(String mapperName) {
        for (int i = 0; i < mappers.size(); i++) {
            if (mappers.get(i).selectMapper(mapperName) == true)
                return mappers.get(i);
        }
        return null;
    }

    public void addItem(String mapperName, String item, String credits) {
        IMapper mapper = getMapper(mapperName);
        mapper.addItemWithCredits(item, credits);
    }

    public String getItemValue(String mapperName,String item){
        IMapper mapper = getMapper(mapperName);
        return mapper.get(item);
    }

}
