package poolsHotTubsSpas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.*;

public class Contractors extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea contractorTextArea;
	JButton refresh;
	JTextArea messageArea;
	JButton contractor;

	public Contractors() {
		contractorTextArea = new JTextArea(10, 20);
		contractorTextArea.setLineWrap(true);
		contractorTextArea.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(contractorTextArea);
		messageArea = new JTextArea(2, 20);
		messageArea.setBorder(null);
		try {
			BufferedReader cta = new BufferedReader(new FileReader(
					"contractors.txt"));
			FileInputStream fis = new FileInputStream("contractors.txt");
			while (fis.read() != -1) {
				contractorTextArea.setText(cta.readLine());
			}
			cta.close();
			fis.close();
		} catch (IOException e) {
			e.getMessage();
			messageArea.setText("contractors file has not been created yet!");
			contractorTextArea
					.setText("Select Add contractor to add contractors. Select Refresh to"
							+ "refresh this pane.");
		}

		ExitButton eButton = new ExitButton();
		contractor = new JButton("Add contractor");
		contractor.setMnemonic('A');
		contractor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				new AddContractor();
			}
		});

		refresh = new JButton("Refresh");
		refresh.setMnemonic('R');
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				BufferedReader fresh;
				try {
					fresh = new BufferedReader(
							new FileReader("contractors.txt"));
					contractorTextArea.append(fresh.readLine());
					fresh.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		this.add(contractorTextArea);
		this.add(eButton.getExitButton());
		this.add(contractor);
		this.add(refresh);
		this.add(messageArea);
	}

}
