import javax.swing.*;


import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class gui_fenster extends JFrame {

	public canvasdings canvas;
	public boolean grabed = false;
	public ArrayList<Viereck> vier = new ArrayList<Viereck>();
	public boolean pfeilsetz = false;
	public boolean pfeiltyp = false;
	public Pfeilstart ob1;
	public Container ob2;
	public ArrayList<pfeil> pfeile = new ArrayList<pfeil>();
	public item_bar items;
	private menu_bar bar;
	private hochrunter hoch;
	private linksrechts links;
	private JPanel canvashint = new JPanel();
	private JTextField posmouse = new JTextField();

	public gui_fenster() {

		fenster();
		mouse();
		action();
		fenster_aus();
		menu_bar bar = new menu_bar(this);

		// new schleifen_ruck_dings(this).primdings(100000);

		update();

	}

	public void fenster() {
		setVisible(true);
		setMinimumSize(new Dimension(900, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(canvashint);
		canvas = new canvasdings(this);
		items = new item_bar(this);
		add(items);
		canvashint.add(canvas);
		setBackground(Color.WHITE);
		setTitle("Algoresent made by Maximilian Fischer");
		setLayout(null);
//		canvashint.setBackground(Color.RED);
		canvas.setEditable(false);
		hoch = new hochrunter(this);
		links = new linksrechts(this);
//		posmouse.setBackground(Color.RED);
		posmouse.setSize(200, 30);
		canvashint.add(posmouse);
		posmouse.setEditable(false);
		posmouse.setBackground(Color.WHITE);
	}

	public void update() {
		while (true) {

			for (int i = 0; i < vier.size(); i++) {
				if (vier.get(i) != null) {
					vier.get(i).gegrabed();
					vier.get(i).onscreen();
					vier.get(i).pos_arrow();
					vier.get(i).notwendig();
				}
			}
			items.not_wendig_update();
			links.notwendig();
			hoch.notwendig();
			mouseanzeigen();
		}

	}

	public void mouseanzeigen() {
		posmouse.setLocation(0, canvashint.getHeight() - posmouse.getHeight() -60);
		try {
			if (posmouse != null && canvas != null && canvas.getLocation() != null)
				posmouse.setText("Mouse (" + (int) (getMousePosition().x - canvas.getLocation().x) +","+(getMousePosition().y - canvas.getLocation().y) +")");
		} catch (Exception e) {
			
		}
	}

	public void action() {

		addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {

			}

			@Override
			public void componentResized(ComponentEvent e) {
				fenster_aus();
			}

			@Override
			public void componentMoved(ComponentEvent e) {

			}

			@Override
			public void componentHidden(ComponentEvent e) {

			}
		});
	}

	public void mouse() {
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

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

	public void fenster_aus() {
		int teile = 6;
		int teil = getSize().width / teile;
		items.setSize(new Dimension(teil, getSize().height));
		if (canvas.getSize().getWidth() < getWidth() - teil || canvas.getSize().height < getSize().height - 35)
			canvas.setSize(new Dimension((getWidth() - teil), getSize().height - 35));
		canvashint.setLocation(teil, 0);
		canvas.set_pos(0, 0);
		canvashint.setSize(teil * 5, getHeight());
	}

	public canvasdings getCanvas() {
		return canvas;
	}

	public void setCanvas(canvasdings canvas) {
		this.canvas = canvas;
	}

	public boolean isGrabed() {
		return grabed;
	}

	public void setGrabed(boolean grabed) {
		this.grabed = grabed;
	}

	public ArrayList<Viereck> getVier() {
		return vier;
	}

	public void setVier(ArrayList<Viereck> vier) {
		this.vier = vier;
	}

	public boolean isPfeilsetz() {
		return pfeilsetz;
	}

	public void setPfeilsetz(boolean pfeilsetz) {
		this.pfeilsetz = pfeilsetz;
	}

	public Pfeilstart getOb1() {
		return ob1;
	}

	public void setOb1(Pfeilstart ob1) {
		this.ob1 = ob1;
	}

	public Container getOb2() {
		return ob2;
	}

	public void setOb2(Container ob2) {
		this.ob2 = ob2;
	}

	public ArrayList<pfeil> getPfeile() {
		return pfeile;
	}

	public void setPfeile(ArrayList<pfeil> pfeile) {
		this.pfeile = pfeile;
	}

	public item_bar getItems() {
		return items;
	}

	public void setItems(item_bar items) {
		this.items = items;
	}

	public void add(menu_bar menu_bar) {

	}

}
