
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {

    
    
    /**
     * This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise
     *
     * @param ch a vowel
     * @return true or false
     */
    public boolean  isVowel(char ch) {
        // put your code here
        
        if (Character.isLetter(ch)){
            
            ch = Character.toLowerCase(ch);
            if(ch=='a' || ch=='e' || ch == 'i' || ch == 'o' || ch == 'u'){
                return true;
            }
            
        
        
        }
        
        return false;
    }
    
    
    /**
     * <em> tester method for isVovel method. </em>
     *
     */
    public void testerIsVowel(){
        
        WordPlay obj1 = new WordPlay();
        Boolean b = obj1.isVowel('F');
        String s = Boolean.toString(b);
        print(s);
        b= obj1.isVowel('a');
        s = Boolean.toString(b);
        print(s);
        
    }
    
    
    
    /**
     * prints out strings to the system
     *
     * @param str input string
     */
    public static void print(String str){
        
        System.out.println(str);
    }
    


}
