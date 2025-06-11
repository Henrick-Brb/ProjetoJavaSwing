import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeInterface extends JFrame {
    private JPanel panel1;
    private JButton CADASTRARButton;

    public homeInterface(){
        setContentPane(panel1);
        setTitle("Tela Inicial");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        CADASTRARButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CadastroClientes();
                dispose();
            }
        });
    }

    //Apenas para teste
    //public static void main(String[] args) {
    //   SwingUtilities.invokeLater(() -> new homeInterface().setVisible(true));
    //}
}
