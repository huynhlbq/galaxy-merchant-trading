package com.galaxy.merchant.demo.strategy;

import com.galaxy.merchant.demo.data.GalaxyData;
import com.galaxy.merchant.demo.pattern.GalaxyPattern;
import com.galaxy.merchant.demo.utils.RomanConvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareRomanMaterialStrategy implements Strategy {
    @Override
    public void doAnalyzeSentence(String text) {
        Pattern pattern = Pattern.compile(GalaxyPattern.PATTERN_COMPARE_ROMAN_MATERIAL);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String input1 = matcher.group(1);
            String metal1 = matcher.group(2);
            String input2 = matcher.group(3);
            String metal2 = matcher.group(4);
            int number1 = RomanConvert.galaxyToRoman(input1);
            int number2 = RomanConvert.galaxyToRoman(input2);
            String answer;
            if (number1 * GalaxyData.getInstance().materialMap.get(metal1) <=
                    number2 * GalaxyData.getInstance().materialMap.get(metal2)) {
                answer = String.format("%s %s has less Credits than %s %s",
                        input1, metal1, input2, metal2);
            } else {
                answer = String.format("%s %s has more Credits than %s %s",
                        input1, metal1, input2, metal2);
            }

            GalaxyData.getInstance().questionAnswerMap.put(text, answer);
            System.out.println(answer);
        }
    }
}
