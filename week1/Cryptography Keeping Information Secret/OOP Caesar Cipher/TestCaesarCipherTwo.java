import edu.duke.*;

/**
 *  A program to decrypt a message that was encrypted with two keys.
 * 
 * @author (Murat Aka) 
 * @version (16/10/2016 V0.0.1)
 */
public class TestCaesarCipherTwo {

    
    
    /**
     * Method simpleTests
     *
     */
    public void simpleTests(){
        
        
        
        String m;
        

        
        m = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!BBBBBB";//"FIRST LEGION ATTACK EAST FLANK!"
        m = breakCaesarCipherTwo(m);   
        System.out.println(m);
        
        
        // This method should read in a file as a String
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        
        //and decrypt the encrypted String using the decrypt method.
      
        
        m = breakCaesarCipherTwo(message);   
        System.out.println(m);
        
        

        
        
    }
    
     /**
     * returns the occurence of each letter in the encrypted message.
     *
     * @param encrypted message
     * @return array of character counts
     */
    public int[] countLetters(String encrypted){
        
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k<encrypted.length(); k++){
            char ch = Character.toLowerCase(encrypted.charAt(k));
            int dex = alph.indexOf(ch);
            //if(dex != -1 && (dex == 0 || dex == 4 || dex == 8 || dex == 14 || dex == 20) ){
            if(dex != -1){
                counts[dex] = counts[dex]+1;
            }
        }
        
        return counts;
    }
    
    
    /**
     * returns the index of max occured character
     *
     * @param counts array of character counts.
     * @return index of character with highest occurence.
     */
    public int maxIndex(int[] counts){
        
        int max = 0;
        int j = 0;
        
        for(int i=0; i<counts.length; i++){
            
            if(counts[i]>max){
                max=counts[i];
                j = i;
            }
        }
        
        return j;
    }
    
    
    /**
     * return a String that is every other character from message starting with the start position.
     * For example, the call halfOfString(“Qbkm Zgis”, 0) 
     * returns the String “Qk gs” 
     * and the call halfOfString(“Qbkm Zgis”, 1) 
     * returns the String “bmZi”.
     *
     * @param message the encrypted message 
     * @param start the index halving starts at
     * @return halved string
     */
    public String halfOfString(String message, int start){
        
            String half="";
            
            for(int i=start;i<message.length(); i+=2){
                half += message.charAt(i);
            }
            
            return half;
    }
    
    
    /**
     * Method testHalfOfString
     *
     */
    public void testHalfOfString(){
        
        String  m = halfOfString("Qbkm Zgis", 0); //“Qk gs”
        System.out.println(m);
        m = halfOfString("Qbkm Zgis", 1);
        System.out.println(m);//bmZi
    }
    
    
    /**
     * determines the key from the location of the encrypted letter ‘e’, 
     *
     * @param s encrypted message
     * @return key for encryption
     */
    public int getKey(String s){
        
        
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        
        int dkey = maxDex - 4;
        //System.out.println(maxDex);
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        
        
        return dkey;
        
    }
    
    
     /**
     * decrypts an encrypted message using two keys
     *
     * @param encrypted message
     * @return decrypted message
     */
    public String breakCaesarCipherTwo(String encrypted){
         
        //Calculate a String of every other character starting with the first character
        //of the encrypted String by calling halfOfString.
        
        String  m1 = halfOfString(encrypted, 0);

        //Calculate a String of every other character starting 
        //with the second character of the encrypted String.
        
        String  m2 = halfOfString(encrypted, 1);

        //Then calculate the key used to encrypt each half String.
        
        int k1 = getKey(m1);
        int k2 = getKey(m2);

        // print the two keys found.
        
        System.out.println("k1: "+k1 + " k2: " + k2);
        
        

        // Calculate and return the decrypted String using the encryptTwoKeys method 
        CaesarCipherTwo cc = new CaesarCipherTwo(k1, k2);
        
        
        return cc.decryptTwoKeys(encrypted);
    }
}
