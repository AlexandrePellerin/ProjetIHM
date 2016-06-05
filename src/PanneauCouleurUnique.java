import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanneauCouleurUnique extends JPanel {

	private static final long serialVersionUID = 8516941543672756042L;

	private Couleurs couleur;
	private JLabel label;

	public PanneauCouleurUnique() {
		this.couleur = new Couleurs(255, 0, 0);
		this.label = new JLabel(this.couleur.toString(),SwingConstants.CENTER);
		this.repaint();
		this.setLayout(new GridLayout(1, 3));
		this.add(new JLabel(" "));
		this.add(this.label);
		this.add(new JLabel(" "));
	}

	public PanneauCouleurUnique(int n) {
		this.couleur = new Couleurs(10, ((n * 10) % 255), ((n * 50) % 255));
		this.label = new JLabel(this.couleur.toString());
		this.repaint();
		this.setLayout(new GridLayout(1, 3));

		this.add(new JLabel(" "));
		this.add(this.label);
		this.add(new JLabel(" "));
	}
	
	public Couleurs getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Couleurs couleur) {
		this.couleur = couleur;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(String chaine) {
		this.label.setText(chaine);
	}
	
	public int getGris(){
		Color temp = this.couleur.getCouleur();
		int gris = (int) (0.3* temp.getRed() + 0.59*temp.getGreen() + 0.11 * temp.getBlue());
		return gris;
	}

	public void paintComponent(Graphics g){
		g.setColor(this.couleur.getCouleur());
		g.fillRect(5, 5, (this.getWidth())-10, (this.getHeight()/3)-5);
		
		int gris = this.getGris(); 
		g.setColor(new Color(gris, gris, gris));
		g.fillRect(5, (this.getHeight()/3)*2+5, (this.getWidth())-10, (this.getHeight()/3)-10);
	}
}
