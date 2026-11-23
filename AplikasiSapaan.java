import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AplikasiSapaan extends JFrame implements ActionListener {

    private JLabel labelJudul;
    private JLabel labelNama;
    private JLabel labelHasil;
    private JTextField fieldNama;
    private JButton tombolSapa;
    private JButton tombolReset;

    public AplikasiSapaan() {
        setTitle("Sapaan Sederhana Unram");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        setLayout(new BorderLayout());

        labelJudul = new JLabel("Selamat Datang!", JLabel.CENTER);
        labelNama = new JLabel("Masukkan nama:");
        fieldNama = new JTextField(15);
        labelHasil = new JLabel("", JLabel.CENTER);
        tombolSapa = new JButton("Sapa");
        tombolReset = new JButton("Reset");

        JPanel panelInput = new JPanel(new FlowLayout());
        panelInput.add(labelNama);
        panelInput.add(fieldNama);

        JPanel panelTombol = new JPanel(new GridLayout(1, 2, 10, 10));
        panelTombol.add(tombolSapa);
        panelTombol.add(tombolReset);

        JPanel panelTengah = new JPanel(new GridLayout(3, 1));
        panelTengah.add(panelInput);
        panelTengah.add(labelHasil);
        panelTengah.add(panelTombol);

        add(labelJudul, BorderLayout.NORTH);
        add(panelTengah, BorderLayout.CENTER);

        tombolSapa.addActionListener(this);
        tombolReset.addActionListener(this);

        tombolSapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelJudul.setText("Klik tombol Sapa!");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelJudul.setText("Selamat Datang!");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolSapa) {
            String nama = fieldNama.getText();
            if (nama.isEmpty()) {
                labelHasil.setText("Nama belum diisi!");
            } else {
                labelHasil.setText("Halo, " + nama + "! Semangat belajar PBO :)");
            }
        } else if (e.getSource() == tombolReset) {
            fieldNama.setText("");
            labelHasil.setText("");
        }
    }

    public static void main(String[] args) {
        AplikasiSapaan app = new AplikasiSapaan();
        app.setVisible(true);
    }
}