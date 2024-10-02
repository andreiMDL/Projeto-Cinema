import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Sessao {

    //<editor-fold desc="Atributos">
    private LocalDate dia;
    private LocalTime horario;
    private int ingressos;
    //</editor-fold>

    //<editor-fold desc="Construtor">
    public Sessao(LocalDate dia, LocalTime horario, int ingressos) {

        this.dia = dia;
        this.horario = horario;
        this.ingressos = ingressos;
    }

    public Sessao() {

    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">


    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getIngressos() {
        return ingressos;
    }

    public void setIngressos(int ingressos) {
        this.ingressos = ingressos;
    }

    //</editor-fold>

    public void abrirSessao() {
        Filme filme = new Filme();
        System.out.println("-=- Abrir Sessão -=-");
        Scanner scanl = new Scanner(System.in);
        filme.listarCatalogo();

        System.out.printf("Digite o ID do filme para abrir sessão: ");

    }
}