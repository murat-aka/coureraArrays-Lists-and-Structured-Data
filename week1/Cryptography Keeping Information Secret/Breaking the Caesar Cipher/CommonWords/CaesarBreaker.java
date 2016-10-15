import edu.duke.*;
/**
 *  A program to decrypt a message that was encrypted with two keys.
 * 
 * @author (Murat Aka) 
 * @version (15/10/2016 V0.0.1)
 */
public class CaesarBreaker {

    /**
     * Method decrypt
     *
     * @param encrypted
     * @return decrypted message
     */
    public String decrypt(String encrypted){
        
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        //         for(int k=0; k<freqs.length; k++){
        //             System.out.println(freqs[k]);
        //         } 
        int dkey = maxDex - 4;
        System.out.println(maxDex);
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        
        return cc.encrypt(encrypted, 26-dkey);
    }
    
    
    /**
     * Method testDecrypt
     *
     */
    public void testDecrypt(){
        
        
        String m;
        
        m = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!BBBBBB";//"FIRST LEGION ATTACK EAST FLANK!"
        m = decrypt(m);
        
        System.out.println(m);
        
          //"At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        m = "Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!ttttt";
        m = decrypt(m);
        
        System.out.println(m);
        
    }
    
    
    
    
    /**
     * Method countLetters
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
     * Method maxIndex.
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
     * @param message 
     * @param start index the halving starts
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
        System.out.println(maxDex);
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        
        
        return dkey;
        
    }
}
