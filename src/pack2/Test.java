package pack2;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Test extends JFrame implements ActionListener {
	JTextField txtName,txtAge;
	ButtonGroup bg = new ButtonGroup();
	JRadioButton m,w;
	JLabel result; //출력창
	Image image;
	public Test() {
		super("스윙연습");
		
		layoutInit();
		
		setBounds(200, 200, 300, 300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void layoutInit(){
		getContentPane().setLayout(new GridLayout(5,1));
		
		//1행
		JLabel lbl1 = new JLabel("이름 : ");
		txtName = new JTextField("",20);
		JPanel pn1 = new JPanel();
		pn1.add(lbl1);
		pn1.add(txtName);
		add(pn1);
		
		//2행
		txtAge = new JTextField("",20);
		JPanel pn2 = new JPanel();
		pn2.add(new JLabel("나이 : "));
		pn2.add(txtAge);
		add(pn2);
		
		//3행
		m = new JRadioButton("남자",true);
		w = new JRadioButton("여자",false);
		bg.add(m);
		bg.add(w);
		JPanel pn3 = new JPanel();
		pn3.add(m);
		pn3.add(w);
		add(pn3);
		
		//4행
		JButton ok = new JButton("확인");
		ok.addActionListener(this);
		JPanel pn4 = new JPanel();
		pn4.add(ok);
		add(pn4);		
		//5행
		result = new JLabel("결과 : ",JLabel.CENTER);
		add(result);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//입력자료 유효성 검사
		if(txtName.getText().equals("")){
			result.setText("이름입력");
			txtName.requestFocus();//포커스주기
			return;
		}
		if(txtAge.getText().equals("")){
			result.setText("니이입력");
			txtAge.requestFocus();//포커스주기
			return;
		}
		
		//나이에 대한 숫자 여부 판단 : Ascii 코드,정규표현식,에러(try,catch)를이용....
		int nai =0; 
		try {
			nai = Integer.parseInt(txtAge.getText());
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "멍청이");
			txtAge.requestFocus();
			return;
		}
		
		//System.out.println(m.isSelected() + " " + w.isSelected());
		String gen = "";
		if(m.isSelected()){
			gen = "남";
		}else{
			gen = "여";
		}
		String ss = "결과 : " + txtName.getText() + "님의 나이는 " + nai +"성별은" + gen;
		result.setText(ss);
	}
	
	@Override
	public void paint(Graphics arg0) {
		image = Toolkit.getDefaultToolkit().getImage("c:/work/bookimage/book1.jpg");
		
		arg0.drawImage(image, 100, 100, 200, 200, result);
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
