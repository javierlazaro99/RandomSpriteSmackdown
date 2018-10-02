package Ventanas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaValidacionUsuarios extends JFrame{

	public VentanaValidacionUsuarios() {
		// TODO Auto-generated constructor stub
		//Ventana 
		setTitle("Usuarios");
		setSize(400, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(0, 1));
		
		//Creacion de contenedores
		JLabel logintexto= new JLabel("Nombre");
		JTextField nombre = new JTextField();
		JLabel passwordtexto = new JLabel("Password");
		JPasswordField password = new JPasswordField();
		JButton confirmar = new JButton("Aceptar");
		
		//Modificaciones
		add(logintexto);
		add(nombre);
		add(passwordtexto);
		add(password);
		add(confirmar);
		//Eventos
		
		
	}
}
