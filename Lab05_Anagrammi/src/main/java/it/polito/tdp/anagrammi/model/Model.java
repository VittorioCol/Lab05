package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Model {
	DizionarioDAO dao;
	List<String> dizionario;
	List<String> finale;
	String iniziale;
	public Model() {
		dao= new DizionarioDAO();
		dizionario=dao.getDizionario();
	}
	public List<String> faiAnagramma(String parola){
		finale=new ArrayList<String>();
		this.cerca(parola, 0,"");
		return finale;
	}
	
	public void cerca(String parola, int livello, String parziale) {
		if(0==parola.length()) {
			finale.add(parziale);
			return;
		}
		for(int i=0;i<parola.length();i++) {
			char tentativo=parola.charAt(i);
			String nuovoParziale=parziale+tentativo;
			String nuovaParola= parola.substring(0, i)+parola.substring(i+1);
			cerca(nuovaParola,livello+1,nuovoParziale);
		}
	}
	public List<String> paroleGiuste(List<String> parole) {
		List<String> words=new ArrayList<>();
		for(String s:parole) {
			if(this.dizionario.contains(s)) {
				words.add(s);
			}
		}
		return words;
	}
	public List<String> paroleErrate(List<String> parole) {
		List<String> words=new ArrayList<>();
		for(String s:parole) {
			if(!this.dizionario.contains(s)) {
				words.add(s);
			}
		}
		return words;
	}
}
