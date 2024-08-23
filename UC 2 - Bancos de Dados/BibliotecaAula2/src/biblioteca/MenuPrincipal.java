package biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Bem Vindo ao Sistema Biblioteca");
		lblTitulo.setBounds(204, 43, 375, 32);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		contentPane.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(317, 130, 150, 300);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 5));
		
		JButton btnVerLivros = new JButton("Ver Livros");
		btnVerLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Abrir janela Ver Livros
				
				TelaVerLivros janelaVerLivros = new TelaVerLivros();
				janelaVerLivros.setVisible(true);
				dispose();
			}
		});
		panel.add(btnVerLivros);
		
		JButton btnInserirLivro = new JButton("Inserir Livro");
		btnInserirLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnInserirLivro, "Inserindo Livros");
			}
		});
		panel.add(btnInserirLivro);
		
		JButton btnAlterarLivro = new JButton("Alterar Livro");
		panel.add(btnAlterarLivro);
		btnAlterarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnAlterarLivro, "Alterando Livros");
			}
		});
		
		JButton btnRemoverLivro = new JButton("Remover Livro");
		panel.add(btnRemoverLivro);
		btnRemoverLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnRemoverLivro, "Remover Livros");
			}
		});
		
		JButton btnSair = new JButton("Sair");
		panel.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnSair, "Saindo...");
				System.exit(0);
			}
		});
	}
}
