package biblioteca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVerLivros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnVoltar;
	private JButton btnVerLivro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVerLivros frame = new TelaVerLivros();
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
	public TelaVerLivros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 40, 600, 400);
		contentPane.add(scrollPane);
		
		DefaultTableModel modeloTabela = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Autor", "Gênero", "Editora"
				}
			);
		Conexao con = new Conexao("jdbc:mysql://localhost:3306/bibliotecaapp", "root", "Aluno");
		List<Livro> livros = con.buscarLivros();
		
		for (Livro l : livros) {
			modeloTabela.addRow(new Object[] {l.getIdLivro(), l.getNomeLivro(), l.getAutorLivro(), l.getGeneroLivro(), l.getEditoraLivro()});
		}
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(modeloTabela);
		
		
		scrollPane.setViewportView(table);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal janelaMenuPrincipal = new MenuPrincipal();
				janelaMenuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(141, 480, 128, 50);
		contentPane.add(btnVoltar);
		
		btnVerLivro = new JButton("Ver Livro");
		btnVerLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Livro livro = livros.get(table.getSelectedRow());
			
				JOptionPane.showMessageDialog(scrollPane, livro );
			}
		});
		btnVerLivro.setBounds(523, 480, 128, 50);
		contentPane.add(btnVerLivro);
	}
}
