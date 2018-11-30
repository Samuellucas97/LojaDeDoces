package visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame implements ActionListener{
	
	JDesktopPane dtp = new JDesktopPane();
	
	JMenuBar mnbar   = new JMenuBar();	
	JMenu fileMenu   = new JMenu("Cadastros");
	JMenu fileRels   = new JMenu("Relatórios");
	JMenu exitMenu = new JMenu("Sair");
	JMenuItem mItem1 = new JMenuItem("Clientes");
	JMenuItem mItem2 = new JMenuItem("Contas");
	JMenuItem mItem3 = new JMenuItem("Movimentos");
		 		
	public TelaPrincipal(){
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		
		setJMenuBar(mnbar);
		mnbar.add(fileMenu);
		mnbar.add(fileRels);
		mnbar.add(exitMenu);

		fileMenu.add(mItem1);
		fileMenu.add(mItem2);
		fileMenu.add(mItem3);
		
		ct.add(BorderLayout.CENTER, dtp);
		
		setSize(800,600);
		setResizable(false);
		setTitle("Transações Bancárias");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// eventos
		mItem1.addActionListener(this);	
		mItem2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mItem1){
			TelaCliente tlCliente = new TelaCliente("Clientes");
			dtp.add(tlCliente);
			tlCliente.setVisible(true);
		}
		if (e.getSource() == mItem2){
			TelaConta tlConta = new TelaConta("Contas");
			dtp.add(tlConta);
			tlConta.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		TelaPrincipal telaPai = new TelaPrincipal();
		telaPai.setVisible(true);
	}
}
