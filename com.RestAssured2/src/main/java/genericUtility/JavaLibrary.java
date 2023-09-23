package genericUtility;

import java.util.Random;

public class JavaLibrary {

	public int getRandomNum() {
		
		Random r= new Random();
		
		int rando=r.nextInt(1000);
		return rando;
	}

}
