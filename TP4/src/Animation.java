public class Animation {
	public int xMax = 1;
	public double yMax;
	public float width= .03f;
	
	
	
	public Animation (double top) {
		
		this.yMax = top;
		
		StdDraw.setXscale(-width, xMax+width);
		StdDraw.setYscale(-width, yMax+width);
		StdDraw.setPenColor(StdDraw.RED);
	}
	
	public void nextFrame(double y) {
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.filledCircle(.5, y, width);
		StdDraw.show(10);
	}
}
