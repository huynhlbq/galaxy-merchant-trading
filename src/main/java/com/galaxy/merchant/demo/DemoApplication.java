package com.galaxy.merchant.demo;

import com.galaxy.merchant.demo.data.GalaxyData;
import com.galaxy.merchant.demo.pattern.GalaxyPattern;
import com.galaxy.merchant.demo.strategy.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() throws IOException {
        List<String> conversation = new ArrayList<>();
        BufferedReader bufferedReader;
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream("conversation.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            conversation.add(line);
        }
        for (String s : conversation) {
            processConversation(s);
        }
    }

    private static void execute(Strategy strategy, String text) {
        strategy.doAnalyzeSentence(text);
    }

    private void processConversation(String conversation) {
        boolean inputMatches = false;
        String matchedPattern = "";
        for (String sentencePattern : GalaxyPattern.ALL_PATTERN) {
            if (conversation.matches(sentencePattern)) {
                inputMatches = true;
                matchedPattern = sentencePattern;
            }
        }

        if (inputMatches) {
            switch (matchedPattern) {
                case GalaxyPattern.PATTERN_ROMAN_VAR:
                    execute(new RomanDeclareStrategy(), conversation);
                    break;
                case GalaxyPattern.PATTERN_ROMAN_TO_CREDIT:
                    execute(new RomanToCreditStrategy(), conversation);
                    break;
                case GalaxyPattern.PATTERN_HOW_MUCH_ROMAN:
                    execute(new HowMuchRomanStrategy(), conversation);
                    break;
                case GalaxyPattern.PATTERN_HOW_MANY_ROMAN_MATERIAL:
                    execute(new HowManyRomanStrategy(), conversation);
                    break;
                case GalaxyPattern.PATTERN_COMPARE_ROMAN_MATERIAL:
                    execute(new CompareRomanMaterialStrategy(), conversation);
                    break;
                case GalaxyPattern.PATTERN_COMPARE_ROMAN_NUMBER:
                    execute(new CompareRomanNumberStrategy(), conversation);
                    break;
            }
        } else {
            GalaxyData.getInstance().questionAnswerMap.put(conversation, "I have no idea what you are talking about");
            System.out.print(conversation + " => I have no idea what you are talking about");
        }
    }
}
