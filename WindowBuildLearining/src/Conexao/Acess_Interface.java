package Conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Acess_Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acess_Interface frame = new Acess_Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Acess_Interface() {
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 76, 108, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(26, 134, 108, 24);
		contentPane.add(lblNewLabel_1);
		
		TFuser = new JTextField();
		TFuser.setFont(new Font("Arial", Font.PLAIN, 16));
		TFuser.setBounds(134, 76, 108, 28);
		contentPane.add(TFuser);
		TFuser.setColumns(10);
		
		Senha = new JPasswordField();
		Senha.setFont(new Font("Arial", Font.PLAIN, 16));
		Senha.setBounds(134, 134, 108, 24);
		contentPane.add(Senha);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					Connection con = ConexaoClass.faz_conexao();
					
					String Sql = "select 'from dados where user=? and senha=?";
					
					PreparedStatement pup = con.prepareStatement(Sql);
					pup.setString(1, TFuser.getText());
					pup.setString(2, new String(Senha.getPassword()));
					
					ResultSet Rs = pup.executeQuery();
					
					if (Rs.next()) {
						Cadastro exibir = new Cadastro();
						exibir.isVisible(true);
						
						setVisible(false);
						
					}else {
						JOptionPane.showMessageDialog(null, "Usuário/senha incorreto");
					}
					Rs.close();
					con.close();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(144, 169, 89, 23);
		contentPane.add(btnNewButton);
	}
}
