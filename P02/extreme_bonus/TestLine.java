public class TestLine{
	
	public static final String Coral = "\u001B[38;2;255;127;80m";
    	public static final String Cyan = "\u001B[38;2;0;255;255m";
    	public static final String Feldgrau = "\u001B[38;2;77;93;83m";
    	public static final String Rose = "\u001B[38;5;197m";
	public static final String RESET = "\u001B[0m";

	public static void main(String[] args){
		Line line1 = new Line(9.264, 8.626, 9.070, 3.194, Color.Coral);
		double length1 = line1.length();
		Line line2 = new Line(5.670, 0.307, 4.001, 8.057, Color.Cyan);
		double length2 = line2.length();
		Line line3 = new Line(9.360, 6.226, 4.605, 4.110, Color.Feldgrau);
		double length3 = line3.length();
		Line line4 = new Line(0.752, 9.955, 5.561, 9.962, Color.Rose);
		double length4 = line4.length();

		System.out.println(line1 + " " + Coral + length1 + RESET);
		System.out.println(line2 + " " + Cyan + length2 + RESET);
		System.out.println(line3 + " " + Feldgrau + length3 + RESET);
		System.out.println(line4 + " " + Rose + length4 + RESET);
	}
}
