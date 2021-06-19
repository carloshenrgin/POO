package apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.IFachadaSistema;
import negocio.ISistema;
import negocio.fornecedor.Fornecedor;
import negocio.fornecedor.FornecedorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaFornecedores extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCPF;
	IFachadaSistema fc;
	negocio.fornecedor.Fornecedor c;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedores frame = new TelaFornecedores();
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
	public TelaFornecedores() {
		try {
			fc = ISistema.getFachada();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erro(e.getMessage());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeFornecedores = new JLabel("Cadastro de Fornecedores");
		lblCadastroDeFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeFornecedores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastroDeFornecedores.setBounds(275, 31, 213, 20);
		contentPane.add(lblCadastroDeFornecedores);
		
		JLabel lblNome = new JLabel("Nome..:");
		lblNome.setBounds(78, 140, 69, 20);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF.....:");
		lblCpf.setBounds(78, 101, 69, 20);
		contentPane.add(lblCpf);
		
		tfNome = new JTextField();
		tfNome.setBounds(154, 137, 314, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(154, 98, 173, 26);
		contentPane.add(tfCPF);
		tfCPF.setColumns(10);
		
		JButton btnIncluir = new JButton("INCLUIR");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Fornecedor c = new Fornecedor();
					c.setCPF(tfCPF.getText());
					c.setNome(tfNome.getText());
					
					try {
						fc.cadastrar(c);
						sucesso("Fornecedor " + c.getNome() + " cadastrado com sucesso!!");
						tfCPF.setText("");
						tfNome.setText("");
						
					} catch (Exception e1) {
						erro(e1.getMessage());
					}
			}
		});
		btnIncluir.setBounds(54, 229, 115, 29);
		contentPane.add(btnIncluir);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(467, 229, 115, 29);
		contentPane.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(597, 229, 138, 29);
		contentPane.add(btnAtualizar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(337, 320, 115, 29);
		contentPane.add(btnSair);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(195, 229, 115, 29);
		contentPane.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(337, 229, 115, 29);
		contentPane.add(btnCancelar);
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setCPF(tfCPF.getText());
				c.setNome(tfNome.getText());
				try {
					fc.atualizar(c);
					sucesso("Fornecedor " + c.getNome() + " atualzado com sucesso!!");
					btnAtualizar.setEnabled(false);
					btnExcluir.setEnabled(false);
					tfCPF.setEditable(true);
					tfNome.setEditable(true);
					tfCPF.setText("");
					tfNome.setText("");
					btnCancelar.setEnabled(false);
					btnIncluir.setEnabled(true);
				} catch (Exception e1) {
					erro(e1.getMessage());
				}
		
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fc.excluir(tfCPF.getText());
					sucesso("Fornecedor "+tfCPF.getText()+" excluido com sucesso!!");
					btnAtualizar.setEnabled(false);
					btnExcluir.setEnabled(false);
					tfCPF.setEditable(true);
					tfNome.setEditable(true);
					tfCPF.setText("");
					tfNome.setText("");
					btnCancelar.setEnabled(false);
					btnIncluir.setEnabled(true);
				} catch (Exception e1) {
					erro(e1.getMessage());
				}
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c = fc.buscar(tfCPF.getText());
					tfNome.setText(c.getNome());
					tfCPF.setEditable(false);
					tfNome.setEditable(true);
					btnAtualizar.setEnabled(true);
					btnExcluir.setEnabled(true);
					btnCancelar.setEnabled(true);
					btnIncluir.setEnabled(false);
				} catch (Exception e1) {
					erro(e1.getMessage());
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAtualizar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnIncluir.setEnabled(true);
				tfCPF.setEditable(true);
				tfNome.setEditable(true);
				tfCPF.setText("");
				tfNome.setText("");
				btnCancelar.setEnabled(false);
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	public void erro(String msg){
		JOptionPane.showMessageDialog(this, msg,"ERRO",JOptionPane.ERROR_MESSAGE);
	}

	public void aviso(String msg){
		JOptionPane.showMessageDialog(this, msg,"AVISO",JOptionPane.WARNING_MESSAGE);
	}
	
	public void sucesso(String msg){
		JOptionPane.showMessageDialog(this, msg,"INFORMACAO",JOptionPane.INFORMATION_MESSAGE);
	}

}
