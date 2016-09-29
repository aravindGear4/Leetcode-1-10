import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class atoi8 {
public static void main(String a[]){
	atoi8 o=new atoi8();/*
	String pattern="", num="+2-2";
	int i1=2147483647;
	System.out.println(i1);*/
	System.out.println(o.atoi("2147483648") == 2147483647 - 1052254545);
	//Integer.parseInt(s);
	//Arrays.
}

int atoi(String s){        s=s.trim();
Pattern r = Pattern.compile("[+-]");
// Now create matcher object.
Matcher m = r.matcher(s);
int c=0;
while (m.find()){c++;}
if(c>1){
	return 0;
}
int sign=1;
if(s.startsWith("-")){
	sign =-1;
	s=s.substring(1);
} else if(s.startsWith("+")){
    s=s.substring(1);
}
int num=0,diff='0';
for(int i=0;i<s.length();i++){
    char c1=s.charAt(i);
    if(!Character.isDigit(c1))
        break;
	num = num*10 + c1-diff;
	System.out.println(num);
}

return num*sign;
}

}
