import edu.duke.*;


/**
 * 
 * Class for implementing the Ceasar Encryption Alghorithm
 * 
 */
public class CaesarCipher {
    
    
    /**
     * Method encrypt returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos.
     * Assume that all the alphabetic characters are uppercase letters. For example, the call
     * encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)
     * should return the string
     * “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
     *
     * @param input -the input message 
     * @param key   the key for encryption.
     * @return returns the encrypted message.
     */
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
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
    
    
    
    /**
     * Method testCaesar
     *
     */
    public void testCaesar() {
        
        String m = encrypt("FIRST LEGION ATTACK EAST FLANK!", 23); // “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
        System.out.println(m);
        
        m = encrypt("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!",26-23); // “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
        System.out.println(m);
        
        
        m = encrypt("First Legion", 23); // “Cfopq Ibdflk”, 
        System.out.println(m);
        m = encrypt("First Legion", 17); // “Wzijk Cvxzfe”
        System.out.println(m);
        
        
        m = encryptTwoKeys("First Legion", 23, 17); // “Czojq Ivdzle”
        System.out.println(m);
        
        
        String n = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        m = encrypt(n,15); // Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!
        System.out.println(m);
        
        m = encryptTwoKeys(n, 8, 21); // Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!
        System.out.println(m);
        
        //         FileResource fr = new FileResource();
        //         String message = fr.asString();
        //         String encrypted = encrypt(message, key);
        //         System.out.println("key is " + key + "\n" + encrypted);
        //                 
        //         int key = 17;
        //         FileResource fr = new FileResource();
        //         String message = fr.asString();
        //         String encrypted = encrypt(message, key);
        //         System.out.println(encrypted);
        //         String decrypted = encrypt(encrypted, 26-key);
        //         System.out.println(decrypted);
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

