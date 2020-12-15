package app;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import markov.MarkovChain;

/**
 * MarkovApp est la classe représentant l'application Chaine de Markov.
 * 
 * @author Pierre-Nicolas
 */
public class MarkovApp {
	
	public static void main(String[] args) throws Exception {
        String sentences = readFileAsString("./target/VictorHugo_LesMiserables-II-Cosette.txt");
        System.out.println(sentences);
        
        MarkovChain markov = new MarkovChain(3);
        markov.learn(sentences);
        
        System.out.println("Generation :\n");
        System.out.println(markov.generateMarkov(6));
        System.out.println(markov.generateMarkov(9));
        System.out.println(markov.generateMarkov(12));
	}

    public static String readFileAsString(String fileName) throws Exception { 
        String data = ""; 
        Path path = Paths.get(fileName); 
        //data = Files.readString(path, StandardCharsets.UTF_8);
        data = new String(Files.readAllBytes(path)); 
        return data; 
    } 
    
}
