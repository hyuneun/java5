package pack3;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memojang extends JFrame implements ActionListener {
	private JButton btnCopy = new JButton("copy");
	private JButton btnPaste = new JButton("Paste");
	private JButton btnCut = new JButton("Cut");
	private JButton btnDel = new JButton("Del");
	private JButton btnCol = new JButton("Col");
	JPanel pn = new JPanel();
	JTextArea txtMemo = new JTextArea("", 10, 30);
	String copyText;
	String cc = null;

	// 메뉴
	JMenuItem mN, mS, mO, mE;
	JMenuItem mCo, mP, mC, mD;
	JMenuItem mA, mETC, mETC2;

	// 팝업메뉴
	JPopupMenu popM;
	JMenuItem m_white, m_blue, m_yellow;

	public Memojang() {
		super("메모장");

		initLayout();
		menuLayout();

		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initLayout() {
		pn.add(btnCopy);
		pn.add(btnPaste);
		pn.add(btnCut);
		pn.add(btnDel);
		pn.add(btnCol);
		add("North", pn);
		JScrollPane scrollPane = new JScrollPane(txtMemo); // 스크롤바(text가 들어있다)
		add("Center", scrollPane);

		btnCopy.addActionListener(this);
		btnPaste.addActionListener(this);
		btnCut.addActionListener(this);
		btnDel.addActionListener(this);
		btnCol.addActionListener(this);
	}

	private void menuLayout() {
		JMenuBar mb = new JMenuBar(); // 메뉴바

		JMenu mF = new JMenu("파일");// 주메뉴
		mN = new JMenuItem("새로만들기");// 부
		mO = new JMenuItem("열기...");
		mS = new JMenuItem("저장...");
		mE = new JMenuItem("종료");
		mF.add(mN);
		mF.add(mO);
		mF.add(mS);
		mF.addSeparator();// 구분선
		mF.add(mE);

		JMenu med = new JMenu("편집");// 주메뉴
		mCo = new JMenuItem("복사");
		mP = new JMenuItem("붙여넣기");
		mC = new JMenuItem("잘라내기");
		mD = new JMenuItem("삭제");

		med.add(mCo);
		med.add(mP);
		med.add(mC);
		med.add(mD);

		JMenu he = new JMenu("도움말");// 주메뉴
		mA = new JMenuItem("메모장이란");
		he.add(mA);
		JMenu mnetc = new JMenu("기타");
		mETC = new JMenuItem("계산기");
		mETC2 = new JMenuItem("프리셀");
		mnetc.add(mETC);
		mnetc.add(mETC2);
		he.add(mnetc);

		mb.add(he);
		mb.add(med);
		mb.add(mF); // 메뉴바의 주메뉴등록
		setJMenuBar(mb);// frame에 메뉴바 등록

		// 메뉴에 리스너 장착
		mN.addActionListener(this);
		mS.addActionListener(this);
		mO.addActionListener(this);
		mE.addActionListener(this);

		mCo.addActionListener(this);
		mP.addActionListener(this);
		mC.addActionListener(this);
		mD.addActionListener(this);

		mA.addActionListener(this);
		mETC.addActionListener(this);
		mETC2.addActionListener(this);

		// 팝업 메뉴
		popM = new JPopupMenu();
		JMenu m_color = new JMenu("색상선택");
		m_white = new JMenuItem("화이트");
		m_blue = new JMenuItem("블루");
		m_yellow = new JMenuItem("엘로우");
		m_color.add(m_white);
		m_color.add(m_blue);
		m_color.add(m_yellow);
		popM.add(m_color);
		txtMemo.add(popM);// 팝업의 대상지정

		m_white.addActionListener(this);
		m_blue.addActionListener(this);
		m_yellow.addActionListener(this);

		txtMemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {// 오른쪽버튼만 반응
					popM.show(txtMemo, e.getX(), e.getY());// 마우스 xy좌표에 팝업창띄우기
				}
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCopy) || e.getSource() == mCo) {// 소스로비교할수도있고
																	// 액션커맨드로도
																	// 비교할수있다.
			copyText = txtMemo.getSelectedText();// 복사
		} else if (e.getSource().equals(btnPaste) || e.getSource() == mP) {
			int position = txtMemo.getCaretPosition();// 범위를 지정하면 범위만큼을 반환
			txtMemo.insert(copyText, position);
		} else if (e.getSource().equals(btnCut) || e.getSource() == mC) {// 자르기
			copyText = txtMemo.getSelectedText();
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
		} else if (e.getSource().equals(btnDel) || e.getSource() == mD) {// 삭제
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
		} else if (e.getSource().equals(mN)) {// 새로만들기
			txtMemo.setText("");
			setTitle("메모장");
		} else if (e.getSource().equals(mO)) {// 열기
			try {
				FileDialog dia = new FileDialog(this, "저장", FileDialog.LOAD);
				dia.setDirectory(".");// (. - 자기자신)
				dia.setVisible(true);// 경로및 파일명만 얻어옴 저장x
				if (dia.getFile() == null)
					return;
				String dd = dia.getDirectory() + dia.getFile();
				BufferedReader wri = new BufferedReader(new FileReader(dd));
				txtMemo.setText("");
				String line;

				while ((line = wri.readLine()) != null) {
					txtMemo.append(line + "\n");
				}

				wri.close();

				setTitle(dia.getFile() + " 메모장");
			} catch (Exception e2) {
				System.out.println("오류" + e2);
			}
		} else if (e.getSource().equals(mS)) {// 저장
			// 파일 작업을 위한 대화상자 호출
			try {
				FileDialog dia = new FileDialog(this, "저장", FileDialog.SAVE);
				dia.setDirectory(".");// (. - 자기자신)
				dia.setVisible(true);// 경로및 파일명만 얻어옴 저장x
				if (dia.getFile() == null)
					return;
				String dd = dia.getDirectory() + dia.getFile();
				// String dr = "c:/work/good.txt";
				BufferedWriter wri = new BufferedWriter(new FileWriter(dd));
				wri.write(txtMemo.getText());
				cc = txtMemo.getText();
				wri.close();

				setTitle(dia.getFile() + " 메모장");
			} catch (Exception e2) {
				System.out.println("오류" + e2);
			}

		} else if (e.getSource().equals(mE)) {// 종료 종료 종료 종료 종료 종료
			/*
			
			if(txtMemo.getText().equals("")){
				System.exit(0);
			}if else(txtMemo.getText() != ""){
				 	 if(cc.equals(txtMemo.getText())){
				 	 System.exit(0);
				 	 }if(cc != txtMemo.getText()){
				 		int re = JOptionPane.showConfirmDialog(this, "저장안햇어 저장할꺼", "종료", JOptionPane.YES_NO_OPTION);
						switch (re) {
						case JOptionPane.YES_OPTION:
							int re1 = JOptionPane.showConfirmDialog(this, "저장?", "종료", JOptionPane.YES_NO_OPTION);
						case JOptionPane.NO_OPTION:
							return;
						}
				  	}
			
			}*/
			
			

		} else if (e.getSource().equals(mA)) {//
			//JOptionPane.showMessageDialog(this, "메모장메모모장메모장메모장메모장");
			new MemoAbout(this);
		} else if (e.getSource().equals(mETC)) {//
			try {
				Runtime run = Runtime.getRuntime();
				run.exec("calc.exe");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (e.getSource().equals(mETC2)) {
			try {
				Runtime run = Runtime.getRuntime();
				run.exec("FreeCell.exe");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (e.getSource().equals(m_white)) {//
			txtMemo.setBackground(Color.WHITE);
		} else if (e.getSource().equals(m_blue)) {//
			txtMemo.setBackground(Color.BLUE);
		} else if (e.getSource().equals(m_yellow)) {//
			txtMemo.setBackground(Color.YELLOW);
		}

		txtMemo.requestFocus();// 버튼눌러도 포커스유지
	}

	public static void main(String[] args) {
		new Memojang();
	}

}
