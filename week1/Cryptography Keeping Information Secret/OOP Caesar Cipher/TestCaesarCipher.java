import edu.duke.*;

/**
 *  A program to decrypt a message that was encrypted.
 * 
 * @author (Murat Aka) 
 * @version (16/10/2016 V0.0.1)
 */
public class TestCaesarCipher {

  
    /**
     * Method simpleTests
     *
     */
    public void simpleTests(){
        
//         // This method should read in a file as a String
//         FileResource fr = new FileResource();
//         String message = fr.asString();
//         
//         // create a CaesarCipher object with key 18,
//         CaesarCipher cc = new CaesarCipher(18);
//         
//         //encrypt the String read in using the CaesarCipher object,
//         String m = cc.encrypt(message);
//         
//         //print the encrypted String,
//         System.out.println(m);
//         
//         
//         //and decrypt the encrypted String using the decrypt method.
//         m = cc.decrypt(message);
//         System.out.println(m);
//         
//         
//         m = breakCaesarCipher(message);   
//         System.out.println(m);


//         String m = "Can you imagine life WITHOUT the internet AND computers in your pocket?"; 
//  
//         CaesarCipherTwo cc = new CaesarCipherTwo(21,8); //Xii twp duvodvz gqam EDBCWPB bcm qibzzimo VVY xwhxpbzzn dv gjcm kwxszb?
//         m = cc.encryptTwoKeys(m);
//         System.out.println(m);



        String m = "Hfs cpwewloj loks cd Hoto kyg Cyy."; 
 
        CaesarCipherTwo cc = new CaesarCipherTwo(14,24); //The original name of Java was Oak.
        m = cc.decryptTwoKeys(m);
        System.out.println(m);
        
        
        
        
//         CaesarCipher cc = new CaesarCipher(15); //Rpc ndj xbpvxct axut LXIWDJI iwt xcitgcti PCS rdbejitgh xc ndjg edrzti?
//         m = cc.encrypt(m);
//         System.out.println(m);
        
        
        
        
    }
  
    
    
    
    
    /**
     * counts the occurances of each alphabet character in an encrypted message
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
     * returns the index of highest occuring letter
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
     * decrypts an encrypted message
     *
     * @param encrypted message
     * @return decrypted message
     */
    public String breakCaesarCipher(String encrypted){
        
        
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
        
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(encrypted);
    }
    
    

}
