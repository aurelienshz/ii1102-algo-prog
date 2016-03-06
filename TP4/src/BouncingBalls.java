public class BouncingBalls {

    public static void main(String[] args) {
        // On instancie une baballe :
        Balle[] balles = new Balle[3];
        
        balles[0] = new Balle(.5, 1);
        balles[1] = new Balle(.5, .5, 1, 1);
        balles[2] = new Balle(1, 1, -1, 0);

        // On fabrique un espace pour les faire évoluer :
        Space space = new Space(balles);

    	// On initialise l'animation :
        Animation animation = new Animation(space.top);

    	// Vitesse minimale du critère d'arrêt de l'animation :
        // .3 semble être une bonne valeur
        double eps = .001;
        
        int frame = 0;
        
        // On interagit avec l'espace entier, qui se charge de les faire rebondir :
        while(frame < 1000) {
            space.next();
            animation.nextFrame(balles);
            frame++;
        }
        
    }
    
    

}
