package pack1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventTest extends Frame implements ActionListener {
	private Button btn1 = new Button("Button1");
	private Button btn2 = new Button("Button2");
	private Button btn3 = new Button("Button3");
	private Button btn4 = new Button("Button4");
	private Button btn5 = new Button("Button5");

	public EventTest() {
		this.setTitle("layout");
		this.setBounds(200, 200, 400, 400);
		this.setVisible(true);

		addWindowListener(new WindowAdapter() {// 내부무명클래스 사용하여 이벤트처리
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		addComponent();
	}

	private void addComponent() {
		add("East", btn1);
		add("West", btn2);
		add("Center", btn3);
		add("South", btn4);
		add("North", btn5);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn5.addActionListener(new MyEvent());//내부클래스사용
		btn4.addMouseListener(new YourEvent());//내부클래스사용
		btn3.addMouseListener(new MouseAdapter(){//내부무명클래스 사용
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// implement 리스너 한후 오버라이드하여 이벤트처리
		/*
		 * if(e.getActionCommand().equals("Button1")){ setTitle("버튼 1 클릭");
		 * setBackground(Color.BLUE); }else
		 * if(e.getActionCommand().equals("Button2")){ setTitle("버튼 2 클릭");
		 * setBackground(Color.RED); }
		 */
		if (e.getSource() == btn1) {
			setTitle("버튼 1 클릭");
		} else if (e.getSource().equals(btn2)) {
			setTitle("버튼 2 클릭");
		}
	}

	// 내부클래스사용 - button3
	class MyEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			EventTest.this.setTitle("버튼33333");//여기에서 쓸수없기떄문에 EventTest에서 찾아야한다

		}
	}
	class YourEvent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			EventTest.this.setTitle("버튼444444");
		}
	}
	public static void main(String[] args) {
		new EventTest();

	}

}
