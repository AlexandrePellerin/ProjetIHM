import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauCouleurUnique extends JPanel {

	private static final long serialVersionUID = 8516941543672756042L;

	Couleurs liste;
	JLabel labels;

	public PanneauCouleurUnique() {
		this.liste = new Couleurs(255, 0, 0);
		this.labels = new JLabel(this.liste.toString());
		this.repaint();
		this.setLayout(new GridLayout(1, 3));
		this.add(new JLabel(" "));
		this.add(this.labels);
		this.add(new JLabel(" "));
	}

	public PanneauCouleurUnique(int n) {
		this.liste = new Couleurs(10, ((n * 10) % 255), ((n * 50) % 255));
		this.labels = new JLabel(this.liste.toString());
		this.repaint();
		this.setLayout(new GridLayout(1, 3));

		this.add(new JLabel(" "));
		this.add(this.labels);
		this.add(new JLabel(" "));
	}
	
	public void paintComponent(Graphics g){
		g.setColor(this.liste.getCouleur());
		g.fillRect(5, 5, (this.getWidth())-10, (this.getHeight()/3)-5);
		
		Color temp = this.liste.getCouleur();
		int gris = (int) (0.3 * temp.getRed() + 0.59 * temp.getGreen() + 0.11 * temp.getBlue());
		temp = new Color(gris, gris, gris);
		g.setColor(temp);
		g.fillRect(5, (this.getHeight()/3)*2+5, (this.getWidth())-10, (this.getHeight())-10);
	}
}
