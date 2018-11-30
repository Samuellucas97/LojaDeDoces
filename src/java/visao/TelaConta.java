package visao;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ClienteDAO;
import controle.ContaDAO;
import modelo.Cliente;
import modelo.Conta;

public class TelaConta extends JInternalFrame implements ActionListener{
	
	ContaDAO ctDao;
	ClienteDAO cDao;
	
	// rótulos
	JLabel lcliente   = new JLabel("Cliente:");
	JLabel lidCliente = new JLabel("Id Cliente:");
	JLabel lconta     = new JLabel("Conta:");
	JLabel lsaldo     = new JLabel("Saldo:");	
	
	// campos
	JTextField tcliente   = new JTextField();
	JTextField tidCliente = new JTextField();
	JTextField tconta     = new JTextField();
	JTextField tsaldo     = new JTextField();
				
	// botões
	JButton b1 = new JButton("Submeter");
	JButton b2 = new JButton("Limpar");
	JButton b3 = new JButton("...");
	
	public TelaConta(String str){
		super(str,false,true);
		
		Container ct = this.getContentPane();
		ct.setLayout(null);
		
		// coordenadas
		lcliente.setBounds(9,10,100,30);
		tcliente.setBounds(55,10,250,25);
		lidCliente.setBounds(202,40,100,30);
		tidCliente.setBounds(264,40,40,25);
		lconta.setBounds(9,40,100,30);
		tconta.setBounds(55,40,80,25);
		lsaldo.setBounds(9,70,100,30);
		tsaldo.setBounds(55,70,60,30);
		
		// idem
		b1.setBounds(55 ,120,120,30);
		b2.setBounds(210,120,120,30);
		b3.setBounds(310,10,20,25);
		
		// adicionando componentes
		ct.add(lcliente);
		ct.add(tcliente);
		ct.add(lidCliente);
		ct.add(tidCliente);
		ct.add(lconta);
		ct.add(tconta);
		ct.add(lsaldo);
		ct.add(tsaldo);
		// adicionando botões
		ct.add(b1);
		ct.add(b2);
		ct.add(b3);
				
		// evento dos botões
		b1.addActionListener(this);		
		b2.addActionListener(this);
		b3.addActionListener(this);
				
		// especificações do formulário
		setSize(350,200);
		setTitle(str);		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource() == b1){
			// setar atributos Cliente
			Conta ct = new Conta();
			ct.setNumeroConta(tconta.getText());
			ct.setSaldo(Double.parseDouble(tsaldo.getText()));
			ct.setIdCliente(Integer.parseInt(tidCliente.getText()));
			
			try {
				ctDao = new ContaDAO();
				ctDao.inserirConta(ct);
			} catch (SQLException e) {
				System.out.println("Erro de inserção de Conta!!!");
			}
		}
		if (evento.getSource() == b2){
			tcliente.setText("");
			tidCliente.setText("");
			tconta.setText("");
			tsaldo.setText("");
		}
		if (evento.getSource() == b3){
			if (tcliente != null){
				try {
					cDao = new ClienteDAO();
					tidCliente.setText(Integer.toString(cDao.buscarCliente(tcliente)));
				} catch (SQLException e) {
					System.out.println("erro ao conectar ou de SQL!!!!");
				}
			}
		}
	}
}
