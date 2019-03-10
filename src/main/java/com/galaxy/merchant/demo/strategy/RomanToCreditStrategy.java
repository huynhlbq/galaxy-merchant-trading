package com.galaxy.merchant.demo.strategy;

import com.galaxy.merchant.demo.data.GalaxyData;
import com.galaxy.merchant.demo.pattern.GalaxyPattern;
import com.galaxy.merchant.demo.utils.RomanConvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanToCreditStrategy implements Strategy {
    @Override
    public void doAnalyzeSentence(String text) {
        Pattern pattern = Pattern.compile(GalaxyPattern.PATTERN_ROMAN_TO_CREDIT);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String input = matcher.group(1);
            String metal = matcher.group(2);
            Double credit = Double.valueOf(matcher.group(3));
            int amountOfMaterial = RomanConvert.galaxyToRoman(input);
            GalaxyData.getInstance().materialMap.put(metal, credit / amountOfMaterial);
        }
    }
}
