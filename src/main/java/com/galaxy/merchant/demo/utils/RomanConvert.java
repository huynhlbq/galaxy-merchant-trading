package com.galaxy.merchant.demo.utils;

import com.galaxy.merchant.demo.data.GalaxyData;

public class RomanConvert {

    public static int galaxyToRoman(String input) {
        for (String key : GalaxyData.getInstance().romanMap.keySet()) {
            input = input.replaceAll(key, GalaxyData.getInstance().romanMap.get(key));
        }
        input = input.replaceAll(" ", "");
        int num = 0;
        int previousNum = 0;
        int result = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            char romanChar = input.charAt(i);
            romanChar = Character.toUpperCase(romanChar);
            switch (romanChar) {
                case 'I':
                    previousNum = num;
                    num = 1;
                    break;
                case 'V':
                    previousNum = num;
                    num = 5;
                    break;
                case 'X':
                    previousNum = num;
                    num = 10;
                    break;
                case 'L':
                    previousNum = num;
                    num = 50;
                    break;
                case 'C':
                    previousNum = num;
                    num = 100;
                    break;
                case 'D':
                    previousNum = num;
                    num = 500;
                    break;
                case 'M':
                    previousNum = num;
                    num = 1000;
                    break;
            }
            if (num < previousNum) {
                result = result - num;
            } else
                result = result + num;
        }
        return result;
    }

}
