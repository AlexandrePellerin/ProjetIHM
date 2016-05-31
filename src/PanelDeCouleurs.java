import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDeCouleurs extends JPanel implements MouseListener{

	private static final long serialVersionUID = -3824748272883912645L;

	ArrayList<Couleurs> liste = new ArrayList<>();
	ArrayList<JLabel> labels = new ArrayList<>();
	public int selectionne=0;
	public Sliders sliders ;
	
	public PanelDeCouleurs(){
		this.liste.add(new Couleurs(255,0,0));
		this.repaint();
		this.addMouseListener(this);
	}
	
	public PanelDeCouleurs(int n){
		if(n>10){
			n=10;
		}
		for(int i=0;i<n;i++){
			this.liste.add(new Couleurs(10,((i*10)%255),((i*50)%255)));
			this.labels.add(new JLabel(this.liste.get(i).toString()));
			this.add(this.labels.get(i));
		}
		this.addMouseListener(this);
		this.repaint();
	}
	
	public void setSliders(Sliders sliders){
		this.sliders = sliders;
	}
	
	public void setCouleur(int i,int r,int g,int b){
		this.liste.get(i).setCouleur(r, g, b);
	}
	
	public void add(){
		if(this.liste.size()<10){
			this.liste.add(new Couleurs(10,100,100));
			this.labels.add(new JLabel(this.liste.get(this.liste.size()-1).toString()));
			this.add(this.labels.get(this.labels.size()-1));
		}
	}
	
	public void remove(){
		if(this.liste.size()>4){
			this.liste.remove(this.liste.size()-1);
		}
		this.repaint();
	}
	
	public void remove(int indice){
		if(this.liste.size()>4){
			this.liste.remove(indice);
		}
		this.repaint();
	}
	
	public Couleurs getCouleurs(int i){
		return this.liste.get(i);
	}
	
	public int getIndice(){
		return this.selectionne;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i=0;i<this.liste.size();i++){
			g.setColor(this.liste.get(i).getCouleur());
			g.fillRect(5+i*100,20, 50, 50);
			
			Color temp = this.liste.get(i).getCouleur();
			int gris = (int) (0.3 * temp.getRed() + 0.59 * temp.getGreen() + 0.11 * temp.getBlue());
			temp = new Color(gris, gris, gris);
			g.setColor(temp);
			g.fillRect(5+i*100,200, 50, 50);
			this.labels.get(i).setText(this.liste.get(i).toString());
			this.labels.get(i).setBounds(5+i*100, 135, this.labels.get(i).getWidth(), this.labels.get(i).getHeight());
		}
		
		g.setColor(Color.BLACK);
		g.drawLine(5, 0, this.getWidth()-5, 0);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("x = "+arg0.getX()+" : y = "+ arg0.getY()+" ;");
		this.selectionne++;
		this.selectionne = this.selectionne % this.liste.size();
		System.out.println(this.selectionne);
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
