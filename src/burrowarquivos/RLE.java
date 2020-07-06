package burrowarquivos;

public class RLE {
	static String encode(String x) {
		String y="";
		char tmp=' ';
		int cont=0;
		for (int i = 0; i < x.length(); i++) {
			tmp=x.charAt(i);
			cont=1;
			if(i==x.length()-1) {
				y+=tmp+Integer.toString(cont);
				break;
			}
			while(x.charAt(i+1)==tmp) {
				cont++;
				if(++i==x.length()-1) {
					break;
				}
			}
			y+=tmp+Integer.toString(cont);
		}
		return y;
	}
	
	static String decode(String y) {
		String x="";
		int tmp;
		for (int i = 0; i < y.length();) {
			char ctmp = y.charAt(i++);
			String nc = "";
			while(i < y.length() && y.charAt(i) >= '0' && y.charAt(i) <= '9') {
				nc += y.charAt(i++);
			}
			tmp=Integer.parseInt(nc);
			while(tmp-- > 0) {
				x+=ctmp;
			}
		}
		return x;
	}
	public static void main(String[] args) {
		String str=encode("teeste");
		System.out.println(str);
		String str1=decode(str);
		System.out.println(str1);
	}
}
