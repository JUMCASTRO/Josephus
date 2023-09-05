import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * Pede o numeros de individuos e o numero de passos para o usuario e verifica se os valores sao validos
 * 
 * Diogo F.P.L Napolis, Joao Augusto Carrascoza, Julia Marques de Castro
 * 19/06/2023
 */
public class Aplicacao{
    /**
     * Método main - ponto de entrada do programa
     * @param args Um parâmetro (não utilizado neste caso)
     */
    public static void main(String[] args) {
        int saida1 = 0; 
        int saida2 = 0;

        var m1= 0;
        var n1 = 0;
        do{
            var m = new JTextField();
            var n = new JTextField();

            Object[] dadosEntrada = { "Insira a quantidade de individuos: ", m, "Insira a quantidade de passos:", n};
            var escolha = JOptionPane.showConfirmDialog(null, dadosEntrada, "Josephus", JOptionPane.OK_CANCEL_OPTION);

            saida1 = 0;
            saida2 = 0;
            if(escolha == JOptionPane.OK_OPTION){
                try{
                    m1 = Integer.parseInt(m.getText());
                    n1 = Integer.parseInt(n.getText());                   
                    if(m1 < 2){
                        JOptionPane.showMessageDialog(null,"Quantidade de individuos invalida!");
                    }else{
                        saida1 = 1;
                    }
                    if(n1 < 2){
                        JOptionPane.showMessageDialog(null,"Quantidade de passos invalida!");
                    }else{
                        saida2 = 1;
                    }
                }catch(ArithmeticException e){ //Tratamento de exceção para erro aritmetico
                    JOptionPane.showMessageDialog(null,"Mensagem da excecao: " + e.getMessage());
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Entrada inválida");
                }catch(Exception e){ //Captura possiveis excecoes que possam ocorrer durante a execucao do codigo
                    JOptionPane.showMessageDialog(null,"Outra excecao!");
                }
            }else{
                System.exit(0);
            }
        }while(saida1!= 1 || saida2!= 1); //Continua o loop do-while enquanto a variavel teste for diferente de 1
        Josephus josephus = new Josephus(m1,n1);
        josephus.criarRoleta();

        JosephusGUI josephusGUI = new JosephusGUI(josephus);
        josephusGUI.createAndShowGUI();
    }
}