import java.time.LocalTime;

public class Sessao {

    // Atributos
    private LocalTime horario;
    private Sala sala;
    private Filme filme;
    

    // Construtor
    public Sessao(LocalTime horario, Sala sala, Filme filme) {
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
    }


    // Getters and Setters
    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    

    // Ações
    public void esolherSessao(){

    }

    public void cancelarSessao(){

    }
}
