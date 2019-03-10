package com.galaxy.merchant.demo.strategy;

import com.galaxy.merchant.demo.data.GalaxyData;
import com.galaxy.merchant.demo.pattern.GalaxyPattern;
import com.galaxy.merchant.demo.utils.RomanConvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareRomanNumberStrategy implements Strategy {
    @Override
    public void doAnalyzeSentence(String text) {
        Pattern pattern = Pattern.compile(GalaxyPattern.PATTERN_COMPARE_ROMAN_NUMBER);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String input1 = matcher.group(1);
            String input2 = matcher.group(2);
            int no1 = RomanConvert.galaxyToRoman(input1);
            int no2 = RomanConvert.galaxyToRoman(input2);
            String answer;
            if (no1 <= no2) {
                answer = String.format("%s is smaller than %s", input1, input2);
            } else {
                answer = String.format("%s is larger than %s", input1, input2);
            }
            GalaxyData.getInstance().questionAnswerMap.put(text, answer);
            System.out.println(answer);

        }
    }
}
