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
    
    
    /**
     * CaesarCipher Constructor
     *
     * @param key encryption key
     */
    public CaesarCipher(int key){
        
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        
        mainKey = key;
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
            //System.out.println(alphabet);
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
    
    
    
    /**
     * Method decrypt returns a String that has been decrypted using the Caesar Cipher algorithm explained in the videos
     *
     * @param input the encrypted message
     * @return the decrypted message.
     */
    public String decrypt(String input){
        
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        
        return cc.encrypt(input);
        
    }
    
    
    

}
    
 
    


