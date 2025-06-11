import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.List;

public class clientesTable extends JFrame {
    private JTable tabela;
    private DefaultTableModel model;
    private JPanel panel1 = new JPanel(); // só para o form parar de reclamar

    public clientesTable(List<Cliente> clientes) {
        setTitle("Lista de Alunos");
        setSize(1200, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Colunas
        String[] colunas = {
                "Código", "Nome", "Endereço", "Bairro", "Cidade",
                "Estado", "Telefone", "CEP", "Observações"
        };

        model = new DefaultTableModel(colunas, 0);
        tabela = new JTable(model);
        tabela.setRowHeight(25);
        tabela.setFont(new Font("Arial", Font.PLAIN, 13));
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabela.setGridColor(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(tabela);

        // Preenche a tabela com a lista de clientes
        for (Cliente cliente : clientes) {
            model.addRow(new Object[]{
                    cliente.getCodigo(),
                    cliente.getnome(),
                    cliente.getEndereco(),
                    cliente.getBairro(),
                    cliente.getCidade(),
                    cliente.getEstado(),
                    cliente.getNumeroTelefone(),
                    cliente.getNumeroCEP(),
                    cliente.getObs()
            });
        }

        // Botão: Adicionar outro aluno
        JButton adicionarOutroButton = new JButton("Adicionar Aluno");
        adicionarOutroButton.addActionListener(e -> {
            new CadastroClientes(); // Abre a tela de cadastro
            dispose(); // Fecha a atual
        });

        // Botão: Excluir aluno selecionado
        JButton excluirButton = new JButton("Excluir Aluno");
        excluirButton.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um aluno para excluir.");
            }
        });

        // Botão: Gerar arquivo txt
        JButton gerarArquivoButton = new JButton("Gerar Arquivo");
        gerarArquivoButton.addActionListener(e -> {
            String userHome = System.getProperty("user.home");
            String path = userHome + File.separator + "Downloads" + File.separator + "dados_alunos.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                writer.write("Lista de Alunos\n----------------------\n");
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        writer.write(model.getColumnName(j) + ": " + model.getValueAt(i, j) + "\n");
                    }
                    writer.write("\n");
                }
                JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso na pasta Downloads!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        //Botão: Editar Cliente
        JButton editarButton = new JButton("Editar Aluno");
        editarButton.addActionListener(e -> {
            int selectedRow = tabela.getSelectedRow();
            if (selectedRow != -1) {
                Cliente clienteSelecionado = BancoClientes.listaClientes.get(selectedRow);
                new CadastroClientes(clienteSelecionado, selectedRow); // Abre a tela com dados preenchidos
                dispose(); // Fecha a lista
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Aluno para editar.");
            }
        });

        JPanel botoesPanel = new JPanel(new FlowLayout());
        botoesPanel.add(adicionarOutroButton);
        botoesPanel.add(excluirButton);
        botoesPanel.add(gerarArquivoButton);
        botoesPanel.add(editarButton);

        JPanel principal = new JPanel(new BorderLayout());
        principal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        principal.add(scrollPane, BorderLayout.CENTER);
        principal.add(botoesPanel, BorderLayout.SOUTH);

        add(principal);
        setVisible(true);
    }
}

