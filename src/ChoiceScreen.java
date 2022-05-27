import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChoiceScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChoiceScreen frame = new ChoiceScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ChoiceScreen() {

		try {
			File myObj = new File("carsforrent.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] temp = line.split(";");
				// id brand model color year enginetype enginesize  km isAvailable  price image
				
				CarForRent rent = new CarForRent(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6],
						Boolean.parseBoolean(temp[7]),temp[8],temp[9]);
				Login.company.addCarForRent(rent);

			}
			myReader.close();
		} catch (FileNotFoundException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}
		
		try {
			File myObj = new File("carsforsale.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] temp = line.split(";");
				// id brand model color year enginetype enginesize image km isused issold price
				CarForSale sale = new CarForSale(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5],
						temp[6], temp[7], Boolean.parseBoolean(temp[8]),temp[9], Boolean.parseBoolean(temp[10]),
						temp[11]);
				Login.company.addCarForSale(sale);

			}
			myReader.close();
		} catch (FileNotFoundException e1) {
			System.out.println("An error occurred.");
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Car To Rent");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RentScreen page = new RentScreen();
				page.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(80, 48, 168, 27);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Car To Buy");


		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SaleScreen page = new SaleScreen();
				page.setVisible(true);
				setVisible(false);

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(80, 85, 168, 27);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("What Are You Looking For?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(93, 17, 168, 21);
		contentPane.add(lblNewLabel);
	}
}
