public class Space {

    /**
     * Limites géopgraphique de l'espace :
     * le point origine est toujours situé en bas à gauche
     */
    public double top = 1;
    public double bottom = 0;
    public double left = 0;
    public double right = 1;
    
    /**
     * e : coefficient de restitution des rebonds :
     */
    public double e = 1;

    /**
     * Balles présentes dans l'espace :
     */
    private Balle baballe;

    /**
     * Consructeur : prend en argument la balle à placer dans l'espace :
     */
    public Space(Balle baballe) {
        this.baballe = baballe;
    }

    public void next() {
        baballe.next();
        this.bounce();
    }

    public void bounce() {
        if(baballe.y > this.top) {
            baballe.y = this.top - (baballe.y - this.top);
            baballe.Vy = -baballe.Vy * e;
        }

        if(baballe.y < this.bottom) {
            baballe.y = this.bottom + (this.bottom - baballe.y);
            baballe.Vy = -baballe.Vy * e;
        }
        
        if(baballe.x < this.left) {
            baballe.x = this.left + (this.left - baballe.x);
            baballe.Vx = -baballe.Vx * e;
        }
        
        if(baballe.x > this.right) {
            baballe.x = this.right - (baballe.x - this.right);
            baballe.Vx = -baballe.Vx * e;
        }
    }

}
