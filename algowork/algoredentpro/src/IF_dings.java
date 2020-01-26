import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IF_dings extends Viereck{

	gui_fenster fenster;
	JLabel true_zweig = new JLabel("true");
	JLabel false_zweig = new JLabel("false");
	public IF_dings(gui_fenster fenster) {
		super(fenster,0,true,true,false);
		this.fenster = fenster;
	//	true_zweig.setEditable(false);
//		false_zweig.setEditable(false);
		true_zweig.setHorizontalAlignment(RIGHT);
		
	}
	
	@Override
	public void notwendig() {
		super.notwendig();
		if(true_zweig.isVisible())true_zweig.setLocation(new Point(getLocation().x-50,getLocation().y));
		if(false_zweig.isVisible())false_zweig.setLocation(new Point(getLocation().x+getWidth(),getLocation().y));
	}
	
	@Override
	public void pfeilStart1() {
		super.pfeilStart1();
		true_zweig.setVisible(true);
		true_zweig.setSize(new Dimension(50,15));
		fenster.canvas.add(true_zweig);
		
	}
	@Override
	public void pfeilStart2() {
		super.pfeilStart2();
		false_zweig.setVisible(true);
		false_zweig.setSize(new Dimension(50,15));
		fenster.canvas.add(false_zweig);
	}
}
