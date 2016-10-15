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
        System.out.println(maxDex);
        int dkey = maxDex - 4;
        
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
        
        m = "CFOPQ IBDFLK XQQXZH BXPQ CIXKH!bbbb";//"FIRST LEGION ATTACK EAST FLANK!"
        m = decrypt(m);
        
        System.out.println(m);
        
          //"At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        m = "Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!";
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
        
        for(int i=0; i<counts.length; i++){
            
            if(counts[i]>max)max=counts[i];
        }
        
        return max;
    }
    
    
    
    
    
    
    
    
    
}
