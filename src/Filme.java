import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Filme {

    //<editor-fold desc="Atributos">
    private String idFilme;
    private String titulo;
    private int duracao;
    private String classIndic;
    private String genero;
    //</editor-fold>

    //<editor-fold desc="Construtor">
    public Filme(String idFilme,String titulo, int duracao, String classIndic, String genero) {
        this.idFilme = idFilme; // Usado como Primary Key
        this.titulo = titulo;
        this.duracao = duracao;
        this.classIndic = classIndic;
        this.genero = genero;
    }

    public Filme() {

    }
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">

    public String getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }

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
    public void adicionarFilme(){
        String sql = "INSERT INTO Filme (idFilme, titulo, duracao, classIndic, genero) VALUES (?, ?, ?, ?, ?)";
        Scanner scan = new Scanner(System.in);

        System.out.print("Id: ");
        this.idFilme = scan.nextLine();

        System.out.print("Título: ");
        this.titulo = scan.nextLine();

        System.out.print("Duração (Min): ");
        this.duracao = scan.nextInt();

        System.out.println("Classificação Indicativa: ");
        this.classIndic = scan.nextLine();

        System.out.println("Gênero: ");
        this.genero = scan.nextLine();

        try (Connection conectar = BancoDeDados.getConnection();
             PreparedStatement stmt = conectar.prepareStatement(sql)){

            stmt.setString(1, idFilme);
            stmt.setString(2, titulo);
            stmt.setInt(3, duracao);
            stmt.setString(4, classIndic);
            stmt.setString(5, genero);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Catálogo atualizado com sucesso!");
            }

        } catch (SQLException e){
            System.out.println("Erro ao atualizar catálogo: "+ e.getMessage());
        }

    }

    public void removerFilme(){

    }
    //</editor-fold>

}
