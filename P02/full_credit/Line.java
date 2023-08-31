public class Line{
	private double x1, y1, x2, y2;
	private Color color;

	public Line(double x1, double y1, double x2, double y2, Color color)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public double length(){
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}


	@Override
	public String toString(){
		return ((String.format("%8s", color)) + " (" + (String.format("%.3f",x1)) + "," + String.format("%.3f",y1)
				+ ")" + " - (" + String.format("%.3f",x2) + "," + String.format("%.3f",y2) + ") has length" ) ;   
	}
}
