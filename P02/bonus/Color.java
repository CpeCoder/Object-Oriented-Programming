public enum Color {
	Coral(0xFF7F50) , Cyan(0x00FFFF), Feldgrau(0x4D5D53), Rose(0xFF007F);

	private int rgb;

	private Color(int rgb)
	{
		this.rgb = rgb;
	}

	@Override
	public String toString(){
		return String.format("%8s", name()) + " (" + String.format("0x%06x", rgb) + ")";
	}
}
