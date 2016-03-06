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


    /**
     * Calcule les paramètres à l'instant suivant :
     */
     public void next() {
         nextVy();
         nextY();
     }

    /**
     * Calcule la vitesse à l'instant suivant
     */
    private void nextVy() {
        this.Vy = this.Vy + (this.Ay*t);
    }

    /**
     * Calcule la position à l'instant suivant
     */
    private void nextY() {
        this.y = this.y + (this.Vy*t);
    }
}
