package edu.wsu.se;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame implements ActionListener {

	Match match;
	// Left, center, and right panels
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();

	Font bigFont = new Font("Arial", Font.BOLD, 16);

	// On-screen components for panel1
	JLabel gameNumber = new JLabel("Game: ");
	JLabel currentScores = new JLabel("Curent Scores");
	JLabel p1Score = new JLabel("P1: ");
	JLabel p2Score = new JLabel("P2: ");
	JLabel p3Score = new JLabel("P3: ");
	JLabel p4Score = new JLabel("P4: ");

	// On-screen components for panel2
	JLabel playerTurn = new JLabel("Waiting For Network");
	// For the grid of dots
	MyCanvas matrixCanvas = new MyCanvas();

	// On-screen components for panel3
	JLabel thePlayer = new JLabel("Player #");
	JTextArea listOfNum = new JTextArea("Empty Hand");
	JLabel pickNum = new JLabel("Pick a Number");
	@SuppressWarnings("rawtypes")
	JComboBox dropDown = new JComboBox();

	// Create the initial GUI for each player
	public GUI(Match m) {
		super("\"Bored\" Game"); // Frame title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		match = m;

		panel1.setLayout((LayoutManager) new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setBorder(BorderFactory.createEmptyBorder(2, 10, 10, 0));
		gameNumber.setFont(bigFont);
		currentScores.setFont(bigFont);

		panel2.setLayout((LayoutManager) new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.setBorder(BorderFactory.createEmptyBorder(2, 0, 100, 0));
		playerTurn.setFont(bigFont);
		playerTurn.setAlignmentX(CENTER_ALIGNMENT);
		// Wrap the numbers in the player's hand when they reach the edge of the screen
		listOfNum.setLineWrap(true);

		panel3.setLayout((LayoutManager) new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel3.setBorder(BorderFactory.createEmptyBorder(2, 0, 10, 5));
		thePlayer.setAlignmentX(CENTER_ALIGNMENT);

		thePlayer.setFont(bigFont);
		// This is so that the text area isn't bright white
		listOfNum.setBackground(getBackground());

		// 20 numbers to select from
		for (int i = 1; i <= 20; i++) {
			dropDown.addItem(i);
		}

		dropDown.addActionListener(this);

		p1Score.setText("P1: 0");
		p2Score.setText("P2: 0");
		p3Score.setText("P3: 0");
		p4Score.setText("P4: 0");

		// Adds all the components to the first panel
		panel1.add(gameNumber);
		panel1.add(Box.createRigidArea(new Dimension(0, 50)));
		panel1.add(currentScores);
		panel1.add(p1Score);
		panel1.add(p2Score);
		panel1.add(p3Score);
		panel1.add(p4Score);
		panel1.setPreferredSize(new Dimension(200, 500));

		// Adds all the components to the second panel
		panel2.add(playerTurn);
		panel2.add(Box.createRigidArea(new Dimension(0, 50)));
		panel2.add(matrixCanvas);
		panel2.setPreferredSize(new Dimension(350, 500));

		// Adds all the components to the third panel
		panel3.add(thePlayer);
		panel3.add(Box.createRigidArea(new Dimension(0, 50)));
		panel3.add(listOfNum);
		panel3.add(Box.createRigidArea(new Dimension(0, 100)));
		panel3.add(pickNum);
		panel3.add(dropDown);
		panel3.setPreferredSize(new Dimension(250, 500));

		// Panels' position on frame
		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.EAST);
		pack();
	}

	// updates the display after a turn is taken, game finishes, etc.
	public void updateDisplay() {

		if (match.game.getWhoseTurn() == match.netHandler.getMyNumber()) {
			playerTurn.setText("Your Turn!");
		} else {
			playerTurn.setText("Player " + match.game.getWhoseTurn() + "'s Turn");
		}

		matrixCanvas.updateMatrix(match.game.getPlayerMatrix());
		matrixCanvas.repaint();

		int index = match.netHandler.getMyNumber() - 1;
		String s = match.players[index].displayHand();
		try {
			listOfNum.setText(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		gameNumber.setText("Game: " + match.game.gameNumber);

		// update scores
		p1Score.setText("P1: " + match.game.players[0].getScore());
		p2Score.setText("P2: " + match.game.players[1].getScore());
		p3Score.setText("P3: " + match.game.players[2].getScore());
		p4Score.setText("P4: " + match.game.players[3].getScore());

		if (match.game.getWhoseTurn() != match.netHandler.getMyNumber()) {
			dropDown.setEnabled(false);

		} else {
			dropDown.setEnabled(true);
		}
		System.out.println("gui updated");
	}

	// When a player selects a number in the drop-down...
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action happened");
		if (e.getSource() == dropDown) {

			// get the number they chose
			int newNum = (int) dropDown.getSelectedItem();

			if (match.netHandler.isServer()) {
				match.netHandler.broadcast("" + newNum);
			} else {
				match.netHandler.sendToServer("" + newNum);
			}
			// move on to next turn
			match.game.newTurn(match.netHandler.getMyNumber(), newNum);
		}

	}

	public void PROMPT_MESSAGE(String s) {
		dropDown.setEnabled(false);
		JOptionPane.showMessageDialog(this, s, "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean PROMPT_FOR_SERVER() {
		dropDown.setEnabled(false);
		int r = JOptionPane.showConfirmDialog(this, "Are you hosting the game (SERVER)?");
		if (r == JOptionPane.YES_OPTION)
			return true;
		if (r == JOptionPane.CANCEL_OPTION)
			System.exit(0);
		return false;
	}

	public String PROMPT_FOR_IP() {
		dropDown.setEnabled(false);
		String s = JOptionPane.showInputDialog(this, "IP to connect to:");
		if (s == null) {
			return "localhost";
		}
		return s;
	}

	public int PROMPT_FOR_PORT() {
		dropDown.setEnabled(false);
		String s = JOptionPane.showInputDialog(this, "Port to use:");
		if (s == null) {
			return 25565;
		}
		return Integer.parseInt(s);
	}

	public int PROMPT_FOR_NUM_GAMES() {
		dropDown.setEnabled(false);
		String s = JOptionPane.showInputDialog(this, "Number of games in a match (1-10): ");
		if (s == null) {
			return 10;
		}
		int i = 10;
		try {
			i = Integer.parseInt(s);
			if(i < 1 || i > 10)
				i = 10;
		} catch (Exception e) {
			System.out.println("Input not understood or not in range. Defaulting to 10 games");
			i = 10;
		}
		return i;
	}

	public void TITLE_MESSAGE(String s) {
		dropDown.setEnabled(false);
		playerTurn.setText(s);
	}

	@SuppressWarnings("serial")
	public class MyCanvas extends Canvas {

		boolean[][] matrix = null;

		public MyCanvas(boolean[][] m) {
			this.matrix = m;
			setSize(250, 250);
		}

		public MyCanvas() {
			this(new boolean[4][4]);
		}

		public void updateMatrix(boolean[][] m) {
			this.matrix = m;
		}

		public void paint(Graphics g) {
			// render player text
			g.setColor(Color.black);
			for (int i = 0; i < 4; i++) {

				// render player column text
				g.drawString("P" + (i + 1), 100 + (50 * i), 25); // horizontal
				g.drawString("P" + (i + 1), 50, 70 + (50 * i)); // vertical
			}

			for (int y = 0; y < 4; y++) {
				for (int x = 0; x < 4; x++) {
					// render grid
					g.setColor(Color.black);
					g.drawRect((int) (95.0 - (25.0 / 2.0)) + (50 * x), (int) (50.0 - (25.0 / 2.0)) + (50 * y), 50, 50);
					// render colored ovals
					if (matrix[y][x])
						g.setColor(Color.green);
					else
						g.setColor(Color.red);
					g.fillOval(95 + (50 * x), 50 + (50 * y), 25, 25);
				}
			}
		}
	}
}