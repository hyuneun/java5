package pack4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LamdaEvent extends JFrame {
	public LamdaEvent() {
		super("람다");
		setBounds(200,200,300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} 람다를 쓸수없다(메소드가 많아서..)
		});*/
		
		layInit();
	}
	
	public void layInit(){
		setLayout(null);
		JButton btn = new JButton("버튼1");
		btn.setBounds(10,20,100,50);
		add(btn);
		
		btn.addActionListener(new ActionListener() {//전통적방식
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("안녕하세요");
			}
		});
			
		JButton btn2 = new JButton("버튼2");
		btn2.setBounds(10,80,100,50);
		add(btn2);
		
		btn2.addActionListener(e -> setTitle("반가워"));//람다를썻을떄
	}
	
	public static void main(String[] args) {
		new LamdaEvent();
	}

}
