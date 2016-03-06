public class BouncingBalls {

    public static void main(String[] args) {
        // On instancie une baballe :
        Balle balle = new Balle();

        // On fabrique un espace pour les faire évoluer :
        Space space = new Space(balle);

    	// On initialise l'animation :
        Animation animation = new Animation(space.top);

    	// Vitesse minimale du critère d'arrêt de l'animation :
        // .3 semble être une bonne valeur
        double eps = .3;

        // On interagit avec l'espace entier, qui se charge de les faire rebondir :
        while(Math.abs(balle.Vx) > eps || Math.abs(balle.Vy) > eps) {
            space.next();
            animation.nextFrame(balle.x, balle.y);
        }
        
    }
    
    

}
