package pack4;

public class Jikwon {
	int bunho;
	String irum;
	String jumhwa;
	
	public Jikwon(int bunho,String irum,String jumhwa) {
		this.bunho = bunho;
		this.irum = irum;
		this.jumhwa = jumhwa;
	}
	
	@Override
	public String toString() {
		return bunho + " " + irum + " " + jumhwa;
	}
}
