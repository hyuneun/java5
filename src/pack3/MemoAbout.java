package pack3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MemoAbout extends JDialog implements ActionListener{
	public MemoAbout(JFrame frame) {
		super(frame);
		
		setTitle("메종아리나");
		setModal(true); //modal 뜨는동안 다른작업x
		
		JLabel lb = new JLabel("미니메모장 ver 1.6");
		JButton jb = new JButton("확인");
		jb.addActionListener(this);
		add("Center", lb);
		add("South", jb);
		
		setBackground(Color.DARK_GRAY);
		setBounds(200,200,300,300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); //대화상자닫기
		
	}
}
