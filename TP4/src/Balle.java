public class Balle {

    /**
     * Pas de temps
     */
    public double t = 0.01;     // s

    /**
     * Position, vitesse, accélération (unités SI)
     */
    public double y = 1;      // m
    public double Vy = 0;     // m/s
    public double Ay = -9.81; // m/s^2
    
    public double x = 0;
    public double Vx = 1;
    public double Ax = 0;

    /**
     * Coefficients relatifs aux forces
     * permettent de calculer l'accélération de la balle
     */
    // Accélération de la pesanteur :
    public double g = -9.81; // . e_y (m/s^2)
    // Coefficient de frottement fluide rapporté à la masse de la balle :
    // 0.05 semble être une bonne valeur : la hauteur des rebonds se stabilise alors autour de 0.7 pour une balle "parfaite" (ie e = 1) 
    public double k = 0.05; // *v^2 = R (N) (force induite par la résistance de l'air)
    
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
