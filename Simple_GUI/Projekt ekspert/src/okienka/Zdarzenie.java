package okienka;

public class Zdarzenie {
	public int kategoria;
	public int rodzaj;
	public int wplyw;
	public int prawdopodobienstwo;
	
	Zdarzenie(){
		kategoria = 0;
		rodzaj = 0;
		wplyw = 0;
		prawdopodobienstwo = 0;
	}
	
	Zdarzenie(int kat, int rodz, int wpl, int prawd){
		kategoria = kat;
		rodzaj = rodz;
		wplyw = wpl;
		prawdopodobienstwo = prawd;
	}

	@Override
	public String toString() {
		return "Zdarzenie [kategoria=" + kategoria + ", rodzaj=" + rodzaj + ", wplyw=" + wplyw + ", prawdopodobienstwo=" + prawdopodobienstwo  +  "]";
	}

}
