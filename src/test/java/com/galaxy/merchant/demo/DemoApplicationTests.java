package com.galaxy.merchant.demo;

import com.galaxy.merchant.demo.data.GalaxyData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testMetalListSize() {
        assertEquals(3, GalaxyData.getInstance().materialMap.size());
    }

    @Test
    public void testRomanListSize() {
        assertEquals(4, GalaxyData.getInstance().romanMap.size());
    }

    @Test
    public void testAnswerMap() {
        assertEquals(7, GalaxyData.getInstance().questionAnswerMap.size());
    }

    @Test
    public void testHowMuchQuestion() {
        assertEquals("pish tegj glob glob is 42", GalaxyData.getInstance().questionAnswerMap.get("how much is pish tegj glob glob ?"));
    }

    @Test
    public void testHowManyQuestion() {
        assertEquals("glob prok  Silver is 68.0 Credits", GalaxyData.getInstance().questionAnswerMap.get("how many Credits is glob prok Silver ?"));
    }

    @Test
    public void testAnswersContainUnknownQuestion() {
        assert (GalaxyData.getInstance().questionAnswerMap.get("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?").contains("I have no idea what you are talking about"));
    }

}
