import java.awt.Color;

public class Balle {
	
	/**
     * Positions, vitesses, accélérations (unités SI)
     */
    public double x;	  // m	
    public double Vx;	  // m/s
    public double Ax;	  // m/s^2
    
    public double y;      // m
    public double Vy;     // m/s
    public double Ay; 	  // m/s^2
    
    public Color color = Config.defaultColor;
	
	public Balle(double x, double y) {
		this.x = x;
		this.y = y;
		this.Vx = 0;
		this.Vy = 0;
		nextA();
	}
	
	public Balle(double x, double y, double Vx, double Vy) {
		this.x = x;
		this.y = y;
		this.Vx = Vx;
		this.Vy = Vy;
		nextA();
	}
	
	public Balle(double x, double y, Color color) {
		this(x,y);
		this.color = color;
	}
	
	public Balle(double x, double y, double Vx, double Vy, Color color) {
		this(x,y,Vx,Vy);
		this.color = color;
	}
	
    /**
     * Pas de temps
     */
    public double t = Config.t;     // s    

    /**
     * Coefficients relatifs aux forces
     * Ils permettent de calculer l'accélération de la balle qqsoit t.
     */
	    // Accélération de la pesanteur :
	    public double g = Config.g; // . e_y (m/s^2)
	    
	    // Coefficient de frottement fluide rapporté à la masse de la balle : 
	    public double k = Config.k; // *v^2 = R (N) (force induite par la résistance de l'air)
    
    /**
     * Calcule les paramètres à l'instant suivant :
     */
     public void next() {
    	 nextA();
         nextV();
         nextPos();
     }

    /**
     * Calcule l'accélération à l'instant suivant :
     */
    private void nextA() {
    	this.Ay = g - k*this.Vy;
    	this.Ax = - k*this.Vx;
    }
     
    /**
     * Calcule la vitesse à l'instant suivant
     */
    private void nextV() {
        this.Vy = this.Vy + (this.Ay*t);
        this.Vx = this.Vx + (this.Ax*t);
    }

    /**
     * Calcule la position à l'instant suivant
     */
    private void nextPos() {
        this.y = this.y + (this.Vy*t);
        this.x = this.x + (this.Vx*t);
    }
}
