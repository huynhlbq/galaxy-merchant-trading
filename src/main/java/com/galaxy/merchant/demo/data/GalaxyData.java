package com.galaxy.merchant.demo.data;

import java.util.HashMap;
import java.util.Map;

public class GalaxyData {
    private static GalaxyData INSTANCE;

    public static GalaxyData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GalaxyData();
        }
        return INSTANCE;
    }

    public Map<String, String> romanMap = new HashMap<>();
    public Map<String, Double> materialMap = new HashMap<>();
    public Map<String, String> questionAnswerMap = new HashMap<>();
}
