import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 * 
 * Diogo F.P.L Napolis, Joao Augusto Carrascoza, Julia Marques de Castro
 * 19/06/2023
 */
public class Josephus{
    ListaDuplamenteLigadaCircular roleta = new ListaDuplamenteLigadaCircular();
    int m;
    int n;

    /**
     * Construtor da classe Josephus.
     *
     * @param m O número de pessoas na roleta inicialmente.
     * @param n O número de saltos a serem feitos antes de remover alguém.
     */
    public Josephus(int m, int n){
        setM(m);
        setN(n);
    }

    /**
     * Método setM - Define o valor de m
     *
     * @param m O número de pessoas na roleta inicialmente.
     */
    private void setM(int m){
        this.m = m;
    }

    /**
     * Método setN - Define o valor de n
     *
     * @param n O número de saltos a serem feitos antes de remover alguém.
     */
    private void setN(int n){
        this.n = n;
    }

    /**
     * Método getM - Obtém o valor de m.
     *
     * @return O valor de m.
     */
    public int getM(){
        return m;
    }

    /**
     * Método getN - Obtém o valor de n.
     *
     * @return O valor de n.
     */
    public int getN(){
        return n;
    }

    /**
     * Método criarRoleta - Cria a roleta com base no valor de m.
     *
     */
    public void criarRoleta(){
        for(int i = 1; i <= m; i++){
            No celula = new No(i);
            roleta.inserirFim(celula);
        }
    }

    /**
     * Método executarJosephus - Executa o algoritmo de Josephus.
     *
     */
    public void executarJosephus(int count){
        No aux;
        aux = roleta.getFim();
        for(int j = 1; j <= count + 1; j++){
            aux = aux.getProximo();
        }
        aux = aux.getAnterior();
        roleta.remover(aux.getProximo().getId());
        //System.out.println(roleta);
    }

    public void listarJosephus(){
        No aux;
        Object[] vetor = new Object[m];
        aux = roleta.getFim();
        for(int k = 1; k < m; k++){
            for(int j = 1; j <= n; j++){
                aux = aux.getProximo();
            }
            aux = aux.getAnterior();
            vetor[k] = aux.getProximo().getConteudo();
            roleta.remover(aux.getProximo().getId());
        }
        JOptionPane.showMessageDialog(null, vetor);
    }

    /**
     * Método lerReiniciar - Lê a opção de reiniciar o programa.
     *
     * @return A opção de reiniciar o programa (1 para sim e 0 para não).
     */
    public static int lerReiniciar(){
        int resposta;
        int r =  0;
        while (true) {

            resposta = JOptionPane.showOptionDialog(null, "Deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(resposta == JOptionPane.YES_OPTION){
                return r = 1;

            } else if (resposta == JOptionPane.NO_OPTION)  {

                System.exit(0);

            }else{

                System.exit(0);

            }
        }
    }
}
