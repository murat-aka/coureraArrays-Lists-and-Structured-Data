import edu.duke.*;
import java.util.ArrayList;

/**
 * a program to determine the characters in one of Shakespeare’s plays that have the most speaking parts. .
 * 
 * @author (Murat Aka) 
 * @version (V 0.0.1 30/10/2016)
 */
public class CharactersInPlay {

        private ArrayList<String> names;
        private ArrayList<Integer> counts;
        
        
        /**
         * 
         * initialises the arraylists to be used.
         */
        public CharactersInPlay(){
            
            names = new ArrayList<String>();
            counts = new ArrayList<Integer>();
            
        }
        
        
        /**
         * updates the character’s name if it is not already there,
         * and counting this line as one speaking part for this person
         *  
         * @param person the input line to be the persons name.
         */
        public void update(String person){
            
            String s = person.toLowerCase().trim();// person.toLowerCase();
            int index = names.indexOf(s);
            if (index == -1){
                names.add(s);
                counts.add(1);
            }
            else {
                int freq = counts.get(index);
                counts.set(index,freq+1);
            }           
            
        }
        
        
        /**
         * opens a file, and reads the file line-by-line.
         * For each line, if there is a period on the line,
         * extract the possible name of the speaking part
         *
         */
        public void findAllCharacters(){
            
            FileResource resource = new FileResource();
            
            for(String s : resource.lines()){  
                
                int index = s.indexOf(".");
                
                if(index == -1) {
                    continue;
                }
                else {
                    
                    String person = s.substring(0, index);
                    update(person);
                }
            }
            
        }
        
        /**
         * finds out if the program works
         *
         */
        public void tester(){
            
            findAllCharacters();
            
                //             for(int k=0; k < names.size(); k++){
                //                 
                //                 System.out.println(names.get(k) + " "+counts.get(k));
                //             }
                
            charactersWithNumParts(2, 1000);
            
        //test: 4932, the, 692, touchstone, 74
        //rosalind
        //ADAM, LE BEAU, AMIENS, AUDREY, WILLIAM
        //adam,le beau, amiens, audrey, william
            
        }
        
        
        /**
         * determine character names from their counts.
         *
         * @param num1 count greater than this number
         * @param num2 count less than this number
         */
        public void charactersWithNumParts( int num1,int num2){
            
            //findAllCharacters();
            
            for(int k=0; k < names.size(); k++){
                
                int n = counts.get(k);
                if(n > num1 && n <num2){
                  System.out.println(names.get(k) + " "+counts.get(k));
                }
            }          
            
        }
}
