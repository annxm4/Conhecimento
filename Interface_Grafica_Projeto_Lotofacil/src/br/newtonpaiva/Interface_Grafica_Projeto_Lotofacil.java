// Importação das bibliotecas necessárias
package br.newtonpaiva;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

// Declaração da classe principal que herda de JFrame (para criar a janela)
public class Interface_Grafica_Projeto_Lotofacil extends JFrame {

    // Criação de uma instância da classe Random para gerar números aleatórios
    Random random = new Random();

    // Declaração dos elementos da interface gráfica
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    // Construtor da classe
    public Interface_Grafica_Projeto_Lotofacil() {
        // Configurações iniciais da janela
        this.setTitle("Lotofácil - Interface Gráfica"); // Define o título da janela
        this.setSize(400, 200); // Define o tamanho da janela em pixels

        // Configurações do painel
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20)); // Define o layout do painel
        painel.setBackground(new Color(255, 255, 255)); // Define a cor de fundo do painel como branca

        // Adiciona botões ao painel
        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);

        // Adiciona o painel à janela
        this.getContentPane().add(painel);

        // Centraliza a janela na tela
        this.setLocationRelativeTo(null);

        // Define o comportamento padrão de fechamento da janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Torna a janela visível
        this.setVisible(true);

        // Configura o ouvinte de eventos para o botão jButtonAposta1
        jButtonAposta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Solicita que o usuário insira um número de 0 a 100
                String numeroinput = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
                int numero = Integer.parseInt(numeroinput);
                int numerorandom = random.nextInt(101);

                if (numero >= 0 && numero <= 100) {
                    if (numerorandom == numero) {
                        // Exibe uma mensagem se o número gerado for igual ao número inserido
                        JOptionPane.showMessageDialog(null, "Você venceu!");
                    } else {
                        // Exibe uma mensagem se o número gerado for diferente do número inserido
                        JOptionPane.showMessageDialog(null, "Infelizmente não foi desta vez. Que pena! O número sorteado foi: " + numerorandom);
                    }
                } else {
                    // Exibe uma mensagem se o número inserido estiver fora do intervalo válido
                    JOptionPane.showMessageDialog(null, "Número fora do intervalo válido, tente novamente.");
                }
            }
        });

        // Configura o ouvinte de eventos para o botão jButtonAposta2
        jButtonAposta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Solicita que o usuário insira uma letra entre A e Z
                String letraInput = JOptionPane.showInputDialog("Insira uma letra entre A e Z:");
                letraInput = letraInput.toUpperCase(); // Converte a letra inserida para maiúscula
                char letra = letraInput.charAt(0); // Obtém o caractere da letra
                char letraPremiada = 'R'; // Letra premiada (pode ser alterada)

                if (Character.isLetter(letra)) {
                    if (letra == letraPremiada) {
                        // Exibe uma mensagem se a letra inserida for igual à letra premiada
                        JOptionPane.showMessageDialog(null, String.format("'%c'. Boa!! Você Venceu.", letra));
                    } else {
                        // Exibe uma mensagem se a letra inserida for diferente da letra premiada
                        JOptionPane.showMessageDialog(null, String.format("'%c'. Boa! ... Mas infelizmente não foi desta vez. Que pena! A letra sorteada foi: %c", letra, letraPremiada));
                    }
                } else {
                    // Exibe uma mensagem se a inserção estiver fora do intervalo válido
                    JOptionPane.showMessageDialog(null, "Inserção fora do intervalo válido, tente novamente.");
                }
            }
        });

        // Configura o ouvinte de eventos para o botão jButtonAposta3
        jButtonAposta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Solicita que o usuário insira um número par ou ímpar
                int numpi = Integer.parseInt(JOptionPane.showInputDialog("Digite um número par ou ímpar:"));
                if (numpi % 2 == 0) {
                    // Exibe uma mensagem se o número inserido for par
                    JOptionPane.showMessageDialog(null, "Você venceu!");
                } else {
                    // Exibe uma mensagem se o número inserido for ímpar
                    JOptionPane.showMessageDialog(null, "Que pena! O número digitado foi um número ímpar e a premiação foi para números pares, tente novamente.");
                }
            }
        });
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        new Interface_Grafica_Projeto_Lotofacil(); // Cria uma instância da classe para iniciar o programa
    }
}