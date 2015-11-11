import java.util.Stack;


public class Solution {

	public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        if(path.length() <= 0 || path.substring(0, 1).compareTo("/") != 0)
        	return "";
        int i = 0;
        while(i < path.length()){
        	int end = path.indexOf((int)'/', i);
        	end = end < 0 ? path.length() : end + 1;
        	String name = path.substring(i, end);
        	System.out.println(name);
        	for(i = end; i < path.length() && path.charAt(i) == '/'; i ++);
        	if ((name.compareTo("..") == 0 || name.compareTo("../") == 0) && ! st.isEmpty()){
        		st.pop();
        		if (st.isEmpty())
        			st.push("/");
        	}
        	else{
        		if (name.compareTo(".") == 0 || name.compareTo("./") == 0)
        			;
        		else
        			st.push(name);        			
        	}
        }

        if (st.size() != 1 && st.peek().endsWith("/")){
        	String s = st.pop();
        	System.out.println(s);
        	s = s.substring(0, s.length() - 1);
        	st.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (! st.isEmpty())
        	sb.insert(0, st.pop());
        return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		String path = "/.../";
		System.out.println(obj.simplifyPath(path));
	}

}
