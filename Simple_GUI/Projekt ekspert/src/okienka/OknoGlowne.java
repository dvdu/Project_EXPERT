package okienka;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OknoGlowne extends JFrame implements ActionListener {
	
	public ArrayList<Zdarzenie> listaZdarzen = new ArrayList<Zdarzenie>();
	
	private JPanel panel = new JPanel(new BorderLayout());
	private JPanel panelDodawania = new JPanel();
	private JPanel panelButtonow = new JPanel();
	private JPanel panelNapisow = new JPanel();
	
	private String eol = System.getProperty("line.separator");  

	private JLabel wybor = new JLabel("Wybierz kategorie zdarzeń:");
	private JLabel kat1 = new JLabel("Oszustwo wewnętrzne");
	private JLabel kat2 = new JLabel("Oszustwo zewnętrzne");
	private JLabel kat3 = new JLabel("Praktyka kadrowa i " + eol + "bezpieczeństwo pracy");
	private JLabel kat4 = new JLabel("Klienci, produkty i praktyka biznesowa");
	private JLabel kat5 = new JLabel("Uszkodzenia aktywów");
	private JLabel kat6 = new JLabel("Zakłócenia działalności i błędy systemów");
	private JLabel kat7 = new JLabel("Dokonywanie transakcji, dostawa oraz zarządzanie procesami");
	
	private JButton dodaj1Button = new JButton("+");
	private JButton dodaj2Button = new JButton("+");
	private JButton dodaj3Button = new JButton("+");
	private JButton dodaj4Button = new JButton("+");
	private JButton dodaj5Button = new JButton("+");
	private JButton dodaj6Button = new JButton("+");
	private JButton dodaj7Button = new JButton("+");
	
	private JButton wyjscieButton = new JButton("WYJŚCIE");
	private JButton przeslijButton = new JButton("PRZEŚLIJ");
	
	OknoGlowne() {
		super("Projekt \"Ekspert\"");
		setPreferredSize(new Dimension(550,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400, 300);
		Dimension napisDim = new Dimension(200, 200);
		Dimension buttonDim = new Dimension(50, 150);
		
		/* DO WYWALENIA W PRZYSZŁOŚCI //////////////////////////////////////////////////*/
		Toolkit tk = Toolkit.getDefaultToolkit();
        URL imageURL = getClass().getResource("images/tux.png");
        setIconImage(tk.createImage(imageURL));
        /* DO WYWALENIA W PRZYSZŁOŚCI //////////////////////////////////////////////////*/
        
		wybor.setPreferredSize(new Dimension(50, 50));
		panel.add(wybor, BorderLayout.PAGE_START);
		
		panelNapisow.setLayout(new BoxLayout(panelNapisow, BoxLayout.Y_AXIS));
		panelDodawania.setLayout(new BoxLayout(panelDodawania, BoxLayout.Y_AXIS));
		panelButtonow.setLayout(new BoxLayout(panelButtonow, BoxLayout.X_AXIS));
		
		kat1.setPreferredSize(napisDim);
		kat2.setPreferredSize(napisDim);
		kat3.setPreferredSize(napisDim);
		kat4.setPreferredSize(napisDim);
		kat5.setPreferredSize(napisDim);
		kat6.setPreferredSize(napisDim);
		kat7.setPreferredSize(napisDim);
		
		dodaj1Button.setPreferredSize(buttonDim);
		dodaj2Button.setPreferredSize(buttonDim);
		dodaj3Button.setPreferredSize(buttonDim);
		dodaj4Button.setPreferredSize(buttonDim);
		dodaj5Button.setPreferredSize(buttonDim);
		dodaj6Button.setPreferredSize(buttonDim);
		dodaj7Button.setPreferredSize(buttonDim);
		
		panelNapisow.add(kat1);
		panelNapisow.add(kat2);
		panelNapisow.add(kat3);
		panelNapisow.add(kat4);
		panelNapisow.add(kat5);
		panelNapisow.add(kat6);
		panelNapisow.add(kat7);
		
		panelDodawania.add(dodaj1Button);
		panelDodawania.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDodawania.add(dodaj2Button);
		panelDodawania.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDodawania.add(dodaj3Button);
		panelDodawania.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDodawania.add(dodaj4Button);
		panelDodawania.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDodawania.add(dodaj5Button);
		panelDodawania.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDodawania.add(dodaj6Button);
		panelDodawania.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDodawania.add(dodaj7Button);

		panelButtonow.add(Box.createRigidArea(new Dimension(10, 0)));
		panelButtonow.add(wyjscieButton);
		panelButtonow.add(Box.createRigidArea(new Dimension(10, 0)));
		panelButtonow.add(przeslijButton);
		
		panel.add(panelNapisow, BorderLayout.CENTER);
		panel.add(panelDodawania, BorderLayout.LINE_END);
		panel.add(panelButtonow, BorderLayout.PAGE_END);


		add(panel);
		pack();
		setVisible(true);
		
		dodaj1Button.addActionListener(this);
		dodaj2Button.addActionListener(this);
		dodaj3Button.addActionListener(this);
		dodaj4Button.addActionListener(this);
		dodaj5Button.addActionListener(this);
		dodaj6Button.addActionListener(this);
		dodaj7Button.addActionListener(this);
		
		wyjscieButton.addActionListener(this);
		przeslijButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton butt = (JButton) e.getSource();
		if (butt == przeslijButton){
	        Iterator<Zdarzenie> it=listaZdarzen.iterator();
	        while(it.hasNext())
	        {
	          System.out.println(it.next());
	        }
		}
		else if (butt == wyjscieButton)
			dispose();
		else if (butt == dodaj1Button)
			new RodzajeZdarzenOkno(1, this);
		else if (butt == dodaj2Button)
			new RodzajeZdarzenOkno(2, this);
		else if (butt == dodaj3Button)
			new RodzajeZdarzenOkno(3, this);
		else if (butt == dodaj4Button)
			new RodzajeZdarzenOkno(4, this);
		else if (butt == dodaj5Button)
			new RodzajeZdarzenOkno(5, this);
		else if (butt == dodaj6Button)
			new RodzajeZdarzenOkno(6, this);
		else if (butt == dodaj7Button)
			new RodzajeZdarzenOkno(7, this);
	}
	
	public static void main(String[] args) {
		new OknoGlowne();
	}	

}
