import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorMonedas {
    private JFrame ventana;
    private JTextField campoDolares;
    private JTextField campoEuros;
    private JButton botonIniciar;
    private JButton botonBorrar;

    public ConversorMonedas() {
        ventana = new JFrame("Conversor de Monedas BY KRIZ");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Encabezado
        JLabel encabezado = new JLabel("CONVERSOR DE MONEDAS BY KRIZ");
        encabezado.setFont(new Font("Arial", Font.BOLD, 30));
        ventana.add(encabezado, BorderLayout.NORTH);

        // Panel de campos
        JPanel campoPanel = new JPanel(new GridLayout(2, 2));
        campoPanel.add(new JLabel("DOLARES:"));
        campoDolares = new JTextField(10);
        campoPanel.add(campoDolares);
        campoPanel.add(new JLabel("EUROS:"));
        campoEuros = new JTextField(10);
        campoPanel.add(campoEuros);
        ventana.add(campoPanel, BorderLayout.CENTER);

        // Panel de botones
        JPanel botonPanel = new JPanel(new FlowLayout());
        botonIniciar = new JButton("INICIAR");
        botonIniciar.setBackground(Color.BLACK);
        botonIniciar.setForeground(Color.WHITE);
        botonIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirMoneda();
            }
        });
        botonPanel.add(botonIniciar);

        botonBorrar = new JButton("BORRAR");
        botonBorrar.setBackground(Color.GRAY);
        botonBorrar.setForeground(Color.WHITE);
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoDolares.setText("");
                campoEuros.setText("");
            }
        });
        botonPanel.add(botonBorrar);
        ventana.add(botonPanel, BorderLayout.SOUTH);

        // Fondo de la ventana
        ventana.getContentPane().setBackground(new Color(0, 128, 0)); // Verde (4 de treboles)

        ventana.pack();
        ventana.setVisible(true);
    }

    private void convertirMoneda() {
        try {
            double dolares = Double.parseDouble(campoDolares.getText());
            double euros = dolares * 0.84; // Tasa de cambio aproximada
            campoEuros.setText(String.format("%.2f", euros));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(ventana, "Error: ingrese un valor numérico");
        }
    }

    public static void main(String[] args) {
        new ConversorMonedas();
    }
}