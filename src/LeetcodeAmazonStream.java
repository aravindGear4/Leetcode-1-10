import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LeetcodeAmazonStream {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}

class add<T>{
	T ob;
}
interface Stream {
    char getNext();
    boolean hasNext();
}

class QuestionA {
    public static String firstWord(final Stream input) {
    	//Key - String, word
    	//value - Boolean  indicating whether the word is repeated(or not)
    	LinkedHashMap <String, Boolean>words=new LinkedHashMap<String, Boolean>();
    	//StringBuilder for collecting the word
    	StringBuilder sbr=new StringBuilder();
    	while(input.hasNext()){    		
    		char letter=input.getNext();
    		if(Character.isSpaceChar(letter)){
    			//if its is a space then its a new word    			
    			if(sbr.length()<1){
    				//handling space followed by space
    				continue;
    			}
    			String s=sbr.toString().trim();    			
    			sbr=new StringBuilder();    			
    			Boolean b=words.get(s);
    			if(b==null){
    				//new word
    				words.put(s, false);
    			} else if(b){
    				//its already repeated word
    			} else{
    				//new repeated word
    				words.put(s, true);
    			}
    		} else{
    			//if it is not a space then add to our stringBuilder
    			sbr.append(letter);
    		}
    	}
    	
    	String toReturn=null;
    	//Now go through the linked hashMap and find the first value with false indicating not repeated word
    	for(Entry<String, Boolean> crnt:words.entrySet()){
    		if(crnt.getValue()){
    			toReturn=crnt.getKey();
    		}
    	}
        return toReturn;
    }
}