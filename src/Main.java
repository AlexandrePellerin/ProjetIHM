import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main {

	public static PanelDeCouleurs panneau;
	public static JFrame fenetre;
	
	public static void main(String[] args) {
		fenetre = new JFrame("TestMain");
		fenetre.setMinimumSize(new Dimension(910,500));
		fenetre.setSize(910, 500);
		fenetre.setResizable(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau = new PanelDeCouleurs(5);

		Menu menuBar = new Menu(panneau);
		fenetre.setJMenuBar(menuBar);

		
		fenetre.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel bouttons = new JPanel();
		bouttons.setLayout(new GridLayout(2, 2));
		bouttons.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		bouttons.add(new JButton("Auto"));
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panneau.add();
				Dimension temp = fenetre.getSize();
				temp.height++;
				fenetre.setSize(temp);
				temp.height--;
				fenetre.setSize(temp);
			}
		});
		JButton enlever = new JButton("Retirer");
		enlever.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panneau.remove();
				Dimension temp = fenetre.getSize();
				temp.height++;
				fenetre.setSize(temp);
				temp.height--;
				fenetre.setSize(temp);
			}
		});
		JButton trie = new JButton("Trier");
		trie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panneau.trieGris();
				Dimension temp = fenetre.getSize();
				temp.height++;
				fenetre.setSize(temp);
				temp.height--;
				fenetre.setSize(temp);
			}
		});
		bouttons.add(trie);
		bouttons.add(ajouter);
		bouttons.add(enlever);
		
		Sliders sliders = new Sliders(panneau);
		panneau.setSliders(sliders);
		
		JPanel millieu = new JPanel();
		millieu.setLayout(new GridLayout(1,2));
		millieu.add(bouttons);
		millieu.add(sliders);
		fenetre.add(millieu);
		
		fenetre.add(panneau);
		panneau.repaint();
		
		fenetre.setVisible(true);
		
		Dimension temp = fenetre.getSize();
		temp.height++;
		fenetre.setSize(temp);
		temp.height--;
		fenetre.setSize(temp);
		
	}

}
