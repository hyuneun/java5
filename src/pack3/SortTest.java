package pack3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortTest extends JFrame {

	private JPanel contentPane;
	private JTextField textSource;
	int aa;
	
	int arr1[];
	String aaa = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortTest frame = new SortTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SortTest() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("sort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("정렬알고리즘(숫자는 10개이하)");
		lblNewLabel.setBounds(12, 10, 170, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("대상 : ");
		lblNewLabel_1.setBounds(12, 57, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		textSource = new JTextField();
		textSource.setToolTipText("숫자만");
		textSource.setBounds(66, 54, 116, 21);
		contentPane.add(textSource);
		textSource.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("결과 :");
		lblNewLabel_2.setBounds(12, 117, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textTarget = new JTextArea();
		textTarget.setEditable(false);
		textTarget.setBounds(66, 113, 116, 19);
		contentPane.add(textTarget);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC791\uC5C5\uC120\uD0DD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 179, 349, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSelection = new JButton("Selection");
		btnSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] arr = textSource.getText().split("");
				arr1 = new int[arr.length];
					for (int i = 0; i < arr1.length; i++) {
						arr1[i] = Integer.parseInt(arr[i]);
					}
					
				for (int j = 0; j < arr1.length; j++) {
					for (int i = 0; i < arr1.length; i++) {
							
						if(arr1[j] < arr1[i]){
							aa = arr1[j];
							arr1[j] = arr1[i];
							arr1[i] = aa;
							
						}else{
							continue;
						}
					}
					
				}
				for (int i = 0; i < arr1.length; i++) {
					arr[i] = Integer.toString((arr1[i]));
					aaa += arr[i];
				}
				
					textTarget.setText(aaa);
			
			}
		});
		btnSelection.setBounds(6, 17, 97, 23);
		panel.add(btnSelection);
		
		JButton btnBubble = new JButton("Bubble");
		btnBubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] arr = textSource.getText().split("");
				arr1 = new int[arr.length];
					for (int i = 0; i < arr1.length; i++) {
						arr1[i] = Integer.parseInt(arr[i]);
					}
					
						
						/*for (int i = 1; i < arr1.length; i++) {
							for (int j = 0; j < arr1.length-i; j++) {
								
								if(arr1[j] > arr1[j+1]){
									aa = arr1[j+1];
									arr1[j+1] = arr1[j];
									arr1[j] = aa;
									
								}else{
									continue;
								}
								
							}
							
						}*/
						
					
					
					
					
					
					
					for (int i = 0; i < arr1.length; i++) {
						arr[i] = Integer.toString((arr1[i]));
						aaa += arr[i];
					}
					
						textTarget.setText(aaa);
			}
		});
		btnBubble.setBounds(125, 17, 97, 23);
		panel.add(btnBubble);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTarget.setText("");
			}
		});
		btnClear.setBounds(246, 17, 97, 23);
		panel.add(btnClear);
	}
}
