package pack1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LayoutTest extends Frame implements ActionListener{
	private Panel pn1 = new Panel();
	private Panel pn2 = new Panel();
	private Panel pn3 = new Panel();
	private Panel pn4 = new Panel();
	private Panel pn5 = new Panel();
	private Panel pn6 = new Panel();
	private Button btnGo;
	private TextField txtBun,txtIrum;
	private CardLayout card = new CardLayout();//카드형(창을겹친다)
	
	
	
	public LayoutTest() {
		//frame : borderlayout(east, west south, north, center) 이 기본
		setLayout(new GridLayout(2, 1));//frame을 2행 1열 배치형태로 변경
		
		//첫번째 행
		Label lb = new Label("bunho");//메시지전용클래스(컴포넌트)
		txtBun = new TextField("", 20); //키보드로 자료입력용 클래스(컴포넌트)
		
		pn1.add(lb); //panel은 기본이 FLOW LAYOUT(창크기에따라 차례차례배치)(컨테이너)
		pn1.add(txtBun);		
		pn1.setBackground(Color.YELLOW);
		//this.add(pn1);//첫번째 행에 넣기
		
		Label lb2 = new Label("irum");//메시지전용클래스(컴포넌트)
		txtBun = new TextField("", 20); //키보드로 자료입력용 클래스(컴포넌트)
		
		pn2.add(lb2); //panel은 기본이 FLOW LAYOUT(창크기에따라 아래로 차례차례배치)(컨테이너)
		pn2.add(txtBun);	
		pn2.setBackground(Color.RED);
		//this.add(pn2);
		
		pn3.setLayout(card);//FLOW LAYOUT을 카드형으로변경
		pn3.add("aa",pn1);
		pn3.add("bb",pn2);
		//this.add(pn3);
		btnGo = new Button("ok");
		btnGo.addActionListener(this);
		pn4.add(pn3);//FLOW LAYOUT
		pn4.add(btnGo);
		this.add(pn4);
		
		
		
		//두번째 행
		pn6.setLayout(new BorderLayout());
		pn6.setBackground(Color.BLUE);
		pn5.add(new Label("MY NAME IS PN5", Label.CENTER));
		pn6.add("Center", pn5);
		pn6.add("East", new Label("East"));
		pn6.add("West", new Label("West"));
		pn6.add("South", new Label("South", Label.CENTER));
		pn6.add("North", new Label("North", Label.CENTER));
		
		this.add(pn6);
		
		
		
		
		this.setTitle("layout");
		this.setBounds(200, 200, 400, 400);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
		});
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("헤헤헤헤");
		//System.out.println(e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("ok")){//equalsIgnoreCase 대소문자구분x
			btnGo.setLabel("click");
			card.show(pn3,"bb");
		}else{
			btnGo.setLabel("ok");
			card.show(pn3,"aa");
		}
	}
	
	
	
	public static void main(String[] args) {
		new LayoutTest();
		
	}

}
