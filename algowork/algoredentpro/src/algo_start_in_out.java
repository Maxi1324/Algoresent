import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class algo_start_in_out extends Viereck {

	private gui_fenster fenster;
	private JDialog dialog;
	String[] input1;
	String[] output1;
	String name;
	private ArrayList<pfeiinout> inputpfeil = new ArrayList<pfeiinout>();
	private ArrayList<pfeiinout> outputpfeil = new ArrayList<pfeiinout>();
	private boolean eins;

	public algo_start_in_out(gui_fenster fenster) {
		super(fenster, 0, false, false, false);
		this.fenster = fenster;
		dialog = new JDialog();
		dialog.setTitle("in_out");
		dialog.setVisible(false);
		setEditable(false);
		setBackground(Color.WHITE);
		setHorizontalAlignment(JTextField.LEFT);
	}

	@Override
	public void notwendig() {
		super.notwendig();

	}

	@Override
	public void onplaced() {
		super.onplaced();
		dialog.setVisible(true);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.setSize(400, 300);
		dialog.setLayout(null);
		dialog();

		fenster.canvas.remove(getarrow().get(3));
	}

	public void dialog() {
		JLabel algo = new JLabel("Alogorithm name", JLabel.CENTER);
		JTextField field = new JTextField("LAL");
		dings(dialog, field, algo, new Dimension(dialog.getWidth() - 20, 50), new Dimension(dialog.getWidth(), 40),
				new Point(5, 45), new Point(5, 5));
		JLabel input = new JLabel("Input Parameter", JLabel.CENTER);
		JTextField inputfield = new JTextField();
		dings(dialog, inputfield, input, new Dimension(dialog.getWidth() / 2 - 10, 50),
				new Dimension(dialog.getWidth() / 2 - 10, 40), new Point(5, 140), new Point(5, 100));
		JLabel output = new JLabel("output Parameter", JLabel.CENTER);
		JTextField outputfield = new JTextField();
		dings(dialog, outputfield, output, new Dimension(dialog.getWidth() / 2 - 23, 50), new Dimension(150, 40),
				new Point(dialog.getWidth() / 2 + 5, 140), new Point(dialog.getWidth() / 2 + 5, 100));
		JButton OKbutt = new JButton("OK");
		OKbutt.setSize(100, 50);
		OKbutt.setLocation(150, 200);
		OKbutt.setBackground(Color.GRAY);
		OKbutt.setForeground(Color.WHITE);
		OKbutt.setFont(main.setsize(20, OKbutt));
		dialog.add(OKbutt);
		OKbutt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auslesen(field, inputfield, outputfield);
				dialog.setVisible(false);
			}
		});
	}

	public void auslesen(JTextField namefield, JTextField input, JTextField output) {

		if (!(input.getText().equals("")))
			input1 = input.getText().split(",");
		if (!output.getText().equals(""))
			output1 = output.getText().split(",");
		name = namefield.getText();
		String str = "";
		int wieweit = Viereck.the_size_cal(name);

		str += name + " (";
		for (int i = 0; input1 != null && i < input1.length; i++) {
			str += input1[i] + "    ";
			inputpfeil.add(new pfeiinout(Viereck.the_size_cal(input1[i]) + wieweit-19));
			wieweit += Viereck.the_size_cal(input1[i]);

		}
		for (int i = 0; output1 != null && i < output1.length; i++) {
			str += output1[i] + "    ";
			outputpfeil.add(new pfeiinout(Viereck.the_size_cal(output1[i]) + wieweit-19));
			wieweit += Viereck.the_size_cal(output1[i]);

		}
		str += ")";
		setText(str);
		acion1();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (eins) {
			Graphics2D g2d = (Graphics2D) g;
			for (int i = 0; inputpfeil.size() > i; i++) {
				pfeilrunter(g2d, inputpfeil.get(i).poszeich);

			}
			for (int i = 0; outputpfeil.size() > i; i++) {
				pfeilrauf(g2d, outputpfeil.get(i).poszeich);
			}
		}
		eins = true;

	}

	public void pfeilrunter(Graphics2D g2d, int pos) {
		g2d.setStroke(new BasicStroke(1));
		g2d.drawLine(pos, 20, pos, 35);
		g2d.fillPolygon(pfeil.dreieck(new Point(pos, 40), 0.5f));
	}
	
	public void pfeilrauf(Graphics2D g2d, int pos) {
		g2d.setStroke(new BasicStroke(1));
		g2d.drawLine(pos, 20, pos,40);
		g2d.fillPolygon(pfeil.dreieck(new Point(pos, 20), -0.5f));
	}

	public void dings(JDialog dialog, JTextField textfield, JLabel label, Dimension dimfield, Dimension dimtext,
			Point posfield, Point postext) {
		JLabel output_text = label;
		output_text.setSize(dimtext);
		output_text.setLocation(postext);
		JTextField output = textfield;
		output.setLocation(posfield);
		output.setSize(dimfield);
		output.setFont(main.setsize(20, textfield));
		dialog.add(output);
		dialog.add(output_text);
	}

}
