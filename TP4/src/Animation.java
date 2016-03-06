public class Animation {
	
	/**
	 * Constructor method : initialise X and Y scales
	 */
	public Animation() {
		int canvasWidth = Config.pxRatio * (int) Math.floor(Config.right - Config.left);
		int canvasHeight = Config.pxRatio * (int) Math.floor(Config.top - Config.bottom);
		StdDraw.setCanvasSize(canvasWidth, canvasHeight);
		StdDraw.setXscale(Config.left-Config.diameter, Config.right+Config.diameter);
		StdDraw.setYscale(Config.bottom-Config.diameter, Config.top+Config.diameter);
	}
	
	/**
	 * Affiche l'image suivante
	 * @param balles : les balles à afficher
	 */
	public void nextFrame(Balle[] balles) {
		StdDraw.clear(StdDraw.WHITE);
    	for(Balle balle : balles) {
    		StdDraw.setPenColor(balle.color);
    		StdDraw.filledCircle(balle.x, balle.y, Config.diameter);
    	}
		StdDraw.show(10);
	}
}
