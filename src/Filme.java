public class Filme {

    //<editor-fold desc="Atributos">
    private String titulo;
    private int duracao;
    private String classIndic;
    private String genero;
    //</editor-fold>

    //<editor-fold desc="Construtor">
    public Filme(String titulo, int duracao, String classIndic, String genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.classIndic = classIndic;
        this.genero = genero;
    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getClassIndic() {
        return classIndic;
    }

    public void setClassIndic(String classIndic) {
        this.classIndic = classIndic;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    //</editor-fold>

    //<editor-fold desc="Ações">
    public void verCatalogo(){

    }

    public void escolherFilme(){

    }
    //</editor-fold>

}
