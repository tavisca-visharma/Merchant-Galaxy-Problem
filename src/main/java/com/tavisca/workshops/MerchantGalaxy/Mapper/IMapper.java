package com.tavisca.workshops.MerchantGalaxy.Mapper;

public interface IMapper {

    boolean selectMapper(String mapperName);

    void addItemWithCredits(String item, String itemValue);

    String get(String item);
}
