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

public class Customers extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea customerTextArea;
	JButton refresh;
	JTextArea messageArea;
	JButton customer;

	public Customers() {
		customerTextArea = new JTextArea(10, 20);
		customerTextArea.setLineWrap(true);
		customerTextArea.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(customerTextArea);
		messageArea = new JTextArea(2, 20);
		messageArea.setBorder(null);
		try {
			BufferedReader cta = new BufferedReader(new FileReader(
					"customers.txt"));
			FileInputStream fis = new FileInputStream("customers.txt");
			while (fis.read() != -1) {
				customerTextArea.setText(cta.readLine());
			}
			cta.close();
			fis.close();
		} catch (IOException e) {
			e.getMessage();
			messageArea.setText("Customers file has not been created yet!");
			customerTextArea
					.setText("Select Add Customer to add customers. Select Refresh to"
							+ "refresh this pane.");
		}

		ExitButton eButton = new ExitButton();
		customer = new JButton("Add Customer");
		customer.setMnemonic('A');
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				AddCustomer add = new AddCustomer();
			}
		});

		refresh = new JButton("Refresh");
		refresh.setMnemonic('R');
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				BufferedReader fresh;
				try {
					fresh = new BufferedReader(new FileReader("customers.txt"));
					customerTextArea.append(fresh.readLine());
					fresh.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		this.add(customerTextArea);
		this.add(eButton.getExitButton());
		this.add(customer);
		this.add(refresh);
		this.add(messageArea);
	}

}
