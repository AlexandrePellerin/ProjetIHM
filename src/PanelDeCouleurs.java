import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDeCouleurs extends JPanel{

	private static final long serialVersionUID = -3824748272883912645L;

	ArrayList<Couleurs> liste = new ArrayList<>();
	ArrayList<JLabel> labels = new ArrayList<>();
	public int selectionne=-1;
	
	public PanelDeCouleurs(){
		this.liste.add(new Couleurs(255,0,0));
		this.repaint();
	}
	
	public PanelDeCouleurs(int n){
		if(n>10){
			n=10;
		}
		for(int i=0;i<n;i++){
			this.liste.add(new Couleurs(255,i*20,(i*50)%255));
			this.labels.add(new JLabel(this.liste.get(i).toString()));
			this.add(this.labels.get(i));
		}
		this.repaint();
	}
	
	public void setCouleur(int i,int r,int g,int b){
		this.liste.get(i).setCouleur(r, g, b);
	}
	
	public void paintComponent(Graphics g){
		for(int i=0;i<this.liste.size();i++){
			g.setColor(this.liste.get(i).getCouleur());
			g.fillRect(5+i*100,20, 50, 50);
			
		}
		
		g.setColor(Color.BLACK);
		g.drawLine(5, 0, this.getWidth()-5, 0);
		System.out.println("Je suis execute");
	}
}