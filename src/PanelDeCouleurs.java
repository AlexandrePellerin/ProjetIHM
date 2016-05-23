import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelDeCouleurs extends JPanel{

	private static final long serialVersionUID = -3824748272883912645L;

	ArrayList<Couleurs> liste = new ArrayList<>();
	
	public PanelDeCouleurs(){
		this.liste.add(new Couleurs(255,0,0));
		this.repaint();
	}
	
	public PanelDeCouleurs(int n){
		for(int i=0;i<n;i++){
			this.liste.add(new Couleurs(255,0,0));
		}
		this.repaint();
	}
	
	public void setCouleur(int i,int r,int g,int b){
		this.liste.get(i).setCouleur(r, g, b);
	}
	
	public void paintComponent(Graphics g){
		for(int i=0;i<this.liste.size();i++){
			g.setColor(this.liste.get(i).getCouleur());
			g.fillRect(0+i*50,0+i*50, 50, 50);
		}
		
		System.out.println("Je suis execute");
	}
}
