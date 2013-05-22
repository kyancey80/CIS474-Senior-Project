package poolsHotTubsSpas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

class CompanyName extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton setNameButton;

	public JButton getCompanyName(final String name) {
		setNameButton = new JButton();
		setNameButton.setText("Set New Name");
		setNameButton.setMnemonic('S');
		setNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle(name);
			}
		});
		return setNameButton;
	}

	public static void main(String[] args) {
		JFrame frame = new CompanyName();
		frame.setVisible(true);

	}
}
