import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroClientes extends JFrame {
    private JPanel panel1;
    private JTextField textField1;  // Código
    private JTextField textField2;  // Nome
    private JTextField textField3;  // Endereço
    private JTextField textField4;  // Bairro
    private JTextField textField5;  // Cidade
    private JComboBox comboBox1;    // Estado
    private JTextField textField6;  // Telefone
    private JTextField textField7;  // CEP
    private JButton excluirButton;
    private JButton salvarButton;
    private JButton retornarButton;
    private JTextField textField8;  // Observações

    int codigo;
    Long numeroTelefone;
    Long numeroCEP;

    // Construtor para cadastro novo
    public CadastroClientes() {
        inicializarComponentes();
        configurarSalvar(-1);  // índice -1 indica cadastro novo
    }

    // Construtor para editar cliente existente
    public CadastroClientes(Cliente clienteExistente, int index) {
        inicializarComponentes();

        // Preenche os campos com dados do cliente existente
        textField1.setText(String.valueOf(clienteExistente.getCodigo()));
        textField2.setText(clienteExistente.getnome());
        textField3.setText(clienteExistente.getEndereco());
        textField4.setText(clienteExistente.getBairro());
        textField5.setText(clienteExistente.getCidade());
        comboBox1.setSelectedItem(clienteExistente.getEstado());
        textField6.setText(String.valueOf(clienteExistente.getNumeroTelefone()));
        textField7.setText(String.valueOf(clienteExistente.getNumeroCEP()));
        textField8.setText(clienteExistente.getObs());

        // Código não editável para evitar erro ao editar
        textField1.setEditable(false);

        configurarSalvar(index);
    }

    // Método para inicializar configurações comuns
    private void inicializarComponentes() {
        setContentPane(panel1);
        setTitle("Cadastro de Cliente");
        setSize(1000, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Botão limpar (excluir campos)
        excluirButton.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            comboBox1.setSelectedIndex(0);
            textField6.setText("");
            textField7.setText("");
            textField8.setText("");
            JOptionPane.showMessageDialog(panel1, "Campos limpos com sucesso!", "Limpar", JOptionPane.INFORMATION_MESSAGE);
        });

        // Botão retornar para home
        retornarButton.addActionListener(e -> {
            new homeInterface();
            dispose();
        });
    }

    // Método que configura o botão salvar com base no índice
    private void configurarSalvar(int index) {
        salvarButton.addActionListener(e -> {
            // Validações iguais às suas...

            // Código
            String textoCodigo = textField1.getText();
            if (textoCodigo.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Digite um Código!", "Erro no campo 'CÓDIGO'", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!textoCodigo.matches("\\d+")) {
                JOptionPane.showMessageDialog(panel1, "Digite apenas números!", "Erro no campo 'CÓDIGO'", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                codigo = Integer.parseInt(textoCodigo);
            }

            // Nome
            String nome = textField2.getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Digite um Nome!", "Erro no campo 'NOME'", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!nome.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(panel1, "Digite apenas letras!", "Erro no 'NOME'", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Endereço
            String endereco = textField3.getText();
            if (endereco.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Digite um Endereço!", "Erro no campo 'ENDEREÇO'", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Bairro
            String bairro = textField4.getText();
            if (bairro.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Digite um Bairro!", "Erro no campo 'BAIRRO'", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cidade
            String cidade = textField5.getText();
            if (cidade.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Digite uma Cidade!", "Erro no campo 'CIDADE'", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Estado
            String estado = comboBox1.getSelectedItem().toString();
            if (estado.equals("Selecione")) {
                JOptionPane.showMessageDialog(panel1, "Selecione um Estado!", "Erro no campo 'Estado'", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Telefone
            String telefone = textField6.getText();
            if (telefone.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Digite um número de Telefone!", "Erro no campo 'TELEFONE'", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!telefone.matches("\\d+")) {
                JOptionPane.showMessageDialog(panel1, "Digite apenas números!", "Erro no campo 'TELEFONE'", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                numeroTelefone = Long.parseLong(telefone);
            }

            // CEP
            String cep = textField7.getText();
            if (cep.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Digite um CEP!", "Erro no campo 'CEP'", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!cep.matches("\\d+")) {
                JOptionPane.showMessageDialog(panel1, "Digite apenas números!", "Erro no campo 'CEP'", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                numeroCEP = Long.parseLong(cep);
            }

            // Observação
            String obs = textField8.getText();
            if (obs.isEmpty()) {
                obs = "SEM OBSERVAÇÕES";
            }

            Cliente novoCliente = new Cliente(codigo, nome, endereco, bairro, cidade, estado, numeroTelefone, numeroCEP, obs);

            if (index >= 0) {
                // Atualiza cliente existente na lista
                BancoClientes.listaClientes.set(index, novoCliente);
            } else {
                // Adiciona cliente novo
                BancoClientes.listaClientes.add(novoCliente);
            }

            new clientesTable(BancoClientes.listaClientes);
            dispose();
        });
    }
}
