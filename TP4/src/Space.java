public class Space {

    /**
     * Limites géopgraphique de l'espace :
     * le point origine est toujours situé en bas à gauche
     */
    public double top = 1;
    public double bottom = 0;

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
            baballe.y = top - (baballe.y - top);
            baballe.Vy = -baballe.Vy;
        }

        if(baballe.y < this.bottom) {
            baballe.y = bottom + (bottom - baballe.y);
            baballe.Vy = -baballe.Vy;
        }
    }

}
