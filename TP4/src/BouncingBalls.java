import java.awt.Color;

public class BouncingBalls {
	
	// Collisions : parcourir le tableau des balles (0, n-2)
	// Pour une balle d'indice i, tester s'il y a une collision avec une balle d'indice compris dans [i+1,n-1]
	// Détecter une collision : distance centre de la balle testée <= 2*rayon
	// Résultat collision : conservation de la qté de mvt (p = mv)
	
    public static void main(String[] args) {
        // On instancie les baballes :
        Balle[] balles = new Balle[2];
        
	        balles[0] = new Balle(.5, 1, StdDraw.GREEN);
	        balles[1] = new Balle(.5, .5, 1, 1, new Color(200, 0, 160));
	        // balles[2] = new Balle(1, 1, -1, 0);
	        
        // On instancie un espace pour les faire évoluer :
        Space space = new Space(balles);

    	// On initialise l'animation :
        Animation animation = new Animation();
        
        // Compteur d'images :
        int frame = 0;
        
        // Nombre d'images nécessaires :
        int frames = (int) Math.ceil(Config.duration / Config.t);
        
        // On interagit avec l'espace entier, qui se charge de les faire rebondir :
        while(frame < frames) {
            space.next();
            animation.nextFrame(balles);
            frame++;
        }
        
    }
    
    

}
