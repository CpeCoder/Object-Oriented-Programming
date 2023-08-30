public class TestLine{
	public static void main(String[] args){
		Line line1 = new Line(9.264, 8.626, 9.070, 3.194, Color.Cyan);
		double length1 = line1.length();
	/*	Line line2 = new Line(5.670, 0.307, 4.001, 8.057, Color++);
		double length2 = line2.length();
		Line line3 = new Line(9.360, 6.226, 4.605, 4.110, Color++);
		double length3 = line3.length();
		Line line4 = new Line(0.752, 9.955, 5.561, 9.962, Color);
		double length4 = line4.length();
*/
		System.out.println(line1 + " " + length1);
	}
}
