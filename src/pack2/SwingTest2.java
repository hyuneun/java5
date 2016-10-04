package pack2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class SwingTest2 extends JFrame implements ActionListener {
	JTextField txtName,txtAge;
	ButtonGroup bg = new ButtonGroup();
	JRadioButton p,m,n,g;
	JLabel result; //異쒕젰李�
	JButton ga,re,ed;
	
	public SwingTest2() {
		
		
		
		layoutInit();
		
		setBounds(200, 200, 500, 500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void layoutInit(){
		getContentPane().setLayout(new GridLayout(5,1));
		//getContentPane().setLayout(new FlowLayout());
		//1�뻾
		JLabel lbl1 = new JLabel("asd",JLabel.LEFT);
		txtName = new JTextField("asd",20);
		JPanel pn1 = new JPanel();
		pn1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn1.add(lbl1);
		pn1.add(txtName);
		add(pn1);
		
		//2�뻾
		txtAge = new JTextField("",20);
		JPanel pn2 = new JPanel();
		pn2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pn2.add(new JLabel("�닽�옄2 : ",JLabel.LEFT));
		pn2.add(txtAge);
		add(pn2);
		
		//3�뻾
		JPanel pn3 = new JPanel();
		pn3.add(new JLabel("�뿰�궛�꽑�깮"));
		pn3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p = new JRadioButton("+",true);
		m = new JRadioButton("-",false);
		n = new JRadioButton("/",false);
		g = new JRadioButton("*",false);
		bg.add(p);
		bg.add(m);
		bg.add(n);
		bg.add(g);
		pn3.add(p);
		pn3.add(m);
		pn3.add(n);
		pn3.add(g);
		add(pn3);
		
		//5�뻾
		result = new JLabel("寃곌낵 : ",JLabel.LEFT);
		add(result);
		
		//4�뻾
		
		ga = new JButton("怨꾩궛");
		ga.addActionListener(this);
		re = new JButton("珥덇린�솕");
		re.addActionListener(this);
		ed = new JButton("醫낅즺");
		ed.addActionListener(this);
		JPanel pn4 = new JPanel();
		pn4.add(ga);
		pn4.add(re);
		pn4.add(ed);
		add(pn4);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//�엯�젰�옄猷� �쑀�슚�꽦 寃��궗
		Object o = e.getSource();
		if(o == ga){
		if(txtName.getText().equals("")){
			result.setText("1�엯�젰");
			txtName.requestFocus();//�룷而ㅼ뒪二쇨린
			return;
		}
		if(txtAge.getText().equals("")){
			result.setText("2�엯�젰");
			txtAge.requestFocus();//�룷而ㅼ뒪二쇨린
			return;
		}
		
		
		//�굹�씠�뿉 ���븳 �닽�옄 �뿬遺� �뙋�떒 : Ascii 肄붾뱶,�젙洹쒗몴�쁽�떇,�뿉�윭(try,catch)瑜쇱씠�슜....
		
			
		
		double nai =0; 
		try {
			nai = Integer.parseInt(txtName.getText());
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "硫띿껌�씠");
			txtAge.requestFocus();
			return;
		}
		double nai2 =0; 
		try {
			nai2 = Integer.parseInt(txtAge.getText());
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "硫띿껌�씠");
			txtName.requestFocus();
			return;
		}
		//System.out.println(m.isSelected() + " " + w.isSelected());
		double res = 0;
		String gg = null;
		if(p.isSelected()){
			res = nai + nai2;
			gg = " + ";
		}else if(m.isSelected()){
			res = nai - nai2;
			gg = " - ";
		}else if(n.isSelected()){
			if(nai2 == 0){
				JOptionPane.showMessageDialog(this, "0�쑝濡쒕굹�닃�닔�뾾�떎");
				txtAge.requestFocus();
				return;
			}else{
			res = nai / nai2;
			gg = " / ";
			}
		}else if(g.isSelected()){
			res = nai * nai2;
			gg = " * ";
		}
		
		String ss = "寃곌낵 : " + nai + gg + nai2 + " = " + res;
		result.setText(ss);
	}
	else if(o == re){
		txtName.setText("");
		txtAge.setText("");
		result.setText("");
		bg.clearSelection();
		
	}else if(o == ed){
		int re = JOptionPane.showConfirmDialog(this, "醫낅즺�븷源뚯슂?","�꽑�깮", JOptionPane.YES_NO_OPTION);
		switch (re) {
		case JOptionPane.YES_OPTION:
			System.exit(0);
		case JOptionPane.NO_OPTION:
			return;
		}
	}
	}
	public static void main(String[] args) {
		new SwingTest2();
	}

}
