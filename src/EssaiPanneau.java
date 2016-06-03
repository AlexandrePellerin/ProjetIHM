import javax.swing.JFrame;

public class EssaiPanneau {

	public static void main(String[]args){
		JFrame fenetre = new JFrame("Toutca");
		fenetre.setVisible(true);
		fenetre.setSize(200, 300);
		fenetre.add(new PanneauCouleurUnique());
	}
}
