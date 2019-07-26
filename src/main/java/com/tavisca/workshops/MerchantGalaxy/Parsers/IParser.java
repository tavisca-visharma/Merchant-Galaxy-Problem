package com.tavisca.workshops.MerchantGalaxy.Parsers;

public interface IParser {

    boolean select(String parserName);

    Object[] Parse(String language);

}
