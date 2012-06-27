package okienka;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OcenaOkno extends JDialog implements ActionListener {
	
	private JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
	private JRadioButton wplyw1Button = new JRadioButton("1" , true);
	private JRadioButton wplyw2Button = new JRadioButton("2" , false);
	private JRadioButton wplyw3Button = new JRadioButton("3", false);
	private ButtonGroup wplywGroup = new ButtonGroup();
	
	private JRadioButton ptwo1Button = new JRadioButton("1" , true);
	private JRadioButton ptwo2Button = new JRadioButton("2" , false);
	private JRadioButton ptwo3Button = new JRadioButton("3", false);
	ButtonGroup ptwoGroup = new ButtonGroup();
	
	private JButton okButton = new JButton("OK");

	OcenaOkno(){
		super();
		setTitle("Ocena zdarzenia");
		setModal(true);
		setPreferredSize(new Dimension(300, 200));
		setLocation(400, 300);
		
		wplywGroup.add(wplyw1Button);
		wplywGroup.add(wplyw2Button);
		wplywGroup.add(wplyw3Button);

		JPanel wplywRadioPanel = new JPanel();
		wplywRadioPanel.setLayout(new GridLayout(1, 3));
		wplywRadioPanel.add(wplyw1Button);
		wplywRadioPanel.add(wplyw2Button);
		wplywRadioPanel.add(wplyw3Button);

		wplywRadioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Wpływ"));

		ptwoGroup.add(ptwo1Button);
		ptwoGroup.add(ptwo2Button);
		ptwoGroup.add(ptwo3Button);

		JPanel ptwoRadioPanel = new JPanel();
		ptwoRadioPanel.setLayout(new GridLayout(1, 3));
		ptwoRadioPanel.add(ptwo1Button);
		ptwoRadioPanel.add(ptwo2Button);
		ptwoRadioPanel.add(ptwo3Button);

		ptwoRadioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Prawdopodopieństwo"));
		
		panel.add(wplywRadioPanel);
		panel.add(ptwoRadioPanel);
		panel.add(okButton);
		
		okButton.addActionListener(this);
		add(panel);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str == "OK")
			dispose();
	}
	
	public int getWplyw(){
		if (wplyw1Button.isSelected())
			return 1;
		else if(wplyw2Button.isSelected())
			return 2;
		else if(wplyw3Button.isSelected())
			return 3;
		else return 0;
	}
	
	public int getPrawdop(){
		if (ptwo1Button.isSelected())
			return 1;
		else if(ptwo2Button.isSelected())
			return 2;
		else if(ptwo3Button.isSelected())
			return 3;
		else return 0;
	}

}
