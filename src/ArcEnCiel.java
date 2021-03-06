import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ArcEnCiel extends JPanel{
	
	private static final long serialVersionUID = -8708382076577068170L;

	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				g.fillRect(10+i*25, 10+j*25, 20, 20);
			}
		}
		g.setColor(Color.BLACK);
		g.drawLine(0, 5, 0, this.getHeight()-5);
		g.drawLine(this.getWidth()-1, 5, this.getWidth()-1, this.getHeight()-5);
	}
}
