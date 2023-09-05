import java.util.Random;

public class ListaDuplamenteLigadaCircular {
    private No inicio; // ref para primeiro elemento
    private No fim;    // ref para ultimo elemento

    int qtdNos; // Quantidade de nos
    private Random r = new Random(System.currentTimeMillis());

    // -------------------------------------------------------------
    /**
     * ListaDuplamenteLigadaCircular Construtor
     * Inicializa a lista com valores padrão: início e fim são nulos e a quantidade de nos é zero
     */
    public ListaDuplamenteLigadaCircular() {   
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }
    // Setters e Getters
    /**
     * Method getInicio -  Obtém o endereço do primeiro no da lista.
     *
     * @return O endereço do primeiro no.
     */
    public No getInicio(){
        return inicio;
    }

    /**
     * Método setInicio - Define o início da lista, atribuindo o no passado como parâmetro.
     *
     * @param inicio O no que será o início da lista.
     */
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    /**
     * Method getFim - Retorna o último no da lista.
     *
     * @return O endereço do último no.

     */
    public No getFim() {
        return fim;
    }

    /**
     * Método setFim - Define o último no da lista.
     *
     * @param fim O no a ser definido como último.
     */
    public void setFim(No fim) {
        this.fim = fim;
    }

    /**
     * Metodo getQtdNos - Retorna a quantidade de nos na lista.
     *
     * @return A quantidade de nos na lista.
     */
    public int getQtdNos(){        
        return this.qtdNos;
    }

    /**
     * Metodo setQtdNos - Atualiza a quantidade de nós na lista.
     *
     * @param qtdNos A nova quantidade de nós.
     */
    private void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    // -------------------------------------------------------------
    /**
     * Método estaVazia - Verifica se a lista está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    public boolean estaVazia() {
        return getInicio() == null; 
    }

    // -------------------------------------------------------------
    /**
     * Método inserirInicio - Insere um elemento no início da lista.
     *
     * @param elem O elemento a ser inserido.
     */
    public void inserirInicio(Object elem) {

        No novoNo = new No(elem, r.nextLong());   // make new link

        if( estaVazia() ) { 
            setFim(novoNo);
        } else {
            getInicio().setAnterior(novoNo); // 1
        }
        novoNo.setProximo(getInicio()); // 2
        setInicio(novoNo); // 3
        getFim().setProximo(getInicio()); // 4
        getInicio().setAnterior(getFim()); //5
        // Decrementa qtidade de nos
        setQtdNos(getQtdNos() + 1);

    }

    // -------------------------------------------------------------
    /**
     * Método inserirFim - Insere um elemento no fim da lista.
     *
     * @param elem O elemento a ser inserido.
     */
    public void inserirFim(Object elem)    {
        No novoNo = new No(elem, r.nextLong());  

        if( estaVazia() ) {
            setInicio(novoNo);
        } else {
            getFim().setProximo(novoNo); //1
            novoNo.setAnterior(getFim()); //2
        }
        setFim(novoNo); //3
        getFim().setProximo(getInicio()); // 4
        getInicio().setAnterior(getFim()); //5
        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);

    }

    // -------------------------------------------------------------
    /**
     * Método removerInicio - Remove o no do início da lista.
     *
     * @return O nó removido.
     */
    public No removerInicio() {
        No temp = null;
        if(getInicio() != null && getFim() != null) {
            temp = getInicio();

            if (getInicio() == getFim()) {
                setInicio(null);
                setFim(null);
            } else {
                getFim().setProximo(getInicio().getProximo());
                getInicio().getProximo().setAnterior(getFim()); 
                setInicio(getInicio().getProximo());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtdNos() - 1);
        return temp;
    }

    // -------------------------------------------------------------
    /**
     * Método removerFim - Remove o no do fim da lista.
     *
     * @return O nó removido.
     */
    public No removerFim() {
        No temp = null;
        if(getFim() != null && getInicio() != null) {
            temp = getFim();

            if(getFim() == getInicio()) {
                setFim(null);
                setInicio(null); 
            }
            else {
                getInicio().setAnterior(getFim().getAnterior());
                setFim(getFim().getAnterior());
                getFim().setProximo(getInicio());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtdNos() - 1);
        return temp;
    }

    // -------------------------------------------------------------
    /**
     * Método inserirApos - Insere um elemento após um nó com a chave especificada.
     *
     * @param key  A chave do nó após o qual o elemento será inserido.
     * @param elem O elemento a ser inserido.
     * @return true se o elemento foi inserido com sucesso, false caso contrário.
     */
    public boolean inserirApos(long key, Object elem) {
        No noAtual = getInicio(); 

        while((Long)noAtual.getId() != key) {
            if(noAtual == getFim()) {
                return false; 
            }
            noAtual = noAtual.getProximo(); 
        }
        No novoNo = new No(elem, r.nextLong());

        if(noAtual==getFim()) {
            novoNo.setProximo(getInicio()); 
            setFim(novoNo); 
        }
        else {
            novoNo.setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(novoNo);
        }
        novoNo.setAnterior(noAtual);
        noAtual.setProximo(novoNo); 
        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
        return true; 
    }

    // -------------------------------------------------------------
    /**
     * Método remover - Remove o no com a chave especificada.
     *
     * @param chave A chave do no a ser removido.
     * @return O no removido.
     */
    public No remover(long chave) {
        No noAtual = null;
        if(getInicio() != null) {
            noAtual = getInicio();

            while((Long)noAtual.getId() != chave) {
                if(noAtual == getFim()) {
                    return null;                 
                }
                noAtual = noAtual.getProximo(); 
            }

            if(noAtual == getInicio()) {
                noAtual = removerInicio();
            } else if (noAtual == getFim()) {
                noAtual = removerFim();
            }
            else {
                noAtual.getAnterior().setProximo(noAtual.getProximo());
                noAtual.getProximo().setAnterior(noAtual.getAnterior());
                // Decrementa qtidade de nos
                setQtdNos(getQtdNos() - 1);
            }
            noAtual.setAnterior(null);
            noAtual.setProximo(null);

        }
        return noAtual;
    }

    // -------------------------------------------------------------
    /**
     * Método toString - Retorna uma representação em string da lista a partir do início.
     *
     * @return A representação em string da lista.
     */
    public String toString() {
        String s = "[ ";
        No noAtual = getInicio();  // inicia do inicio
        if(noAtual != null) {
            do {   
                s = s + noAtual.toString() + " ";  
                noAtual = noAtual.getProximo();   
            } while(noAtual != getInicio());
        }
        s = s + "]";
        return s;
    }

    // -------------------------------------------------------------
    /**
     * Método toStringDoFim - Retorna uma representação em string da lista a partir do fim.
     *
     * @return A representação em string da lista.
     */
    public String toStringDoFim() {
        String s = "[ ";
        No noAtual = getFim();  // inicia no fim

        if(noAtual != null) {
            do {
                s = s + noAtual.toString() + " "; 
                noAtual = noAtual.getAnterior(); 
            }while(noAtual != getFim());
        }
        s = s + "]";
        return s;
    }

    /**
     * Método limparLista - Limpa a lista, removendo todos os nos.
     *
     */
    public void limparLista() {

        No temp = getInicio();

        while (temp != getFim()) {
            removerFim();
        }

        setInicio(null);
        setFim(null);

    }
}  
