import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    //<editor-fold desc="Abrir Sessão">
    public void abrirSessao() {
        Filme filme = new Filme();
        System.out.println("-=- Abrir Sessão -=-");
        Scanner scanl = new Scanner(System.in);
        filme.listarCatalogo();

        System.out.printf("Digite o ID do filme para abrir sessão: ");
        String escolha = scanl.nextLine();

        filme.buscarFilme(escolha);

        if(escolha == null){
            System.out.println("Filme não encontrado.");
            return;
        }

        String sql = "INSERT INTO Sessao (dia, horario, ingressos) VALUES (?, ?, ?)";

        System.out.printf("Digite o dia da sessão: (somente números) ");
        String diaStr = scanl.nextLine();

        //Formatar data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        this.dia = LocalDate.parse(diaStr, formatter);


        System.out.printf("Digite o horário da sessão: ");
        String horarioStr = scanl.nextLine();

        //Formatar horário
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        this.horario = LocalTime.parse(horarioStr, formatter1);

        System.out.printf("Digite a quantidade de ingressos disponíveis: ");
        this.ingressos = scanl.nextInt();

        try(Connection conectar = BancoDeDados.getConnection();
            PreparedStatement stmt = conectar.prepareStatement(sql)){

            stmt.setDate(1, Date.valueOf(dia));
            stmt.setTime(2, Time.valueOf(horario));
            stmt.setInt(3, ingressos);


            int linhasModificas = stmt.executeUpdate();
            if(linhasModificas > 0){
                System.out.println("Sessão aberta com sucesso! ");
            }

        }
        catch (Exception e){
            System.out.println("Erro ao abrir sessão: "+ e.getMessage());
        }


    }
    //</editor-fold>

    //<editor-fold desc="Fechar Sessão">
    public void fecharSessao(){
        Filme filme = new Filme();
        System.out.println("-=- Fechar Sessão -=-");
        Scanner scanf = new Scanner(System.in);
        exibirSessao();

        System.out.println("Digite a ID da sessão: ");
        String escolha = scanf.nextLine();

        if(escolha == null || escolha.trim().isEmpty()){
            System.out.println("Sessão não encontrada.");
            return;
        }

        String sql = "DELETE FROM Sessao WHERE idSessao = ?";

        try (Connection connectar = BancoDeDados.getConnection();
            PreparedStatement stmt = connectar.prepareStatement(sql)){

            stmt.setString(1, escolha);

            int linhasModificadas = stmt.executeUpdate();
            if(linhasModificadas > 0){
                System.out.println("Sessão removida com sucesso!");
            }
            else {
                System.out.println("Nenhuma sessão com essa ID foi encontrada.");
            }

        }
        catch (Exception e){
            System.out.println("Erro ao fechar sessão: "+ e.getMessage());
        }


    }
    //</editor-fold>

    //<editor-fold desc="Exibir Sessão">
    public void exibirSessao(){
        String sql = "SELECT idSessao, dia, horario, ingressos FROM Sessao";


        try (Connection conectar = BancoDeDados.getConnection();
            PreparedStatement stmt = conectar.prepareStatement(sql)){
            ResultSet resultado = stmt.executeQuery();

            if(!resultado.isBeforeFirst()){
                System.out.println("Nenhuma sessão aberta.");
            }

            while (resultado.next()){
                System.out.println("-=- Sessões abertas -=- ");
                int idSessao = resultado.getInt("idSessao");
                java.sql.Date sqlDate = resultado.getDate("dia");
                java.sql.Time sqlTime = resultado.getTime("horario");
                this.ingressos = resultado.getInt("ingressos");

                if (sqlDate != null){
                    this.dia = sqlDate.toLocalDate();
                }
                else {
                    this.dia = null;
                }

                if (sqlTime != null){
                    this.horario = sqlTime.toLocalTime();
                }
                else {
                    this.horario = null;
                }

                //Formatando data e horario
                DateTimeFormatter formatterDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String diaStr = this.dia != null ? this.dia.format(formatterDia) : "N/A";

                DateTimeFormatter formatterHr = DateTimeFormatter.ofPattern("HH:mm");
                String horarioStr = this.horario != null ? this.horario.format(formatterHr) : "N/A";

                System.out.println("Data: "+ diaStr);
                System.out.println("Horário: "+ horarioStr);
                System.out.println("Ingressos disponíveis: "+ ingressos);
                System.out.println("Id: "+ idSessao);
                System.out.println("===========================================");
            }
            if (resultado == null){
                System.out.println("Nenhuma sessão aberta.");
            }



        }
        catch (Exception e){
            System.out.println("Erro ao exibir sessões: "+ e.getMessage());
        }
    }
    //</editor-fold>


}