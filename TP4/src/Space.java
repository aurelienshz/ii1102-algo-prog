public class Space {

    /**
     * Limites géopgraphique de l'espace :
     * le point origine est toujours situé en bas à gauche
     */
    public double top = Config.top;
    public double bottom = Config.bottom;
    public double left = Config.left;
    public double right = Config.right;
    
    /**
     * e : coefficient de restitution des rebonds :
     * Rq : 0.9 semble être une bonne valeur :
     */
    public double e = 0.9;

    /**
     * Balles présentes dans l'espace :
     */
    private Balle[] balles;

    /**
     * Consructeur : prend en argument la balle à placer dans l'espace :
     */
    public Space(Balle[] baballes) {
        this.balles = baballes;
    }

    public void next() {
    	for(Balle balle : balles) {
    		balle.next();
            this.bounce(balle);
    	}
    	
    	/**
    	 * Détection de collisions :
    	 */
    	for(int i = 0; i<balles.length; i++) {
    		for(int j = i+1; j<balles.length; j++) {
				double dist = Math.sqrt(Math.pow(balles[i].x - balles[j].x,2) + Math.pow(balles[i].y - balles[j].y,2));
    			if(dist <= Config.diameter) {
    				
    				System.out.println("Collision !");
    				
    				double[] tangente = new double[2];
    				double[] normale = new double[2];
    				
    				normale[0] = balles[j].x - balles[i].x / Config.diameter;
    				normale[1] = balles[j].y - balles[i].y / Config.diameter;
    				
    				tangente[0] = - normale[1];
    				tangente[1] = normale[0];
    				
    				System.out.println(tangente[0] +", "+ tangente[1]);
    				try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
    		}
    	}
    }
    
    public void bounce(Balle balle) {
        if(balle.y > this.top) {
            balle.y = this.top - (balle.y - this.top);
            balle.Vy = -balle.Vy * e;
        }

        if(balle.y < this.bottom) {
            balle.y = this.bottom + (this.bottom - balle.y);
            balle.Vy = -balle.Vy * e;
        }
        
        if(balle.x < this.left) {
            balle.x = this.left + (this.left - balle.x);
            balle.Vx = -balle.Vx * e;
        }
        
        if(balle.x > this.right) {
            balle.x = this.right - (balle.x - this.right);
            balle.Vx = -balle.Vx * e;
        }
    }

}
