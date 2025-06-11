import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginSistema extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton entrarButton;

    public loginSistema() {
        setTitle("Login do Sistema");
        setContentPane(panel1);
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        entrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textField1.getText();
                String senha = new String(passwordField1.getPassword());

                if (email.equals("Henrick") && senha.equals("12345")) {
                    JOptionPane.showMessageDialog(panel1, "Login realizado com sucesso!");
                    new homeInterface(); // Abre a tela de Home
                    dispose(); // Fecha tela de login
                } else {
                    JOptionPane.showMessageDialog(panel1, "Email ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(loginSistema::new);
    }
}
