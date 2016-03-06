public class Animation {
	public int xMax = 1;
	public double yMax;
	public float width = Config.width;
	
	
	
	public Animation (double top) {
		
		this.yMax = top;
		
		StdDraw.setXscale(-width, xMax+width);
		StdDraw.setYscale(-width, yMax+width);
	}
	
	public void nextFrame(Balle[] balles) {
		StdDraw.clear(StdDraw.WHITE);
    	for(Balle balle : balles) {
    		StdDraw.setPenColor(balle.color);
    		StdDraw.filledCircle(balle.x, balle.y, width);
    	}
		StdDraw.show(10);
	}
}
