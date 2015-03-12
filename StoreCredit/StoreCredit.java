

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StoreCredit {
	
	public static void main(String[] args) {
		String [] lines = getLines(args[0]);
		
		int n = Integer.valueOf(lines[0]);
		int c = Integer.valueOf(lines[0]);
		int l = 0;
		String p = "";
		
		int y = 1;
		for (int i = 1; i < lines.length; i+=3) {
			c = Integer.valueOf(lines[i]);
			l = Integer.valueOf(lines[i+1]);
			p = lines[i+2];
			
			StringTokenizer t = new StringTokenizer(p);
			int [] prices = new int[l];
			
			for (int j = 0; t.hasMoreElements(); j++) {
				prices[j] = Integer.valueOf(t.nextElement().toString());
			}
			
			int a, b = 0;
			for (int j = 0; j < prices.length; j++) {
				a = prices[j];
				for (int k = 0; k < prices.length; k++) {					
					if(j != k){
						b = prices[k];
						if (a + b == c){
							System.out.println("Case #" + y++ + ": " + (j+1) + " " + (k+1));
							break;
						}
					}
				}
				if (a + b == c)
					break;
			}
		}
		
		
	}
	
	public static String[] getLines(String path){
		List<String> lines = new ArrayList<String>();
		try{
			BufferedReader in = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = in.readLine()) != null){
				lines.add(line);
			}
			in.close();
		}catch(IOException ex){}
		
		return lines.toArray(new String[0]);
	}

}
