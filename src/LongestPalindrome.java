
public class LongestPalindrome {
public static void main(String s[]){
	//System.out.println(lpMid("esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq"));
	System.out.println(lpMid("bba"));
}
static String lpMid(String s){
	String dummyChar="_";
	s=s.replaceAll(".", "$0"+dummyChar);
	for(int i=0;i<s.length();i++){System.out.println(i+":"+s.charAt(i));}
	System.out.println(s);
	int index=0,len=0;
	for(int i=0;i<s.length();i++){
		int t=expandMid(s, i);
		if(t>len){
			System.out.println(i+":"+t);
			len = t;
			index = i;
		}
	}
	String s1=s.substring(index-len, index+len+1);
	System.out.println("hi:"+s1);
	System.out.println(s1.replaceAll(dummyChar, ""));
	return s1.replaceAll(dummyChar, "");
	
}

static int expandMid(String s, int index){
	int i=index,j=index,t=-1;
	while(i>-1 && j< s.length() && s.charAt(i) == s.charAt(j)){
		i--;j++;t++;
	}
	return t;
}

static String longest(String s){
	String r=(new StringBuffer(s)).reverse().toString();
	int len=0, x=0,y;
	int tb[][]=new int[r.length()+1][r.length()+1];
	System.out.println("hiii");

	//table formation
	for(int i=1;i<=s.length();i++){
		for(int j=1;j<=r.length();j++){
			if(s.charAt(i-1) == r.charAt(j-1)){							
				tb[i][j]=tb[i-1][j-1]+1;
				
				//if(tb[i][j] > len && isPanlindrome(s.substring(i-tb[i][j],i))){
				if(tb[i][j] > len && (tb[i][j] == 1 || i+j-tb[i][j] == s.length())){
					len = tb[i][j];
					x=i;
					System.out.println(i+","+j+":"+tb[i][j]);
					System.out.println("Found");
				}
			}
		}
	}
	return s.substring(x-len, x);
			
}

static boolean isPanlindrome(String s1){	
	String s2=(new StringBuffer(s1)).reverse().toString();
	if(s1.equals(s2))
		return true;
	return false;
}


}
