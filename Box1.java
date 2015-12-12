import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Box1 extends JFrame {
	//InstanzVariablen
	private JTextArea textArea;
	private JTextArea textArea1;
	private JButton encrypt;
	private JButton decrypt;
	private JComboBox combo;
	
	//Konstruktor
	public Box1(){
		setLayout(new BorderLayout());
		Box box = Box.createHorizontalBox();
		add(box);
		//ComboBox initialisieren
		combo = new JComboBox();
		combo.addItem("copy");
		combo.addItem("reverse");

		//Komponente initialisieren
		textArea = new JTextArea(5,20);
		textArea1 = new JTextArea(5,20);
		encrypt = new JButton("encrypt");
		decrypt = new JButton("decrypt");

		
		box.add(textArea, BorderLayout.NORTH);
		box.add(textArea1, BorderLayout.CENTER);
		box.add(encrypt, BorderLayout.SOUTH);
		box.add(decrypt, BorderLayout.SOUTH);
		box.add(combo);
		
		textArea.setBorder(new TitledBorder("Original"));
		textArea1.setBorder(new TitledBorder("Encyrpted"));

		//ActionListener für "copy"
		encrypt.addActionListener(e->{
			if(combo.getSelectedItem()=="copy"){
				copy();
			}
			else if(combo.getSelectedItem()=="reverse"){
				reverse();
			}
			
		});
		
		//ActionListener für "reverse"
		decrypt.addActionListener(e->{
			if(combo.getSelectedItem()=="copy"){
				decryptForCopy();
			}
			else if(combo.getSelectedItem()=="reverse"){
				decryptForReverse();
			}
			
		});
		
		//GUI
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Encryption & Decryption");
	}
		//Main
	public static void main (String [] args){
		new Box1();
	}
	
	
	//Copy 
	public void copy(){
		if (textArea.getText()!=null){
			 textArea1.setText(textArea.getText());
			 textArea.setText("");
		}
	}
	//reverse für Copy
	public void decryptForCopy(){
		if (textArea.getText()!=null){
			 textArea.setText(textArea1.getText());
			 textArea1.setText("");
			
		}
	}
	//reverse
	public void reverse(){

			if (textArea.getText()!=null){
				
				String string = textArea.getText();
				String reverse = new StringBuffer(string).reverse().toString();

				 textArea1.setText(reverse);
				 textArea.setText("");	
			}
		}
	//reverse für reverse
		public void decryptForReverse(){
			if (textArea1.getText()!=null){
				
				String string = textArea1.getText();
				String reverse = new StringBuffer(string).reverse().toString();

				 textArea.setText(reverse);
				 textArea1.setText("");
		}
	}
}
