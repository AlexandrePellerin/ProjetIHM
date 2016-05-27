import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Sliders extends JPanel{

	private static final long serialVersionUID = -4575342049181712379L;
	private PanelDeCouleurs pan;
	private JLabel labelRed;
	private JLabel labelBlue;
	private JLabel labelGreen;
	private JSlider sliderRed,sliderBlue,sliderGreen;
	
	public Sliders(PanelDeCouleurs panneau){
		this.pan = panneau;
		this.setLayout(new GridLayout(3,3));
		this.add(new JLabel("Red"));
		sliderRed = new JSlider(0,255);
		this.add(sliderRed);
		sliderRed.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				labelRed.setText(""+sliderRed.getValue());
				if(pan.selectionne != -1){
					
				}
			}
		});
		this.labelRed = new JLabel(""+sliderRed.getValue());
		this.add(labelRed);
		
		this.add(new JLabel("Red"));
		sliderGreen = new JSlider(0,255);
		this.add(sliderGreen);
		sliderGreen.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				labelGreen.setText(""+sliderGreen.getValue());
				if(pan.selectionne != -1){
					
				}
			}
		});
		this.labelGreen = new JLabel(""+sliderGreen.getValue());
		this.add(labelGreen);
		
		this.add(new JLabel("Blue"));
		sliderBlue = new JSlider(0,255);
		this.add(sliderBlue);
		sliderBlue.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				labelBlue.setText(""+sliderBlue.getValue());
				if(pan.selectionne != -1){
					
				}
			}
		});
		this.labelBlue = new JLabel(""+sliderBlue.getValue());
		this.add(labelBlue);
	}
}
