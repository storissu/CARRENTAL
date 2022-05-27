

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RentScreen extends JFrame {

	private JPanel contentPane;


	public RentScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 730);
		getContentPane().setLayout(null);
		
		
		

		int x = 0;
		int y = 10;
		for (int i = 0; i < Login.company.getCarCountRent(); i++) {
			if (i != 0 && i % 3 == 0) {
				y += 310;
				x = 0;
			}
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(10 + 310 * x, 20 + y , 300, 307);
			getContentPane().add(panel);
			panel.setLayout(null);
			panel.setName(String.valueOf(Login.company.getCarsForRent().get(i).getId()));

			JLabel lblNewLabel = new JLabel("- - - - " + Login.company.getCarsForRent().get(i).getBrand() + " "
			+ Login.company.getCarsForRent().get(i).getModel()+" - - - -" );
			lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 17));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.ORANGE);
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 10, 280, 23);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Color            :            " + Login.company.getCarsForRent().get(i).getColor());
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(43, 170, 247, 13);
			panel.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Engine         :            " + Login.company.getCarsForRent().get(i).getEngineSize() + "    /   " +
			Login.company.getCarsForRent().get(i).getEngineType());
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(43, 193, 247, 13);
			panel.add(lblNewLabel_2);
			String availability;
			boolean available = true;
			if (Login.company.getCarsForRent().get(i).isAvailable() == true) {
				 availability = "AVAILABLE";
			} else {
				availability = " NOT AVAILABLE";
				available = false;
			}
			JLabel lblNewLabel_3 = new JLabel(availability);
			if (available == true) {
				lblNewLabel_3.setForeground(Color.WHITE);
			} else {
				lblNewLabel_3.setForeground(Color.RED);
			}
			lblNewLabel_3.setBounds(10, 220, 247, 13);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(lblNewLabel_3);
//			//59 85 200 200
//			JLabel lblNewLabel_4 = new JLabel();
//			lblNewLabel_4.setBounds(61, 20, 190,150);
//			lblNewLabel_4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(Login.company.getCarsForRent().get(i).getImage())).getImage()
//					.getScaledInstance(190, 100, Image.SCALE_SMOOTH)));
//
//			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_1_1 = new JLabel(Login.company.getCarsForRent().get(i).getPricePerHour() + " TRY Per Day");
			lblNewLabel_1_1.setDoubleBuffered(true);
			lblNewLabel_1_1.setFont(new Font("Impact", Font.PLAIN, 17));
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(Color.ORANGE);
			lblNewLabel_1_1.setBounds(43, 249, 200, 23);
			panel.add(lblNewLabel_1_1);
			
			JButton btnNewButton = new JButton("R E N T");
            btnNewButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	
                    try {
                        for (int i = 0; i < Login.company.getCarsForRent().size(); i++) {
                            String tempCar = Integer.toString(Login.company.getCarsForRent().get(i).getId());
                            //temp=Login.company.getCarsForSale().get(i)
                            if (panel.getName().equalsIgnoreCase(tempCar)) {
                            	if (Login.company.getCarsForRent().get(i).isAvailable() == false) {
                                	Component frame = null;
                                	JOptionPane.showMessageDialog(frame, "This car has already rented");
            						
            					} else {
            						 Login.company.getCarsForRent().get(i).setAvailable(false);
            						 DaySelectingScreen page = new DaySelectingScreen();
                                     page.setVisible(true);
            						 setVisible(false);
            					}
                             
                            }
                        }

                        FileWriter fileWritter = new FileWriter("carsforrent.txt");
                        BufferedWriter bw = new BufferedWriter(fileWritter);
                        for (int j = 0; j < Login.company.getCarsForRent().size(); j++) {
                            String temp = Login.company.getCarsForRent().get(j).toString();
                            bw.write(temp + "\n");
                        }
                        bw.close();
                    } catch (IOException x) {
                        x.printStackTrace();
                    }
                    

                   

                }
            });
			btnNewButton.setForeground(new Color(255, 248, 220));
			btnNewButton.setBackground(Color.ORANGE);
			btnNewButton.setFont(new Font("Impact", Font.PLAIN, 17));
			btnNewButton.setBounds(61, 272, 166, 28);
			panel.add(btnNewButton);
			
			JLabel lblNewLabel_5 = new JLabel("--------------- Properties ---------------");
			lblNewLabel_5.setForeground(Color.ORANGE);
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(43, 147, 208, 13);
			panel.add(lblNewLabel_5);
			x++;


	}
	}

}
