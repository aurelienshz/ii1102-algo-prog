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
     * Calcule les paramètres à l'instant suivant :
     */
     public void next() {
         nextV();
         nextPos();
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
