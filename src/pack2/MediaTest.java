package pack2;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class MediaTest {
	public void aa() {
		File bgm;
		AudioInputStream stream;
		//AudioInputStream : 오디오형식,길이가 지정된 입력 스트림. 바이트단위 처리 
		AudioFormat format;
		//AudioFormat : 사운드 스트림 내에서 데이터의 특징배열을 지정
		DataLine.Info info;
		//DataLine : 미디어 관련 기능 제공
		Clip clip;
		//clip : 사운드재생 전에 로드되는 특수한 종류의 dataline을 표현
		bgm = new File("c:/work/sori/eat.wav");
		
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
					format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			System.out.println("에러" + e);
		}
	}

	public static void main(String[] args) {
		MediaTest test = new MediaTest();
		while(true){
			try {
				test.aa();
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
