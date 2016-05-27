import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Main {
	
	public static void main(String[]args){
		JFrame fenetre = new JFrame("IHM");
		fenetre.setSize(800, 500);
		fenetre.setResizable(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();
		JMenuBar menu = new JMenuBar();
		
		JMenu m1 = new JMenu("Fichier");
		JMenu m2 = new JMenu("Edition");
		JMenu m3 = new JMenu("Affichage");
		JMenu m4 = new JMenu("Options");
		JMenu m5 = new JMenu("Aide");
		
		m1.add("Nouveau");
		
		m2.add("Retour arriere");
		
		m3.add("Compil Auto des Couleurs");
		
		m4.add("Rajouter une couleur");
		
		m5.add("A Propos");
		
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		menu.add(m5);
		
		JPanel bouttons = new JPanel();
		bouttons.add(new JButton("Auto"));
		//bouttons.setSize(fenetre.getWidth()/3,fenetre.getHeight()/10);
		
		
		ArcEnCiel arcenciel = new ArcEnCiel();
		//arcenciel.setSize(fenetre.getWidth()/3,fenetre.getHeight()/10);
		
		JPanel sliders = new JPanel();
		sliders.add(new JSlider());
		//sliders.setSize(fenetre.getWidth()/3,fenetre.getHeight()/10);

		PanelDeCouleurs panneau = new PanelDeCouleurs(2);
		panneau.setSize(fenetre.getWidth(),fenetre.getHeight()/2);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;c.gridwidth=3;
		fenetre.add(menu,c);
		c.gridx=0;c.gridy=1;c.gridheight=5;c.gridwidth=1;
		fenetre.add(bouttons,c);
		c.gridx=1;c.gridy=1;c.gridheight=5;c.gridwidth=1;
		fenetre.add(arcenciel,c);
		c.gridx=2;c.gridy=1;c.gridheight=5;c.gridwidth=1;
		fenetre.add(sliders,c);
		c.gridx=0;c.gridy=6;c.gridheight=10;c.gridwidth=3;
		fenetre.add(panneau,c);
		
		for(int i=0;i<17;i++){
			c.gridx=3;c.gridy=i;c.gridheight=1;c.gridwidth=1;
			fenetre.add(new JLabel(" "),c);
		}
		
		fenetre.setVisible(true);
	}
	
}
