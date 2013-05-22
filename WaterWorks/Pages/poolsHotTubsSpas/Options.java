package poolsHotTubsSpas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Options extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nameLabel;
	JTextField nameTextField;

	public Options() {
		nameLabel = new JLabel();
		nameLabel.setText("Change Company Name:");
		nameTextField = new JTextField(20);
		nameTextField.setEditable(true);
		nameTextField.setVisible(true);

		CompanyName setNameButton = new CompanyName();
		ExitButton eButton = new ExitButton();

		this.add(nameLabel);
		this.add(nameTextField);
		this.add(setNameButton.getCompanyName(nameTextField.getText()
				.toString()));
		this.add(eButton.getExitButton());

	}

	public void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
