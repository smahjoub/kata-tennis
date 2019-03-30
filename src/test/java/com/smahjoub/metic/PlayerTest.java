package com.smahjoub.metic;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PlayerTest {

    @Test
    public void testPlayerEquals(){

        Player p1 = new Player(1, "Roger Federer");
        Player p1_1 = new Player(1, "Roger Federer");

        Player p2 = new Player(2, "Pete Sampras");
        Player p2_2 = new Player(2, "Pete Sampras");

        assertTrue(!p1.equals(p2));

        assertTrue(p2_2.equals(p2));
        assertTrue(p1_1.equals(p1));
    }
}
