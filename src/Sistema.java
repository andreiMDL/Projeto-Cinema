import java.util.Scanner;

public class Sistema extends Filme {

    //<editor-fold desc="Construtor Super Classe">
    public Sistema(String idFilme, String titulo, int duracao, String classIndic, String genero) {
        super(idFilme, titulo, duracao, classIndic, genero);
    }
    //</editor-fold>

    //<editor-fold desc="Override de Getters and Setters">
    @Override
    public String getIdFilme() {
        return super.getIdFilme();
    }

    @Override
    public void setIdFilme(String idFilme) {
        super.setIdFilme(idFilme);
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    @Override
    public int getDuracao() {
        return super.getDuracao();
    }

    @Override
    public void setDuracao(int duracao) {
        super.setDuracao(duracao);
    }

    @Override
    public String getClassIndic() {
        return super.getClassIndic();
    }

    @Override
    public void setClassIndic(String classIndic) {
        super.setClassIndic(classIndic);
    }

    @Override
    public String getGenero() {
        return super.getGenero();
    }

    @Override
    public void setGenero(String genero) {
        super.setGenero(genero);
    }
    //</editor-fold>

    Filme filme1 = new Filme();

}
