import edu.duke.*;

/**
 * a program to figure out the length of words from a file
 * 
 * @author (Murat Aka) 
 * @version (15/10/2016 V0.0.1)
 */
public class WordLengths {
    

    /**
     * This method read in the words from resource and count the number of words 
     * of each length for all the words in resource, storing these counts in the array counts.
     *
     * @param resource file resource.
     * @param counts array of words with index as the word length. 
     * @return counts array after counting.
     */
    public int[] countWordLength( FileResource resource,int[] counts){
        
       for(String word : resource.words()){
			
           
			int n = word.length();
			//System.out.println(n);
			char first = word.charAt(0);
			char last = word.charAt(n-1);
			//System.out.println(word);
			Boolean b = Character.isLetter(first);
			if(b){
			 }else{
			     
			     word = word.substring(1, n);
			     n = word.length();
			 }
			//System.out.println(word);
			b = Character.isLetter(last);
			
			if(b){
			 }else{
			     word = word.substring(0,n-1);
			     n = word.length();
			 }
			//System.out.println(word);
			
			if(n>30){
			    counts[30] = counts[30] += 1;
			 }else{
			     counts[n] = counts[n] += 1;
			 }
		}
		
		return counts;
    }
    
    
    /**
     * Method testCountWordLengths
     *
     */
    public void testCountWordLengths(){
        
        FileResource resource = new FileResource();
        
        int[] counts = new int[30];
        
        counts = countWordLength(resource,counts);
        
        for(int k=0; k < counts.length; k++){

			System.out.println( counts[k] + " words of length " +k );
		}
		
		int m = indexOfMax(counts);
		
		System.out.println("max occurence: " + m);
    }
    
    /**
     * determine the most common word length in the file.
     *
     * @param values array of counts
     * @return index of array with max count.
     */
    public int indexOfMax(int[] values){
    
        int max =0;
        int j = 0;
        for(int k=0; k < values.length; k++){

			if(values[k]>max){
			    
			    max=values[k];
			    j=k;
			}
		}
        
		return j;
    }
   
}
