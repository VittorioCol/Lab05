package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField aggiungi;

    @FXML
    private Button anagrammi;

    @FXML
    private TextArea corrette;

    @FXML
    private TextArea errate;

    @FXML
    private Button reset;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	String parola=aggiungi.getText();
    	List<String> parole=new ArrayList<>();
    	parole=model.faiAnagramma(parola);
    	List<String> pG=model.paroleGiuste(parole);
    	List<String> pE=model.paroleErrate(parole);
    	for(String s:pG) {
    		corrette.appendText(s+"\n");
    	}
    	for(String s:pE) {
    		errate.appendText(s+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	aggiungi.clear();
    	corrette.clear();
    	errate.clear();
    }

    @FXML
    void initialize() {
        assert aggiungi != null : "fx:id=\"aggiungi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert anagrammi != null : "fx:id=\"anagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert corrette != null : "fx:id=\"corrette\" was not injected: check your FXML file 'Scene.fxml'.";
        assert errate != null : "fx:id=\"errate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
	}
}
