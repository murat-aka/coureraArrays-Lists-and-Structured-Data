import edu.duke.*;


/**
 * 
 * Class for implementing the Ceasar Encryption Alghorithm
 * 
 */
public class CaesarCipher {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    
    public CaesarCipher(int key){
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
    }
    
    
    
    /**
     * Method encrypt returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos.
     *
     * @param input -the input message 
     * @return returns the encrypted message.
     */
    public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet

        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            
            Boolean b = Character.isLowerCase(currChar);
            
            if(b)currChar = Character.toUpperCase(currChar); 
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if(b)newChar = Character.toLowerCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    
    
    public String decrypt(String input){
        
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        
        return cc.encrypt(input);
        
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
     * @param key1 encryption key1
     * @param key2 encryption key2
     * @return the encrypted message
     */
    public String encryptTwoKeys(String input, int key1,int key2){
    
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        
        String shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
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

