
/**
 * a program to transform words from a file into another form, such as replacing vowels with an asterix..
 * 
 * @author (Murat Aka) 
 * @version (09/10/2016 Version 0.0.1)
 */
public class WordPlay {

    
    
    /**
     * Method replaceVowels replaces all the vowels (uppercase or lowercase) with a character.
     *
     * @param phrase string to be replaced
     * @param ch character to replace with
     * @return replaced string
     */
    public String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
      
        for(int i=0;i<phrase.length();i++){
            char c = phrase.charAt(i);
            
            WordPlay obj1 = new WordPlay();
            
            Boolean b = obj1.isVowel(c);
            if(b){

                sb.setCharAt(i, '*');
            }
        }
        
        return sb.toString();
    }
    
    
    /**
     * Method testReplaceVowels tests if replaceVovels method works
     *
     */
    public void testReplaceVowels(){
        
        String s = "Hello World";
        print(s);
        WordPlay obj1 = new WordPlay();
        s = obj1.replaceVowels(s, '*');
        print(s);
    }
    
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
