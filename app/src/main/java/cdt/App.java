package cdt;
import java.io.*;
import java.util.*;


public class App{
	public static void main(String[] args) {
		try {
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
		}		
		catch (UnsupportedEncodingException e) {
			throw new InternalError("VM does not support mandatory encoding UTF-8");
		}
		LinkedList<String[]> list = new LinkedList<String[]>();
		String line;
		String[] array;
		try {
			File file = new File ("./src/main/java/cdt/prospects.txt");
			Scanner reader = new Scanner(file, "UTF-8");
			reader.nextLine();
			while(reader.hasNextLine()) {
				line = reader.nextLine();
				array = line.replace("\"","").split(",(?=[0-9])");
				if(array.length == 4) {
					list.add(array);
				}
			}
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File 'prospects.txt' missing from src folder");
		}
		for(String[] i: list) {
			for(String j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		Hashtable<String, double[]> dict = new Hashtable<String, double[]>();
		for(String[] row: list) {
			dict.put(row[0], new double[]{Double.parseDouble(row[1]), Double.parseDouble(row[2]), Double.parseDouble(row[3])});
		}
		double b;
		double U;
		int p;
		double[] values;
		String customer;
		for(Map.Entry<String, double[]> entry: dict.entrySet()){
			values = entry.getValue();
			customer = entry.getKey();
			b = values[1]/100/12;
			U = values[0];
			p = 12*(int)values[2];
			System.out.println("Monthly payment for "+customer +": "+round(monthlyPayment(b, U, p), 2));
		}
	}
	public static double potency(double x, int y){
		double product = 1;
		for(int i = 0; i < y; i++){
			product *= x;
		}
		return product;
	}
	public static double round(double i, int decimals){
		i *= potency(10, decimals);
		i += 0.5;
		int integer = (int)i;
		i = integer/potency(10, decimals);
		return i;
	}
	public static double monthlyPayment(double b, double U, int p){
		return (U*b*potency(1 + b, p))/(potency(1 + b, p) - 1);
	}
}