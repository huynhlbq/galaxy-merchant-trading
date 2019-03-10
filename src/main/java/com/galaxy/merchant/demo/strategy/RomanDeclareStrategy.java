package com.galaxy.merchant.demo.strategy;

import com.galaxy.merchant.demo.data.GalaxyData;
import com.galaxy.merchant.demo.pattern.GalaxyPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanDeclareStrategy implements Strategy {

    @Override
    public void doAnalyzeSentence(String text) {
        Pattern pattern = Pattern.compile(GalaxyPattern.PATTERN_ROMAN_VAR);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String input = matcher.group(1);
            String roman = matcher.group(2);
            GalaxyData.getInstance().romanMap.put(input, roman);
        }
    }
}
