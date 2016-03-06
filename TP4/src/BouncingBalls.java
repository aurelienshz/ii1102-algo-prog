public class BouncingBalls {

    public static void main(String[] args) {
        // On instancie des baballes :
        Balle balle = new Balle();

        // On fabrique un espace pour les faire évoluer :
        Space space = new Space(balle);

    	// On initialise l'animation :
        Animation animation = new Animation(space.top);

        
        // On interagit avec l'espace entier, qui se charge de les faire rebondir :
        for(int i=0; i<1500; i++) {
            System.out.println(balle.y);
            space.next();
            animation.nextFrame(balle.y);
        }
        
    }
    
    

}
