package apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.IFachadaSistema;
import negocio.ISistema;
import negocio.produto.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField tfDescricao;
	private JTextField tfCodigo;
	private JButton btnIncluir;
	private JButton btnBuscar;
	private JButton btnCancel;
	private JButton btnExcluir;
	private JButton button_4;
	private JButton btnSair;

	IFachadaSistema fc;
	Produto p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TelaProdutos frame = new TelaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void erro(String msg) {
		JOptionPane.showMessageDialog(this, msg, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public void aviso(String msg) {
		JOptionPane.showMessageDialog(this, msg, "AVISO", JOptionPane.WARNING_MESSAGE);
	}

	public void sucesso(String msg) {
		JOptionPane.showMessageDialog(this, msg, "INFORMACAO", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Create the frame.
	 */
	public TelaProdutos() {

		try {
			fc = ISistema.getFachada();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erro(e.getMessage());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produto");
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCadastroDeProdutos.setBounds(274, 39, 233, 20);
		contentPane.add(lblCadastroDeProdutos);

		tfDescricao = new JTextField();
		tfDescricao.setBounds(186, 142, 258, 29);
		contentPane.add(tfDescricao);
		tfDescricao.setColumns(10);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(83, 146, 69, 20);
		contentPane.add(lblDescricao);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(83, 93, 69, 20);
		contentPane.add(lblCdigo);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(186, 90, 146, 26);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		btnIncluir = new JButton("INCLUIR");

		btnIncluir.setBounds(59, 212, 115, 29);
		contentPane.add(btnIncluir);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(200, 212, 115, 29);
		contentPane.add(btnBuscar);

		btnCancel = new JButton("Cancelar");
		btnCancel.setEnabled(false);
		btnCancel.setBounds(342, 212, 115, 29);
		contentPane.add(btnCancel);

		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(472, 212, 115, 29);
		contentPane.add(btnExcluir);

		button_4 = new JButton("ATUALIZAR");
		button_4.setEnabled(false);
		button_4.setBounds(602, 212, 138, 29);
		contentPane.add(button_4);

		btnSair = new JButton("SAIR");

		btnSair.setBounds(342, 303, 115, 29);
		contentPane.add(btnSair);

		// Incluir
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p = new Produto();
				p.setCodigo(tfCodigo.getText());
				p.setDescricao(tfDescricao.getText());
				try {
					fc.cadastrarProduto(p);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					erro(e.getMessage());
				}
				tfCodigo.setText("");
				tfDescricao.setText("");
			}
		});

		// Buscar
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Produto c = fc.buscarProduto(tfCodigo.getText());
					sucesso(c.getRegistro());
				} catch (Exception e) {

					erro(e.getMessage());
				}
				tfCodigo.setText("");
				tfDescricao.setText("");
			}
		});

		// Excluir
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p = new Produto();
				p.setCodigo(tfCodigo.getText());
				p.setDescricao(tfDescricao.getText());
				try {
					fc.excluirProduto(p);
				} catch (Exception e) {

					erro(e.getMessage());
				}
				tfCodigo.setText("");
				tfDescricao.setText("");
			}
		});

		// Atualizar
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p = new Produto();
				p.setCodigo(tfCodigo.getText());
				p.setDescricao(tfDescricao.getText());
				try {
					fc.atualizarProduto(p);
				} catch (Exception e) {

					erro(e.getMessage());
				}
				tfCodigo.setText("");
				tfDescricao.setText("");
			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aviso("Fim de programa!");
				System.exit(0);
			}
		});
	}
}
