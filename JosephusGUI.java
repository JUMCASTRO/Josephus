import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JosephusGUI extends JFrame {
    private Josephus josephus;
    private List<JPanel> quadrados;
    private List<JLabel> labels;
    private JButton botaoStart;

    /**
     * JosephusGUI Construtor
     *
     * @param josephus Objeto Josephus utilizado para realizar os cálculos.
     */
    public JosephusGUI(Josephus josephus) {
        this.josephus = josephus;
        quadrados = new ArrayList<>();
        labels = new ArrayList<>();
    }

    /**
     * Método createAndShowGUI - Cria e exibe a interface gráfica do Josephus.
     *
     */
    public void createAndShowGUI() {
        setTitle("Josephus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        criarQuadrados();
        criarBotaoStart();

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(botaoStart, BorderLayout.SOUTH);
        contentPane.add(criarQuadradosContainer(), BorderLayout.CENTER);
        setContentPane(contentPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Método criarQuadradosContainer - Cria o painel que contém os quadrados na interface gráfica.
     *
     * @return O painel que contém os quadrados.
     */
    private JPanel criarQuadradosContainer() {
        JPanel quadradosContainer;
        int numeroDeQuadrados = josephus.getM();
        if (numeroDeQuadrados < 25) {
            quadradosContainer = new JPanel(new GridLayout(0, numeroDeQuadrados));
        } else {
            quadradosContainer = new JPanel(new GridLayout(0, 25));
        }
        for (JPanel square : quadrados) {
            quadradosContainer.add(square);
        }
        return quadradosContainer;
    }

    /**
     * Método criarQuadrados - Cria os quadrados e labels na interface gráfica.
     *
     */
    private void criarQuadrados() {
        int numeroDeQuadrados = josephus.getM();
        for (int i = 1; i <= numeroDeQuadrados; i++) {
            JPanel configQuadrado = new JPanel();
            configQuadrado.setBackground(Color.GREEN);
            configQuadrado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            configQuadrado.setPreferredSize(new Dimension(50, 50));

            JLabel label = new JLabel(String.valueOf(i));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);

            configQuadrado.setLayout(new BorderLayout());
            configQuadrado.add(label, BorderLayout.CENTER);

            quadrados.add(configQuadrado);
            labels.add(label);

            add(configQuadrado);
        }
    }

    /**
     * Método criarBotaoStart - Cria o botão "Start" na interface gráfica.
     *
     */
    private void criarBotaoStart() {
        botaoStart = new JButton("Start");
        botaoStart.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    startJosephus();
                }
            });
    }

    /**
     * Método startJosephus - Inicia o algoritmo de Josephus quando o botão "Start" é pressionado.
     *
     */
    private void startJosephus() {
        botaoStart.setEnabled(false); // Desabilita o botão enquanto o algoritmo é executado

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    iniciarJosephus();
                    return null;
                }

                @Override
                protected void done() {
                    quadrados.get(0).setBackground(Color.GREEN);
                    botaoStart.setEnabled(true); // Habilita o botão após a conclusão do algoritmo
                }
            };
        worker.execute();
    }

    /**
     * Método iniciarJosephus
     *
     */
    public void iniciarJosephus() {
        int count = 0;
        int totalDeQuadrados = josephus.getM();
        josephus.listarJosephus();
        josephus.criarRoleta();
        while (totalDeQuadrados > 1) {
            count = (count + josephus.getN() - 1) % totalDeQuadrados;
            josephus.executarJosephus(count);
            quadrados.get(count).setBackground(Color.RED);
            labels.get(count).setForeground(Color.WHITE);
            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            quadrados.remove(count);
            labels.remove(count);
            totalDeQuadrados--;
        }

        JOptionPane.showMessageDialog(null, "O último sobrevivente foi: " + labels.get(0).getText());

        int r = josephus.lerReiniciar();
        if (r == 1) {
            setVisible(false);
            Aplicacao.main(new String[0]); // Reinicia o programa
        }
        else{

            setVisible(false);
        }
    }
}