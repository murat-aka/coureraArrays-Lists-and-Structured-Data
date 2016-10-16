import edu.duke.*;
/**
 *  A program to decrypt a message that was encrypted with two keys.
 * 
 * @author (Murat Aka) 
 * @version (16/10/2016 V0.0.1)
 */
public class CaesarCipherTwo {

    private String alphabet, shiftedAlphabet1, shiftedAlphabet2;
    private int mainKey1, mainKey2;
    

    
    /**
     * CaesarCipherTwo Constructor
     *
     * @param key1 encryption key1
     * @param key2 encryption key2
     */
    public CaesarCipherTwo(int key1, int key2){
        
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        
        shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        
        shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        
        mainKey1 = key1; 
        mainKey2 = key2;
        
    }
    
    
    
    
    /**
     * Method testDecrypt
     *
     */
    public void testDecrypt(){
        
        

        FileResource resource = new FileResource();
        
        String m = decryptTwoKeys(resource.asString());
        
        System.out.println(m);
        
    }
    
    
    
    
   
    
    
    /**
     * returns the decrypted String with two keys.
     *
     * @param encrypted message
     * @return decrypted message
     */
    public String decryptTwoKeys(String encrypted){
        

        // Calculate and return the decrypted String using the encryptTwoKeys method 
        CaesarCipherTwo cc = new CaesarCipherTwo(26-mainKey1, 26-mainKey2);
              
        return cc.encryptTwoKeys(encrypted);

    }
    
    
    
    /**
     * Method encryptTwoKeys returns a String that has been encrypted using the following algorithm.
     * Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, 
     * starting with the first character, and key2 is used to encrypt every other character,
     * starting with the second character. 
     * For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. 
     * Note the ‘F’ is encrypted with key 23,
     * the first ‘i’ with 17, the ‘r’ with 23,
     * and the ‘s’ with 17, etc.
     *
     * @param input the message
     * @return the encrypted message
     */
    public String encryptTwoKeys(String input){
    
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet

        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i+=2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            
            Boolean b = Character.isLowerCase(currChar);
            
            if(b)currChar = Character.toUpperCase(currChar); 
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet1.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if(b)newChar = Character.toLowerCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        
        
        for(int i = 1; i < encrypted.length(); i+=2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            
            Boolean b = Character.isLowerCase(currChar);
            
            if(b)currChar = Character.toUpperCase(currChar); 
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet2.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if(b)newChar = Character.toLowerCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
}
