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
	
	public void setColor(Color color){
		this.couleur = color;
	}
	
	public String toString(){
		String temp = "#";
		if(Integer.toHexString(this.getCouleur().getRed()).length()==1){
			temp += "0";
		}
		temp += Integer.toHexString(this.getCouleur().getRed());
		
		if(Integer.toHexString(this.getCouleur().getGreen()).length()==1){
			temp += "0";
		}
		temp += Integer.toHexString(this.getCouleur().getGreen());
		
		if(Integer.toHexString(this.getCouleur().getBlue()).length()==1){
			temp += "0";
		}
		temp += Integer.toHexString(this.getCouleur().getBlue());
		
		return temp;
	}
}
