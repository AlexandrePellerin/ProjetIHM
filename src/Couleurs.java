import java.awt.Color;

public class Couleurs {

	private Color couleur;
	
	public Couleurs(){
		this.couleur = new Color(0, 0, 0);
	}
	
	public Couleurs(int r,int g,int b){
		this.couleur = new Color(r,g,b);
	}
	
	public Color getCouleur(){
		return this.couleur;
	}
	
	public void setCouleur(int r,int g,int b){
		this.couleur = new Color(r,g,b);
	}
}
