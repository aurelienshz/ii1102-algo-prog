import java.awt.Color;

public class Config {
	
	/**
	 * Intervalle de temps entre les frames
	 */
	public static final double t = 0.01; //s
	
	/**
	 * Coefficient de frottement fluide rapporté à la masse de la balle :
	 * 0.05 semble être une bonne valeur : la hauteur des rebonds se stabilise alors autour de 0.7 pour une balle "parfaite" (ie e = 1)
	 */
	public static final double k = 0.05;
	
	/**
	 * Accélération de la pesanteur :
	 */
	public static final double g = -9.81; // m/s^2
	
	/**
	 * Durée de l'animation :
	 */
	public static final double duration = 15; // s
	
	/**
	 * Largeur des balles :
	 */
	public static final float diameter = .03f;
	
	/**
	 * Limites géographiques de l'espace :
	 */
	public static final double top = 1;
	public static final double bottom = 0;
	public static final double right = 2;
	public static final double left = 0;
	
	/**
	 * Couleur par défaut des balles :
	 */
	public static final Color defaultColor = StdDraw.RED;
	
	/**
	 * Ratio px/m pour l'affichage :
	 */
	public static final int pxRatio = 256;
	
	/**
	 * Masse des balles :
	 */
	public static final double mass = .1; // kg
}
