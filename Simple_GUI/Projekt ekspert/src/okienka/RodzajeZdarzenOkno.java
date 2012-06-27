package okienka;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RodzajeZdarzenOkno extends JDialog implements ActionListener {

	private int kat;
	private int rodzaj;
	private int wplyw;
	private int prawdop;
	
	private OknoGlowne okno;

	private String[] zdarzenia = new String[10];
	private JLabel tytulLabel = new JLabel("Wybierz rodzaj zdarzenia:");
	private JPanel panel = new JPanel(new BorderLayout(0, 10));
	private JPanel panelButtonow = new JPanel();
	private JButton wyjscieButton = new JButton("Anuluj");
	private JButton OKButton = new JButton("Dodaj");
	private JButton wybierzButton = new JButton("Wybierz");
	private OcenaOkno ocena;

	RodzajeZdarzenOkno(int kategoria, OknoGlowne okn){
		super();
		setTitle("Wybór typu");
		setModal(true);
		kat = kategoria;
		okno = okn;

		setPreferredSize(new Dimension(300, 140));
		setLocation(400, 300);

		switch (kategoria){
		case 1:
			zdarzenia[0] = "Działania nieuprawnione";
			zdarzenia[1] = "Kradzież i oszustwo";
			break;
		case 2:
			zdarzenia[0] = "Kradzież i oszustwo";
			zdarzenia[1] = "Bezpieczeństwo systemów";
			break;
		case 3:
			zdarzenia[0] = "Stosunki pracownicze";
			zdarzenia[1] = "Bezpieczeństwo środowiska pracy";
			zdarzenia[2] = "Podziały i dyskryminacja";
			break;
		case 4:
			zdarzenia[0] = "Obsługa klientów, ujawnianie informacji o klientach, zobowiązania względem klientów";
			zdarzenia[1] = "Niewłaściwe praktyki biznesowe lub rynkowe";
			zdarzenia[2] = "Wady produktów";
			zdarzenia[3] = "Klasyfikacja klienta i ekspozycje";
			zdarzenia[4] = "Usługi doradcze";
			break;
		case 5:
			zdarzenia[0] = "Klęski żywiołowe i inne zdarzenia";
			break;
		case 6:
			zdarzenia[0] = "Systemy";
			break;
		case 7:
			zdarzenia[0] = "Wprowadzanie do systemu, wykonywanie, rozliczanie i obsługa transakcji";
			zdarzenia[1] = "Monitorowanie i sprawozdawczość";
			zdarzenia[2] = "Dokumentacja dotycząca klienta";
			zdarzenia[3] = "Zarządzanie rachunkami klientów";
			zdarzenia[4] = "Uczestnicy procesów nie będący klientami banku";
			zdarzenia[5] = "Sprzedawcy i dostawcy";
			break;
		}

		JComboBox listaTypow = new JComboBox(zdarzenia);
		listaTypow.addActionListener(this);
		wyjscieButton.addActionListener(this);
		OKButton.addActionListener(this);
		wybierzButton.addActionListener(this);

//		tytulLabel.setPreferredSize(new Dimension(50, 50));
		panel.add(tytulLabel, BorderLayout.PAGE_START);
		panel.add(listaTypow, BorderLayout.CENTER);
		
		panelButtonow.setLayout(new BoxLayout(panelButtonow, BoxLayout.X_AXIS));
		panelButtonow.add(wyjscieButton);
		panelButtonow.add(Box.createRigidArea(new Dimension(10, 0)));
		panelButtonow.add(wybierzButton);
		panelButtonow.add(Box.createRigidArea(new Dimension(10, 0)));
		panelButtonow.add(OKButton);

		panel.add(panelButtonow, BorderLayout.PAGE_END);
		
		add(panel);
		pack();
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str == "Anuluj")
			dispose();
		else if (str == "Dodaj"){
			wplyw = ocena.getWplyw();
			prawdop = ocena.getPrawdop();
			okno.listaZdarzen.add(new Zdarzenie(kat, rodzaj+1, wplyw, prawdop));
			dispose();
		}
		else if (str == "Wybierz")
			ocena = new OcenaOkno();
		else{
			JComboBox cb = (JComboBox)e.getSource();
			rodzaj = (int)cb.getSelectedIndex();
		}


	}

}
