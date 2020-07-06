package burrowarquivos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "Tomorrow_and_tomorrow_and_tomorrow_and_tomorrow_and_tomorrow_and_tomorrow_and_tomorrow_and_tomorrow_and_tomorrow_and_tomorrow$";
		
		msg = BurrowWheeler.transformViaSa(msg);
		System.out.println(msg);
		msg = RLE.encode(msg);
		System.out.println(msg);
		msg = RLE.decode(msg);
		System.out.println(msg);
		msg = BurrowWheeler.reverseBWT(msg);
		System.out.println(msg);
	}

}
