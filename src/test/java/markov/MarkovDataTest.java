package markov;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkovDataTest {
	
    /**
     * Test of read method, of class MarkovData.
     * WHEN read("C'est un test")
     * THEN markovData.getKeyWord(0) = "C'est"
     * THEN markovData.getKeyWord(1) = "un"
     * THEN markovData.getKeyWord(2) = "test"
     */
    @Test
    public void testRead() {
        System.out.println("read");
        String text = "C'est un test";
        MarkovData markovData = new MarkovData();
        markovData.read(text);
        assertEquals(markovData.keyWordSize(), 3);
        assertEquals(markovData.getKeyWord(0), "C'est");
        assertEquals(markovData.getKeyWord(1), "un");
        assertEquals(markovData.getKeyWord(2), "test");
    }
    
    /**
     * Test of renforceWord method, of class MarkovData.
     * WHEN renforceWord("test", "non");
     * THEN markovData.getLearnedWord("test") = ... + " non"
     */
    @Test
    public void testRenforceWord() {
        System.out.println("renforceWord");
        MarkovData markovData = new MarkovData();
        markovData.learnWord("test", "oui");
        markovData.renforceWord("test", "non");
        assertEquals(markovData.getLearnedWord("test"), "oui non");
    }

    /**
     * Test of renforceWord method, of class MarkovData.
     * WHEN renforceWord("test", "oui");
     * THEN markovData.renforceWord("test", "oui") = false
     */
    @Test
    public void testRenforceWord_CleNonPresente() {
        System.out.println("renforceWord");
        MarkovData markovData = new MarkovData();
        markovData.renforceWord("test", "oui");
        assertEquals(markovData.renforceWord("test", "oui"), false);
    }
    
    /**
     * Test of renforceWord method, of class MarkovData.
     * WHEN renforceWord("test", "oui");
     * THEN markovData.renforceWord("test", "oui") = true
     */
    @Test
    public void testRenforceWord_ClePresente() {
        System.out.println("renforceWord");
        MarkovData markovData = new MarkovData();
        markovData.learnWord("test", "oui");
        markovData.renforceWord("test", "oui");
        assertEquals(markovData.renforceWord("test", "oui"), true);
    }

}
