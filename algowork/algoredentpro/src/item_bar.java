import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class item_bar extends JPanel {

	gui_fenster fenster;
	private ArrayList<Viereck> obs = new ArrayList<Viereck>();
	private JTextField text1 = new JTextField("building blocks algorithms");
	private JTextField hinter1 = new JTextField();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	public boolean build = false;

	public item_bar(gui_fenster fenster) {
		this.fenster = fenster;
		com_ber();
		erstellen_butts();
		action_butts();
		not_wendig_update();
	}

	public void com_ber() {

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		text1.setEditable(false);
		text1.setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
		add(text1);
		add(hinter1);
		hinter1.setEditable(false);
		hinter1.setBackground(Color.LIGHT_GRAY);
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		
		hinter1.setLayout(layout);
	}

	public void erstellen_butts() {

		buttons.add(new JButton("\tIF\t"));
		buttons.add(new JButton("ACTION"));
		buttons.add(new JButton("While"));
		buttons.add(new JButton("While END"));
		buttons.add(new JButton("TEXT"));
		buttons.add(new JButton("Algo_END"));
		buttons.add(new JButton("Algo_START"));
		buttons.add(new JButton("Algo_Input_Output"));

		
		for(int i = 0;i < buttons.size();i++){
//			buttons.get(i).setPreferredSize(new Dimension(buttons.get(i).getPreferredSize().width+10, 50));
//			buttons.get(i).setPreferredSize(new Dimension(100, 50));
			buttons.get(i).setBackground(Color.WHITE);
			buttons.get(i).setForeground(Color.DARK_GRAY);

		}
		for (int i = 0; i < buttons.size(); i++)
			hinter1.add(buttons.get(i));

	}

	public void action_butts() {
	
		for(int i = 0; i < buttons.size();i++) {
			int a = i;
			buttons.get(i).addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mousePressed(MouseEvent e) {
					if (build == false) {
						switch (a) {
						case 0:
							fenster.vier.add(new IF_dings(fenster));
							break;
						case 1:
							fenster.vier.add(new anweisung_dings(fenster));
							break;
						case 2:
							fenster.vier.add(new while1(fenster));
							break;
						case 3:
							fenster.vier.add(new schfleif_back(fenster));
							break;
						case 4:
							fenster.vier.add(new Viereck(fenster));
							break;
						case 5:
							fenster.vier.add(new algo_end(fenster));
							break;
						case 6:
							fenster.vier.add(new algo_start(fenster));
							break;
						case 7:
							fenster.vier.add(new algo_start_in_out(fenster));
							break;

						
						}
//						fenster.vier.add(new IF_dings(fenster));
//						fenster.vier.add(new Viereck(fenster));
						build = true;
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {

				}
			});
		}
		
	}

	public void buttons() {
		text1.setBounds(0, 0, getWidth(), 50);
		hinter1.setBounds(0, 50, getWidth(), getHeight() - 300);
		
		
	}

	public void not_wendig_update() {
		buttons();
		
	}

}
