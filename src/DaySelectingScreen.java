import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;

public class DaySelectingScreen extends JFrame {

	private JPanel contentPane;

	public DaySelectingScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How Many Days You Will Be Renting This Car");
		lblNewLabel.setBounds(10, 27, 287, 40);
		contentPane.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setToolTipText("");
		spinner.setBounds(104, 76, 98, 31);
		contentPane.add(spinner);
	}
}
