package pack2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PackMan extends JFrame implements KeyListener {
	Image image,image1;
	int co = 0;
	int x = 0;
	int y = 0;
	int sel = 1;
	int x1,y2;
	
	public void bb(){
		x1 = (int) (Math.random()*290)/10*10;
		y2 = (int) (Math.random()*290)/10*10;
		
	}

	public void aa() {
		File bgm;
		AudioInputStream stream;
		// AudioInputStream : 오디오형식,길이가 지정된 입력 스트림. 바이트단위 처리
		AudioFormat format;
		// AudioFormat : 사운드 스트림 내에서 데이터의 특징배열을 지정
		DataLine.Info info;
		// DataLine : 미디어 관련 기능 제공
		Clip clip;
		// clip : 사운드재생 전에 로드되는 특수한 종류의 dataline을 표현
		bgm = new File("c:/work/sori/beginning.wav");

		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			System.out.println("에러" + e);
		}
	}

	public PackMan() {
		super("점수 : ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack1.jpg"));
		// 이미지는 toolkit사용
		setLayout(null);// null로 줘야 움직인다
		setBounds(200, 200, 300, 300);
		//setBackground(Color.WHITE);
		setVisible(true);
		setResizable(false);// 창크기고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();

		x = (int) getWidth() / 2;
		y = (int) getWidth() / 2;

		
		addKeyListener(this);
		JLabel lbl1 = new JLabel("점수 : ",JLabel.LEFT);
		add(lbl1);
	}
	
	
	@Override
	public void paint(Graphics g) {
		switch (sel) {
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack1.jpg");
			break;
		case 2:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack2.jpg");
			break;
		case 3:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack3.jpg");
			break;
		case 4:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack4.jpg");
			break;
		case 5:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack5.jpg");
			break;
		case 6:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack6.jpg");
			break;
		case 7:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack7.jpg");
			break;
		case 8:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack8.jpg");
			break;
		}
		image1 = Toolkit.getDefaultToolkit().getImage("c:/work/pack/p1.png");
		// image =
		//Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack1.jpg");
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, x - image.getWidth(this) / 2, y - image.getHeight(this) / 2, this);
		g.drawImage(image1, x1, y2, this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// System.out.println(key);

		// 오른쪽 화살표
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
			// System.out.println("right");
			/*
			 * if(sel == 1){ sel = 2; }else{ sel = 1; }
			 */
			sel = (sel == 1) ? 2 : 1; // 삼항연산자

			x = (x < getWidth() ? x += 100 : -image.getWidth(this));

		}
		repaint();
		// 왼쪽 화살표
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {
			// System.out.println("right");
			/*
			 * if(sel == 1){ sel = 2; }else{ sel = 1; }
			 */
			sel = (sel == 3) ? 4 : 3; // 삼항연산자

			x = (x > 0 ? x -= 100 : getWidth());

		}
		repaint();
		// 위 화살표
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {
			// System.out.println("right");
			/*
			 * if(sel == 1){ sel = 2; }else{ sel = 1; }
			 */
			sel = (sel == 7) ? 8 : 7; // 삼항연산자
			y = (y > 0 ? y -= 100 : getWidth());

		}
		repaint();
		// 아래 화살표
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {
			// System.out.println("right");
			/*
			 * if(sel == 1){ sel = 2; }else{ sel = 1; }
			 */
			sel = (sel == 5) ? 6 : 5; // 삼항연산자

			y = (y < getWidth() ? y += 100 : -image.getWidth(this));
		}
		if((x1-30 < x && x <x1+30)&&(y2-30 < y && y < y2+30)){
			repaint();
			bb();
			MediaTest test1 = new MediaTest();
			test1.aa();
			co += 10;
			setTitle("점수는" + co);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new PackMan();
		PackMan test = new PackMan();
		test.bb();//원생성
		test.aa();
		

	}

}
