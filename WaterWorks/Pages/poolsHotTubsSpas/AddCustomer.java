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

public class AddCustomer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL",
			"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD",
			"ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
			"NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
			"TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY" };
	JButton addCustomer;
	JButton close;
	JButton deleteFile;
	JLabel custLabel;
	JTextField custTextField;
	JLabel addressLabel;
	JTextField addressTextField;
	JLabel cityLabel;
	JTextField cityTextField;
	JLabel stateLabel;
	JComboBox stateCombo;
	JLabel zipLabel;
	JTextField zipTextField;
	JLabel phoneLabel;
	JTextField phoneTextField;
	JFrame custFrame;
	JPanel custPanel;
	JTextArea messageTextArea;
	public boolean append;

	public AddCustomer() {
		custFrame = new JFrame("Customers");
		custPanel = new JPanel();
		custLabel = new JLabel("Customer Name");
		custTextField = new JTextField(20);
		addressLabel = new JLabel("Address");
		addressTextField = new JTextField(25);
		cityLabel = new JLabel("City");
		cityTextField = new JTextField(35);
		// @SuppressWarnings({ "rawtypes", "unchecked" })
		// stateCombo = new JComboBox(states);
		// stateCombo.setSelectedIndex(0);
		// stateCombo.addActionListener(this);
		zipLabel = new JLabel("ZIP");
		zipTextField = new JTextField(11);
		phoneLabel = new JLabel("Phone");
		phoneTextField = new JTextField(13);

		AddCustomerButtonHandler acHandler = new AddCustomerButtonHandler();
		addCustomer.addActionListener(acHandler);

		CloseButtonHandler cHandler = new CloseButtonHandler();
		close.addActionListener(cHandler);

		DeleteFileButtonHandler dfHandler = new DeleteFileButtonHandler();
		deleteFile.addActionListener(dfHandler);

		addCustomer = new JButton("Add Customer");
		addCustomer.setMnemonic('A');

		close = new JButton("Close");
		close.setMnemonic('C');

		deleteFile = new JButton("Delete File");
		deleteFile.setMnemonic('D');

		messageTextArea = new JTextArea(2, 20);
		messageTextArea.setLineWrap(true);
		messageTextArea.setWrapStyleWord(true);
		messageTextArea.setEditable(false);

		Container c = custFrame.getContentPane();
		c.setLayout(new BorderLayout());
		custPanel.setLayout(new FlowLayout());

		custPanel.add(custLabel);
		custPanel.add(custTextField);
		custPanel.add(addressLabel);
		custPanel.add(addressTextField);
		custPanel.add(cityLabel);
		custPanel.add(cityTextField);
		custPanel.add(stateLabel);
		custPanel.add(stateCombo);
		custPanel.add(zipLabel);
		custPanel.add(zipTextField);
		custPanel.add(phoneLabel);
		custPanel.add(phoneTextField);
		custPanel.add(addCustomer);
		custPanel.add(close);
		custPanel.add(deleteFile);
		c.add(custPanel);
		custFrame.setSize(400, 400);
		custFrame.setVisible(true);
	}

	class AddCustomerButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			FileWriter wc;
			try {
				wc = new FileWriter("customers.txt", append);
				wc.write(custLabel + " " + custTextField.getText() + "\n");
				wc.write(addressLabel + " "
						+ addressTextField.getText().toString() + "\n");
				wc.write(cityLabel + " " + cityTextField.getText() + "\n");
				// wc.write(stateLabel + " " + stateCombo.getSelectedIndex() +
				// "\n");
				wc.write(zipLabel + " " + zipTextField.getText().toString()
						+ "\n");
				wc.write(phoneLabel + " " + phoneTextField.getText().toString());
				wc.close();
				messageTextArea.setText("Customer Added!");
			} catch (IOException e) {
				e.printStackTrace();
				messageTextArea.setText("Customer NOT Added!");
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
				File custFile = new File("customers.txt");
				custFile.delete();
				messageTextArea.setText("The customer file has been deleted!");
			} catch (Exception e) {
				e.printStackTrace();
				messageTextArea.setText("Delete Operation Failed!");
			}
		}
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddCustomer showMe = new AddCustomer();
				showMe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}
