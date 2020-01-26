import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Viereck extends JTextField {

	private int y = 50;
	private int x = 100;
	private gui_fenster fenster;
	private boolean grabed = false;
	private JButton move;
	private Pfeilstart[] pfeilstart = new Pfeilstart[3];
	private Pfeilende input;
	private boolean right_left;
	private Point offset = new Point();
	private JPopupMenu pop = new JPopupMenu("lal");
	private JMenuItem item = new JMenuItem("  löschen  ");
	private Viereck viereck1;
	public boolean start = true;
	private boolean start_einmal;
	int num_in_vier;
	private Point[] pfeile_dings = new Point[4];
	int typ;

	public Viereck(gui_fenster fenster) {
		this.fenster = fenster;
		input = new Pfeilende(fenster);
		pop.add(item);
		viereck_graph();
		action();
		arrowstart();
		viereck1 = this;
		item.setBackground(Color.WHITE);
		grabed = false;
		Point mouse = fenster.getMousePosition();

		offset.x = (mouse.x - getLocation().x);
		offset.y = (mouse.y - getLocation().y);

		num_in_vier = fenster.vier.size();
		fenster.canvas.add(this);
		typ = 1;
	}

	public Viereck(gui_fenster fenster, int rahmen_typ) {
		this.fenster = fenster;
		input = new Pfeilende(fenster);
		pop.add(item);
		viereck_graph();
		action();
		arrowstart();
		viereck1 = this;
		item.setBackground(Color.WHITE);
		grabed = false;
		Point mouse = fenster.getMousePosition();

		offset.x = (mouse.x - getLocation().x);
		offset.y = (mouse.y - getLocation().y);

		num_in_vier = fenster.vier.size();
		fenster.canvas.add(this);
		typ = rahmen_typ;
	}

	public Viereck(gui_fenster fenster, int rahmen_typ, boolean feld1, boolean feld2, boolean feld3) {
		this.fenster = fenster;
		input = new Pfeilende(fenster);
		pop.add(item);
		viereck_graph();
		action();
		arrowstart();
		viereck1 = this;
		item.setBackground(Color.WHITE);
		grabed = false;
		Point mouse = fenster.getMousePosition();
 
		offset.x = (mouse.x - getLocation().x);
		offset.y = (mouse.y - getLocation().y);

		num_in_vier = fenster.vier.size();
		fenster.canvas.add(this);
		typ = rahmen_typ;
		if (!feld1)
			fenster.canvas.remove(pfeilstart[0]);
		if (!feld2)
			fenster.canvas.remove(pfeilstart[1]);
		if (!feld3)
			fenster.canvas.remove(pfeilstart[2]);
	}

	public void output_opt(int n, boolean state) {
		if (n < 3)
			fenster.canvas.remove(pfeilstart[n]);
		else {
			System.err.println("Fehler:output_opt_n_zu_groß");
		}
	}

	public void set_pos(int x, int y) {
		setBounds(x, y, getWidth(), getHeight());
	}

	public void arrowstart() {

		pfeilstart[0] = new Pfeilstart(fenster, 0, this);
		pfeilstart[1] = new Pfeilstart(fenster, 1, this);
		pfeilstart[2] = new Pfeilstart(fenster, 2, this);

		for (int i = 0; i < pfeilstart.length; i++)
			fenster.canvas.add(pfeilstart[i]);

		fenster.canvas.add(input);

	}

	public void rebouns1() {
		if (right_left) {
			setBounds(getLocation().x + 1, getLocation().y + 1, getWidth() + 1, getHeight() + 1);
			right_left = false;
		} else {
			setBounds(getLocation().x - 1, getLocation().y - 1, getWidth() - 1, getHeight() - 1);
			right_left = true;
		}
	}

	public void notwendig() {
		if(start == false&& start_einmal == false) {
			onplaced();
			start_einmal = true;
		}
		if(input != null)input.notwendig();
		for(int i = 0;i < pfeilstart.length;i++) {
			if(pfeilstart[i] != null)pfeilstart[i].notwendig();
		}
	}

	public void pos_arrow() {
		if (pfeilstart[0] != null && pfeilstart[1] != null && pfeilstart[2] != null) {
			if (pfeilstart[0] != null) {
				pfeilstart[0].set_pos(getLocation().x - 20, getLocation().y + 16);
				pfeile_dings[0]= new Point(getLocation().x - 20, getLocation().y + getHeight()/2);
			}
			if (pfeilstart[1] != null) {
				pfeilstart[1].set_pos(getLocation().x + getWidth(), getLocation().y + 16);
				pfeile_dings[1]= new Point(getLocation().x + getWidth(), getLocation().y + 16);
				}
			if (pfeilstart[2] != null) {
				pfeilstart[2].set_pos(getLocation().x + (getWidth() / 2) - 10, getLocation().y + getHeight());
				pfeile_dings[2]= new Point(getLocation().x + (getWidth() / 2) - 10, getLocation().y + 50);
				
			}
			if (input != null) {
				
				input.set_pos(getLocation().x + (getWidth() / 2) - 10, getLocation().y -20);
				pfeile_dings[3]= new Point(getLocation().x + (getWidth() / 2) - 10, getLocation().y -20);
			}
		}
	}

	public void gegrabed() {
		if (grabed == true) {

			try {
				if (fenster != null) {
					set_pos(fenster.getMousePosition().x - offset.x, fenster.getMousePosition().y - offset.y);
				} else {
					return;
				}
			} catch (Exception e) {

			}
		}

		if (start == true) {

			try {
				if (fenster != null) {
					set_pos(fenster.getMousePosition().x - 200-fenster.canvas.getLocation().x, fenster.getMousePosition().y - 50-fenster.canvas.getLocation().y);
				} else {
					return;
				}
			} catch (Exception e) {

			}
		}

	}

	public void pfeilStart1() {

	}

	public void pfeilStart2() {

	}

	public void pfeilStart3() {

	}

	public void onscreen() {
		if (getLocation().x > fenster.getWidth() - getWidth() - 100) {

			int how_m = fenster.getWidth() - getLocation().x;
			set_pos(getLocation().x - 20, getLocation().y);
		}
		if (getLocation().y > fenster.getHeight() - getHeight() - 10) {
			set_pos(getLocation().x, getLocation().y - 20);
		}
	}

	@Override
	public void paint(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(8));
		if (typ == 1) {
			g2d.drawRect(0, 0, getWidth(), getHeight());
		}
		if (typ == 0) {
			if (start) {
				g2d.drawRect(0, 0, getWidth(), getHeight());
			} else {

			}
		}

	}

	public static int the_size_cal(String to_cal) {
		int theo_size = 0;
		int used = 0;
		theo_size += count_char("i", to_cal) * 5;
		used = used + count_char("i", to_cal);

		theo_size += count_char("I", to_cal) * 5;
		used = used + count_char("I", to_cal);

		theo_size += count_char("M", to_cal) * 18;
		used = used + count_char("M", to_cal);

		theo_size += count_char("m", to_cal) * 18;
		used = used + count_char("m", to_cal);

		theo_size += count_char("Q", to_cal) * 16;
		used = used + count_char("Q", to_cal);

		theo_size += count_char("w", to_cal) * 16;
		used = used + count_char("w", to_cal);

		theo_size += count_char("W", to_cal) * 22;
		used = used + count_char("W", to_cal);

		theo_size += count_char("E", to_cal) * 14;
		used = used + count_char("E", to_cal);

		theo_size += count_char("r", to_cal) * 7;
		used = used + count_char("r", to_cal);

		theo_size += count_char("R", to_cal) * 15;
		used = used + count_char("R", to_cal);

		theo_size += count_char("t", to_cal) * 6;
		used = used + count_char("t", to_cal);

		theo_size += count_char("z", to_cal) * 10;
		used = used + count_char("z", to_cal);

		theo_size += count_char("U", to_cal) * 15;
		used = used + count_char("U", to_cal);

		theo_size += count_char("Ü", to_cal) * 15;
		used = used + count_char("Ü", to_cal);

		theo_size += count_char("O", to_cal) * 15;
		used = used + count_char("O", to_cal);

		theo_size += count_char("P", to_cal) * 14;
		used = used + count_char("P", to_cal);

		theo_size += count_char("f", to_cal) * 6;
		used = used + count_char("f", to_cal);

		theo_size += count_char("j", to_cal) * 5;
		used = used + count_char("j", to_cal);

		theo_size += (to_cal.length() - used) * 10.8;
		theo_size += 20;
		return theo_size;
	}

	public void size_anpassung(int theo_size) {

	}

	static int count_char(String to_search, String text) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (String.valueOf(text.charAt(i)).equals(to_search))
				count++;
		}
		return count;
	}

	public void viereck_graph() {
		setSize(new Dimension(x, y));
		setFont(main.setsize(20, this));
		setHorizontalAlignment(JTextField.CENTER);

	}

	public void acion1() {
		int theo_size = the_size_cal(getText());

		if (theo_size > x) {
			setSize(theo_size, y);

		} else {
			setSize(new Dimension(x, y));
		}
		size_anpassung(theo_size);
	}

	public Point[] getPfeilstart() {
		return pfeile_dings;
	}

	public void destroy() {
		
	}
	
	public void action() {
		viereck1 = this;
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenster.canvas.remove(viereck1);
				fenster.canvas.remove(input);
				fenster.canvas.repaint();
				
				// fenster.vier.set(num_in_vier, null);
				for (int i = 0; i < 3; i++) {
					fenster.canvas.remove(pfeilstart[i]);
					if (pfeilstart[i].pfeil_in != -1)
						fenster.pfeile.set(pfeilstart[i].pfeil_in, null);
					pfeilstart[i] = null;
				}
				if (input.last_int != -1)
					fenster.pfeile.set(input.last_int, null);
				input = null;
				viereck1 = null;
				destroy();
			}
		});

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int theo_size = the_size_cal(getText());

				if (theo_size > x) {
					setSize(theo_size, y);

				} else {
					setSize(new Dimension(x, y));
				}
				size_anpassung(theo_size);

			}
		});

		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				grabed = false;
				fenster.canvas.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				grabed = true;
				Point mouse = fenster.getMousePosition();

				offset.x = (mouse.x - getLocation().x);
				offset.y = (mouse.y - getLocation().y);

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					pop.show(e.getComponent(), e.getX(), e.getY());
				}
				start = false;
				fenster.items.build = false;
			}
		});

	}
	
	public ArrayList<JButton> getarrow() {
		ArrayList<JButton> butts = new ArrayList<JButton>();
		butts.add(pfeilstart[0]);
		butts.add(pfeilstart[1]);
		butts.add(pfeilstart[2]);
		butts.add(input);
		return butts;
	}
	
	public void onplaced()
	{
		
	}

}
