package markov;

import java.util.Random;
import static org.junit.Assert.*;

import org.junit.Test;

import markov.MarkovChain;

public class MarkovChainTest {

    /**
     * Test of learn method, of class MarkovChain.
     * WHEN learn("test test a b");
     * THEN markovChain.generateMarkov(1) = "test"
     */
    @Test
    public void testLearn() {
        System.out.println("learn");
        MarkovChain markovChain = new MarkovChain(1);
        markovChain.learn("test test a b");
        //System.out.println(markovChain.getData().getLearnedWord("test"));
        assertEquals(markovChain.getData().getLearnedWord("test"), "test a");
    }

    /**
     * Test of generateMarkov method, of class MarkovChain.
     * WHEN learn("test test")
     * THEN markovChain.generateMarkov(1) = "test"
     */
    @Test
    public void testGenerateMarkov() {
        System.out.println("generateMarkov");
        int numWords = 1;
        MarkovChain markovChain = new MarkovChain(numWords);
        markovChain.learn("test test");
        //System.out.println(markovChain.generateMarkov(1));
        //System.out.println(markovChain.generateMarkov(1));
        assertEquals(markovChain.generateMarkov(1), markovChain.generateMarkov(1));
    }

}
