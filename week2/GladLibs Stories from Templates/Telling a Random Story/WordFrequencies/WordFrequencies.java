

import edu.duke.*;
import java.util.ArrayList;


/**
 * A program to find out how many times each word occurs in a file and
 * in particular the most frequently occurring word.
 * 
 * @author Murat Aka
 * @version V 0.0.1  29/10/2016
 */
public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    /**
     * WordFrequencies Constructor
     *
     */
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    /**
     * finds unique words in a file and their frequencies.
     */
    public void findUnique(){
        
        //         myWords.clear();
        //         myFreqs.clear();
        FileResource resource = new FileResource();
        
        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
    /**
     * tester method to test if the program works
     *
     */
    public void tester(){
        
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        int index = findMax();
        for(int k=0; k < myFreqs.size(); k++){
            
            System.out.println(myFreqs.get(k) + " "+myWords.get(k));
        }
        
        System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));
    }
    
    
    /**
     * finds the index of the maximum occured word.
     *
     * @return index 
     */
    public int findMax(){
        
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
