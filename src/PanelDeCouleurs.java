import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelDeCouleurs extends JPanel implements MouseListener {

	private static final long serialVersionUID = -3824748272883912645L;

	ArrayList<PanneauCouleurUnique> list = new ArrayList<>();
	// ArrayList<Couleurs> liste = new ArrayList<>();
	// ArrayList<JLabel> labels = new ArrayList<>();
	public int selectionne = 0;
	public Sliders sliders;
	private Random alea = new Random();

	public PanelDeCouleurs() {
		this.list.add(new PanneauCouleurUnique());
		//this.repaint();
		this.addMouseListener(this);
	}

	public PanelDeCouleurs(int n) {
		for(int i=0;i<n;i++){
			this.list.add(new PanneauCouleurUnique(i));
		}
		this.addMouseListener(this);
		this.repaint();
	}

	public void setSliders(Sliders sliders) {
		this.sliders = sliders;
	}

	public void setCouleur(int i, int r, int g, int b) {
		this.list.get(i).getCouleur().setCouleur(r, g, b);
		this.list.get(i).setLabel(this.list.get(i).getCouleur().toString());
	}

	public void add() {
		if (this.list.size() < 10) {
			this.list.add(new PanneauCouleurUnique());
			PanneauCouleurUnique temp = this.list.get(list.size() - 1);
			temp.setCouleur(new Couleurs(0, 255, 0));
			temp.setLabel(temp.getCouleur().toString());
			this.add(temp);
		}
		this.repaint();
	}

	public void remove() {
		if (this.list.size() > 4) {
			this.list.remove(this.list.size() - 1);
		}
		if(selectionne!=0){
			this.selectionne--;
		}
		this.repaint();
	}

	public void remove(int indice) {
		if (this.list.size() > 4) {
			this.list.remove(indice);
		}
		if(this.selectionne>=indice && selectionne != 0){
			this.selectionne--;
		}
		this.repaint();
	}

	public Couleurs getCouleurs(int i) {
		return this.list.get(i).getCouleur();
	}

	public int getIndice() {
		return this.selectionne;
	}
	
	public void trieGris(){
		int cpt = this.list.size()-1;
		while(cpt>0){
			for(int i=0;i<cpt;i++){
				if( this.list.get(i).getGris() > this.list.get(i+1).getGris()){
					this.list = this.inverser(i);
				}
			}
			cpt--;
		}
		this.list.get(selectionne).setBorder(null);
		this.selectionne = 0;
		this.list.get(selectionne).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		this.sliders.updateSliders();
		this.repaint();
	}

	public ArrayList<PanneauCouleurUnique> inverser(int indice){
		ArrayList<PanneauCouleurUnique> res = new ArrayList<>();
		for(int i=0;i<this.list.size();i++){
			if(i==indice){
				res.add(this.list.get(indice+1));
			}else if(i==(indice+1)){
				res.add(this.list.get(indice));
			}else{
				res.add(this.list.get(i));
			}
		}
		return res;
	}
	
	public void auto(){
		this.list.get(0).setCouleur(new Couleurs(10,10,10));
		for(int i=1;i<this.list.size();i++){
			this.list.get(i).setCouleur(new Couleurs(alea.nextInt(220)+20,alea.nextInt(220)+20,
					alea.nextInt(220)+20));
		}
		this.trieGris();
		int taille = 220 /( this.list.size()-1);
		int marge = (int)0.2 * taille;
		
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=1;i<this.list.size();i++){
			Couleurs temp = this.list.get(i).getCouleur();
			if(!(this.list.get(i).getGris()>this.list.get(0).getGris()+(taille*i)-marge &&
					this.list.get(i).getGris()<this.list.get(0).getGris()+(taille*i)+marge)){
				
				int diff =-( this.list.get(i).getGris() -( this.list.get(0).getGris()+(taille*i)))/3;
				try{
					temp = new Couleurs(temp.getCouleur().getRed()+diff,temp.getCouleur().getGreen()
						+diff,temp.getCouleur().getBlue()+diff);
				}catch(IllegalArgumentException e){
					int red = temp.getCouleur().getRed()+diff;
					int green = temp.getCouleur().getGreen()+diff;
					int blue = temp.getCouleur().getBlue()+diff;
					if(red>255){
						red = 255;
					}
					if(green>255){
						green = 255;
					}
					if(blue>255){
						blue = 255;
					}
					
				}
				this.list.get(i).setCouleur(temp);
			}
		}
		this.repaint();
		Main.updateFrame();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		this.removeAll();
		int taille = this.list.size();
		this.setLayout(new GridLayout(1 , taille));
		for (int i = 0; i < this.list.size(); i++) {
			this.add(this.list.get(i));
			this.list.get(i).repaint();
			if(i==this.selectionne){
				this.list.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			}
		}

		g.setColor(Color.BLACK);
		g.drawLine(5, 0, this.getWidth() - 5, 0);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.list.get(selectionne).setBorder(null);
		this.selectionne = (arg0.getX()/(this.getWidth()/this.list.size()));
		
		this.selectionne = this.selectionne % this.list.size();
		this.repaint();
		sliders.updateSliders();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
