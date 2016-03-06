public class BouncingBalls {

    public static void main(String[] args) {
        // On instancie une baballe :
        Balle balle = new Balle(.5, 1);

        // On fabrique un espace pour les faire évoluer :
        Space space = new Space(balle);

    	// On initialise l'animation :
        Animation animation = new Animation(space.top);

    	// Vitesse minimale du critère d'arrêt de l'animation :
        // .3 semble être une bonne valeur
        double eps = .001;
        
        int frame = 0;
        
        // On interagit avec l'espace entier, qui se charge de les faire rebondir :
        while(frame < 100 || Math.abs(balle.Vx) > eps || Math.abs(balle.Vy) > eps) {
            space.next();
            animation.nextFrame(balle.x, balle.y);
            frame++;
        }
        
    }
    
    

}
