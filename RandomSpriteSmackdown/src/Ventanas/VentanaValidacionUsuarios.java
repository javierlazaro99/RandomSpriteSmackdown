package Ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Usuarios.UsuariosValidar;

public class VentanaValidacionUsuarios extends JFrame{
	UsuariosValidar usuario;
	public VentanaValidacionUsuarios(int codigo) {
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
		
		confirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean estado ;
				if(codigo == 0) {//Login
					 estado =usuario.leer(nombre, password);
					if(estado==true) {
						//Ventana general
						VentanaPrincipal ventana = new VentanaPrincipal();
						ventana.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Datos erroneos");
					}
				}else {
						estado =usuario.leer(nombre, password);
					if(estado==true) {
						JOptionPane.showMessageDialog(null,"Ya existe un usuario con ese nombre");
						nombre.setText("");
						password.setText("");
					}else {
						VentanaPrincipal ventana = new VentanaPrincipal();
						ventana.setVisible(true);
					}
				}
				
			}
		});
		
	}
	public static void main(String[] args) {
		VentanaValidacionUsuarios ventana = new VentanaValidacionUsuarios(1);
		ventana.setVisible(true);
	}
}
