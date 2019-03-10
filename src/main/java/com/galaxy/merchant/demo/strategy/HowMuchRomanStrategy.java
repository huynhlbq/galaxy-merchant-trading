package com.galaxy.merchant.demo.strategy;

import com.galaxy.merchant.demo.data.GalaxyData;
import com.galaxy.merchant.demo.pattern.GalaxyPattern;
import com.galaxy.merchant.demo.utils.RomanConvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HowMuchRomanStrategy implements Strategy {
    @Override
    public void doAnalyzeSentence(String text) {
        Pattern pattern = Pattern.compile(GalaxyPattern.PATTERN_HOW_MUCH_ROMAN);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String input = matcher.group(1);
            int number = RomanConvert.galaxyToRoman(input);
            String answer = String.format("%s is %s", input, number);
            GalaxyData.getInstance().questionAnswerMap.put(text, answer);
            System.out.println(answer);
        }
    }
}
