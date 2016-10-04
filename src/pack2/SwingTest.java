package pack2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SwingTest extends JPanel implements ActionListener {
	JButton btnR,btnG,btnB;
	JTextArea txtArea = new JTextArea("",10,50);
	JMenuBar mBar;
	JMenuItem munMes,munOk,munInput;
	
	
	public SwingTest() {
		setLayout(new BorderLayout());
		btnR = new JButton("빨강");
		btnG = new JButton("초록");
		btnB = new JButton("파랑");
		btnR.addActionListener(this);
		btnG.addActionListener(this);
		btnB.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(btnR);
		panel.add(btnG);
		panel.add(btnB);
		
		add("South",panel);
		add("Center",txtArea);
		
		menuProcess();
	}

	public void menuProcess(){
		mBar = new JMenuBar();
		JMenu menu = new JMenu("대화상자"); //메뉴생성및삽입
		munMes = new JMenuItem("메시지창");
		munOk = new JMenuItem("확인창");
		munInput = new JMenuItem("입력창");
		menu.add(munMes);
		menu.add(munOk);
		menu.add(munInput);
		mBar.add(menu);
		
		JMenu menu2 = new JMenu("도움말"); //메뉴2생성및삽입
		JMenuItem munA = new JMenuItem("이프로그램은");
		JMenuItem munB = new JMenuItem("환영");
		menu2.add(munA);
		menu2.add(munB);
		mBar.add(menu2);
		
		munMes.addActionListener(this); //이벤트형성
		munOk.addActionListener(this);
		munInput.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnR){
			txtArea.setBackground(Color.RED);
		}else if(e.getSource() == btnG){
			txtArea.setBackground(Color.GREEN);
		}else if(e.getSource() == btnB){
			txtArea.setBackground(Color.BLUE);
		}else if(e.getSource() == munMes){
			JOptionPane.showMessageDialog(this, "ㅎㅇ", "제못", JOptionPane.INFORMATION_MESSAGE);
			//Modal Dialog - 창닫기전까지 작업x
			System.out.println("수행");
			
		}else if(e.getSource() == munOk){
			int re = JOptionPane.showConfirmDialog(this, "뭔가를선택", "선택", JOptionPane.YES_NO_CANCEL_OPTION);
			switch (re) {
			case JOptionPane.YES_OPTION:
				txtArea.append("예스\n");
				break;
			case JOptionPane.NO_OPTION:
				txtArea.append("노우\n");
				break;
			case JOptionPane.CANCEL_OPTION:
				txtArea.append("취소\n");
				break;
			}		
		}
		
		else if(e.getSource() == munInput){
			String str = JOptionPane.showInputDialog(this,"자료입력");
			txtArea.append(str + "\n");
		}

	}

	public static void main(String[] args) {
			JFrame frame = new JFrame("대화상자연습");
			
			
			
			SwingTest t2 = new SwingTest(); //jpanel
			frame.getContentPane().add(t2, "Center");
			frame.setJMenuBar(t2.mBar);
			frame.setBounds(200, 200, 300, 300);
			frame.setVisible(true);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
	}

}
