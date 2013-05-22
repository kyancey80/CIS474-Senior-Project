package poolsHotTubsSpas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class General extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel todaysDate;
	JLabel dateLabel;

	public General() {
		dateLabel = new JLabel();
		dateLabel.setText("Today's Date: ");

		DateFormat today = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		todaysDate = new JLabel();
		todaysDate.setText(today.format(date));

		ExitButton eButton = new ExitButton();

		this.add(dateLabel);
		this.add(todaysDate);
		this.add(eButton.getExitButton());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
