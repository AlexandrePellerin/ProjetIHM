import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Main {
	
	public static void main(String[]args){
		JFrame fenetre = new JFrame("IHM");
		fenetre.setSize(500, 500);
		fenetre.setResizable(false);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		bouttons.setSize(fenetre.getWidth()/3,fenetre.getHeight()/10);
		
		
		ArcEnCiel arcenciel = new ArcEnCiel();
		arcenciel.setSize(fenetre.getWidth()/3,fenetre.getHeight()/10);
		
		JPanel sliders = new JPanel();
		sliders.add(new JSlider());
		sliders.setSize(fenetre.getWidth()/3,fenetre.getHeight()/10);

		PanelDeCouleurs panneau = new PanelDeCouleurs(2);
		panneau.setSize(fenetre.getWidth(),fenetre.getHeight()/2);
		
		fenetre.setLayout(new GridLayout(3,1));
		
		/*fenetre.getContentPane().add(menu,BorderLayout.NORTH);
		fenetre.getContentPane().add(bouttons,BorderLayout.WEST);
		fenetre.getContentPane().add(arcenciel,BorderLayout.CENTER);
		fenetre.getContentPane().add(sliders,BorderLayout.EAST);
		fenetre.getContentPane().add(panneau,BorderLayout.SOUTH);*/
		
		fenetre.getContentPane().add(menu);
		
		JPanel troll = new JPanel();
		troll.setLayout(new GridLayout(1,3));
		troll.add(bouttons);
		troll.add(arcenciel);
		troll.add(sliders);
		fenetre.getContentPane().add(troll);
		
		fenetre.getContentPane().add(panneau);
		
		fenetre.setVisible(true);
	}
	
}
