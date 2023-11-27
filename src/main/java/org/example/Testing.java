package org.example;

import org.apache.commons.lang.RandomStringUtils;

public class Testing {
    public static void main(String[] args) {


    }
    public String test()
    {
        String generatedRandomString = RandomStringUtils.randomAlphabetic(36);
        System.out.println("random string is :" + generatedRandomString);
        return generatedRandomString;
    }




}
