package visao;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ClienteDAO;
import modelo.Cliente;

public class TelaCliente extends JInternalFrame implements ActionListener{
	
	ClienteDAO cDao;
	
	// rótulos
	JLabel lnome =  new JLabel("Nome:");
			
	// campos
	JTextField tnome   = new JTextField();
			
	// bot�es
	JButton b1 = new JButton("Submeter");
	JButton b2 = new JButton("Limpar");

	public TelaCliente(String str)  {
		super(str,false,true);
		
		Container ct = this.getContentPane();
		ct.setLayout(null);
			
		// coordenadas
		lnome.setBounds(9,10,100,30);
		tnome.setBounds(55,10,260,25);

		// idem
		b1.setBounds(55 ,120,120,30);
		b2.setBounds(210,120,120,30);
				
		// adicionando componentes
		ct.add(lnome);
		ct.add(tnome);
		ct.add(b1);
		ct.add(b2);
		
		// evento dos bot�es
		b1.addActionListener(this);		
		b2.addActionListener(this);
		
		// especifica��es do formul�rio
		setSize(350,200);
		setTitle(str);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1){
			
			// setar atributos Cliente
			Cliente cliente = new Cliente();
			cliente.setNome(tnome.getText());
			try {
				cDao = new ClienteDAO();
				cDao.inserirCliente(cliente);
			} catch (SQLException e1) {
				System.out.println("Erro de insercao de cliente!!!");
			}
		}
		else if(e.getSource() == b2){
			tnome.setText("");
		}
	}
}
