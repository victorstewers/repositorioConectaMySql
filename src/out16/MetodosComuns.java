package out16;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MetodosComuns {
	public String lerHora() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		java.util.Date date = new java.util.Date();
		return dateFormat.format(date);
	}

	public String lerData() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = new java.util.Date();
		return dateFormat.format(date);
	}
	public static void main(String[] args) {
		MetodosComuns novo = new MetodosComuns();
		System.out.println(novo.lerHora() +"  "+ novo.lerData());
	}
}