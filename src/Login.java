import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login extends JFrame {
	// private JFrame loginFrame;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */

	public static boolean isMatching(String username, String password, Company company) {
		boolean isMatching = false;
		for (int i = 0; i < company.getCustomerCount(); i++) {
			if ((company.getCustomer(i).getUsername()).equalsIgnoreCase(username)) {
				if ((company.getCustomer(i).getPassword()).equalsIgnoreCase(password)) {
					isMatching = true;
				}
				break;
			}

		}
		return isMatching;

	}
	public static Company company;
	public static Login frame;
	public static int id;

//	public static void main(String[] args) {
//
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//				    frame = new Login();
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
	public Login() {
		setTitle("Login");

		company = new Company();
		///////// kayýtlý olan customerlarý txt dosyasýndan okuma////////////

		try {
			File myObj = new File("customers.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] temp = line.split(";");
				Customer customer = new Customer(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7],
						Integer.parseInt(temp[8]));
				company.addCustomer(customer);
				
				
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		/////////////////////////////////////////////////////////////////////

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;

		// Set the new frame location
		setLocation(x, y);
		setBounds(100, 100, 591, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();

		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(428, 96, 127, 32);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				if (isMatching(username, password, company) == true) {
					ChoiceScreen page = new ChoiceScreen();
					page.setVisible(true);
					setVisible(false);
				} else {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Wrong Password or Username");

				}
			}
		});

		getRootPane().setDefaultButton(btnNewButton);

		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				araba mukremin=new araba();				
//				mukremin.setVisible(true);
//				setVisible(false);

				String username = textField.getText();
				String password = passwordField.getText();
				if (isMatching(username, password, company) == true) {
					ChoiceScreen page = new ChoiceScreen();
					page.setVisible(true);
					setVisible(false);
				} else {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Wrong Password or Username");

				}

			}
		});

		btnNewButton.setBackground(Color.LIGHT_GRAY);
		// btnNewButton.addActionListener(new ActionListener() {

		// });
		btnNewButton.setBounds(450, 204, 86, 25);
		panel.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(428, 161, 129, 32);
		panel.add(passwordField);

		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 400, 350);
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/login.jpg")).getImage()
				.getScaledInstance(400, 350, Image.SCALE_SMOOTH)));
		panel.add(lblNewLabel);

		btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register page = new Register();
				page.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(444, 278, 99, 21);
		panel.add(btnNewButton_1);

		lblNewLabel_1 = new JLabel("Username/Email");
		lblNewLabel_1.setBounds(428, 76, 127, 13);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(428, 144, 63, 13);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Don't have an account?");
		lblNewLabel_3.setBounds(428, 255, 150, 13);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Welcome to the");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(450, 10, 126, 32);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Car Gallery");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(460, 32, 63, 25);
		panel.add(lblNewLabel_5);

	}
}
