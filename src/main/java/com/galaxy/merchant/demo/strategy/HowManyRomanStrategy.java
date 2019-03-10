package com.galaxy.merchant.demo.strategy;

import com.galaxy.merchant.demo.data.GalaxyData;
import com.galaxy.merchant.demo.pattern.GalaxyPattern;
import com.galaxy.merchant.demo.utils.RomanConvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HowManyRomanStrategy implements Strategy {
    @Override
    public void doAnalyzeSentence(String text) {
        Pattern pattern = Pattern.compile(GalaxyPattern.PATTERN_HOW_MANY_ROMAN_MATERIAL);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String input = matcher.group(1);
            String metal = matcher.group(2);
            int number = RomanConvert.galaxyToRoman(input);

            String answer = String.format("%s %s is %s Credits", input, metal,
                    number * GalaxyData.getInstance().materialMap.get(metal));
            GalaxyData.getInstance().questionAnswerMap.put(text, answer);
            System.out.println(answer);
        }
    }
}
