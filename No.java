
/**
 * No da lista duplamente ligada
 */
public class No{
    /**
     * Atributos
     */
    Object conteudo; // conteudo
    No proximo;  // proximo
    No anterior; // anterior
    long id; // id do no         

    /**
     * Construtor que recebe o conteúdo do no.
     * 
     * @param conteudo O conteúdo do no.
     */
    public No(Object conteudo){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(0);
    }

    /**
     * No Construtor - Construtor que recebe o conteúdo e o id do nó.
     *
     * @param conteudo O conteúdo do no.
     * @param id O id do no.
     */
    public No(Object conteudo, long id){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(id);
    }
    
    /**
     * Define o conteúdo do no.
     *
     * @param conteudo O conteúdo a ser definido.
     */
    public void setConteudo(Object conteudo){
        this.conteudo = conteudo;
    }

    /**
     * Método setProximo - Define o no seguinte.
     *
     * @param proximo Um parâmetro
     */
    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    /**
     * Método setAnterior - Define o no anterior
     *
     * @param anterior O nó anterior a ser definido.
     */
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }

    /**
     * Método getConteudo - Retorna o conteúdo do no.
     *
     * @return O conteúdo do no.
     */
    public Object getConteudo(){
        return(this.conteudo);
    }

    /**
     * Método getProximo - Retorna o no seguinte.
     *
     * @return O no seguinte.
     */
    public No getProximo(){
        return(this.proximo);
    }

    /**
     * Método getAnterior - Retorna o no anterior.
     *
     * @return O no anterior.
     */
    public No getAnterior(){
        return(this.anterior);
    }

    /**
     * Método setId - Define o id do no.
     *
     * @param id O id do no.
     */
    public void setId(long id){
        this.id = id;
    }

    /**
     * Método getId - Retorna o id do nó.
     *
     * @return O id do no.
     */
    public long getId(){
        return (this.id);
    }

    /**
     * Método toString - Retorna uma representação em string do conteúdo do nó.
     *
     * @return A representação em string do conteúdo do nó.
     */
    public String toString(){
        //return "ID: " + getId() + " " + getConteudo().toString(); 
        return(conteudo.toString());
    }
}
