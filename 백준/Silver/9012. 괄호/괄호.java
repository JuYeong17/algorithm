import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack=new Stack<>();
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String num=br.readLine();
			for(int j=0;j<num.length();j++) {
				char bra=num.charAt(j);
				if(bra == '(') {
					stack.push(bra);
				}
				else if(stack.empty()) {
					stack.push(')');
					break;
				}
				else {
					stack.pop();
				}
			}
			
			if(stack.empty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			stack.clear();
			}
		}
	}