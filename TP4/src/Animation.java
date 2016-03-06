public class Animation {
	public int xMax = 1;
	public double yMax;
	public float width= .03f;
	
	
	
	public Animation (double top) {
		
		this.yMax = top;
		
		StdDraw.setXscale(-width, xMax+width);
		StdDraw.setYscale(-width, yMax+width);
		StdDraw.setPenColor(StdDraw.GREEN);
	}
	
	public void nextFrame(double x, double y) {
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.filledCircle(x, y, width);
		StdDraw.show(10);
	}
}
