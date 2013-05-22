package poolsHotTubsSpas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AddContractor extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL",
			"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD",
			"ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
			"NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
			"TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY" };
	JButton addContractor;
	JButton close;
	JButton deleteFile;
	JLabel contLabel;
	JTextField contTextField;
	JLabel addressLabel;
	JTextField addressTextField;
	JLabel cityLabel;
	JTextField cityTextField;
	JLabel stateLabel;
	JLabel zipLabel;
	JTextField zipTextField;
	JLabel phoneLabel;
	JTextField phoneTextField;
	JFrame contFrame;
	JPanel contPanel;
	JTextArea messageTextArea;
	public boolean append;

	public AddContractor() {
		contFrame = new JFrame("contractors");
		contPanel = new JPanel();
		contLabel = new JLabel("contractor Name");
		contTextField = new JTextField(20);
		addressLabel = new JLabel("Address");
		addressTextField = new JTextField(30);
		cityLabel = new JLabel("City");
		cityTextField = new JTextField(35);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox stateCombo = new JComboBox(states);
		stateCombo.setSelectedIndex(0);
		stateCombo.addActionListener(this);
		zipLabel = new JLabel("ZIP");
		zipTextField = new JTextField(11);
		phoneLabel = new JLabel("Phone");
		phoneTextField = new JTextField(13);

		addContractorButtonHandler acHandler = new addContractorButtonHandler();
		addContractor.addActionListener(acHandler);

		CloseButtonHandler cHandler = new CloseButtonHandler();
		close.addActionListener(cHandler);

		DeleteFileButtonHandler dfHandler = new DeleteFileButtonHandler();
		deleteFile.addActionListener(dfHandler);

		addContractor = new JButton("Add contractor");
		addContractor.setMnemonic('A');

		close = new JButton("Close");
		close.setMnemonic('C');

		deleteFile = new JButton("Delete File");
		deleteFile.setMnemonic('D');

		messageTextArea = new JTextArea(30, 2);
		messageTextArea.setLineWrap(true);
		messageTextArea.setWrapStyleWord(true);
		messageTextArea.setEditable(false);

		Container c = contFrame.getContentPane();
		c.setLayout(new BorderLayout());
		contPanel.setLayout(new FlowLayout());

		contPanel.add(contLabel);
		contPanel.add(contTextField);
		contPanel.add(addressLabel);
		contPanel.add(addressTextField);
		contPanel.add(cityLabel);
		contPanel.add(cityTextField);
		contPanel.add(stateLabel);
		contPanel.add(stateCombo);
		contPanel.add(zipLabel);
		contPanel.add(zipTextField);
		contPanel.add(phoneLabel);
		contPanel.add(phoneTextField);
		contPanel.add(addContractor);
		contPanel.add(close);
		contPanel.add(deleteFile);
		c.add(contPanel);
		contFrame.setSize(400, 400);
		contFrame.setVisible(true);
	}

	class addContractorButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			FileWriter wc;
			try {
				wc = new FileWriter("contractors.txt", append);
				wc.write(contLabel + " " + contTextField.getText() + "\n");
				wc.write(addressLabel + " "
						+ addressTextField.getText().toString() + "\n");
				wc.write(cityLabel + " " + cityTextField.getText() + "\n");
				// wc.write(stateLabel + " " + stateCombo.getSelectedIndex() +
				// "\n");
				wc.write(zipLabel + " " + zipTextField.getText().toString()
						+ "\n");
				wc.write(phoneLabel + " " + phoneTextField.getText().toString());
				wc.close();
				messageTextArea.setText("contractor Added!");
			} catch (IOException e) {
				e.printStackTrace();
				messageTextArea.setText("contractor NOT Added!");
			}
		}
	}

	class CloseButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent c) {
			System.exit(0);
		}
	}

	class DeleteFileButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent d) {
			try {
				File contFile = new File("contractors.txt");
				contFile.delete();
				messageTextArea
						.setText("The contractor file has been deleted!");
			} catch (Exception e) {
				e.printStackTrace();
				messageTextArea.setText("Delete Operation Failed!");
			}
		}
	}

	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
