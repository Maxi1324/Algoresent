import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;

public class main {

	public static void main(String[] args) {
		new gui_fenster();
	}
	
	public static Font setsize(int size,JComponent compo)
	{
		return new Font(compo.getFont().getName(), compo.getFont().getStyle(), size);
	}

}
