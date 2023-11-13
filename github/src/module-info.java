//package genomgångar;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*; //stjärnan betyder att man importar alla java utils i swing
//
//public class Grafik4 extends JFrame{ //måste heta Grafik4 eftersom det är det konstruktionen heter
//
//	JButton b1=new JButton("Knapp1"); //lägger till knapp så att den finns att kalla på
//	JButton b2=new JButton("Knapp2"); //lägger till knapp så att den finns att kalla på
//	JLabel	l1=new JLabel("inget");	  //lägger till label så att den finns att kalla på
//
//
//	public Grafik4(){ //måste heta Grafik4 eftersom det är det konstruktionen heter
//		setLayout(new FlowLayout()); //???
//		setVisible(true); //måste finnas för att rutan ska kunna ses
//		setSize(400,400); //storleken på fönstret
//		add(b1); //lägger till knappen i ruttan
//		add(b2); //lägger till knappen i ruttan
//		add(l1); //lägger till labeln i ruttan
//		b1.addActionListener(e->{	//e->är samma sak som half-life2 och är allt vad Grafik3 hade i sin
//			l1.setText("cringe"); //ändrar texten i l1 till cringe
//		});
//		b2.addActionListener(e->{	//e->är samma sak som half-life2 och är allt vad Grafik3 hade i sin
//			l1.setText("cronge"); //ändrar texten i l1 till cronge
//		});
//
//	}
//
//
//
//	public static void main(String[] args) { //standard main metodenz
//		new Grafik4(); //lägger till en konstuktion vid namn Grafik4
//	}
//
//}
