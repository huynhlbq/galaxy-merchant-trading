package com.galaxy.merchant.demo.pattern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GalaxyPattern {
    public static final String PATTERN_ROMAN_VAR = "(\\S+) is ([I|V|X|L|C|D|M])";
    public static final String PATTERN_ROMAN_TO_CREDIT = "([a-zA-Z0-9_ ]*) (Silver|Gold|Iron) is (\\d+) Credits";
    public static final String PATTERN_HOW_MUCH_ROMAN = "how much is ([a-zA-Z0-9_ ]*) \\?";
    public static final String PATTERN_HOW_MANY_ROMAN_MATERIAL = "how many Credits is ([a-zA-Z0-9_ ]*)(Silver|Gold|Iron) \\?";
    public static final String PATTERN_COMPARE_ROMAN_MATERIAL = "Does ([a-zA-Z0-9_ ]*) (Silver|Gold|Iron) has more Credits than ([a-zA-Z0-9_ ]*) (Silver|Gold|Iron) \\?";
    public static final String PATTERN_COMPARE_ROMAN_NUMBER = "Is ([a-zA-Z0-9_ ]*) larger than ([a-zA-Z0-9_ ]*) \\?";

    public static final Set<String> ALL_PATTERN = new HashSet<>(Arrays.asList(
            PATTERN_ROMAN_VAR, PATTERN_ROMAN_TO_CREDIT, PATTERN_HOW_MUCH_ROMAN, PATTERN_HOW_MANY_ROMAN_MATERIAL,
            PATTERN_COMPARE_ROMAN_MATERIAL, PATTERN_COMPARE_ROMAN_NUMBER));
}
