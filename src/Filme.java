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
    //Adicionar Filme
    public void adicionarFilme(){
        String sql = "INSERT INTO Filme (idFilme, titulo, duracao, classIndic, genero) VALUES (?, ?, ?, ?, ?)";
        Scanner scan = new Scanner(System.in);

        System.out.print("Id: ");//ex: MOVIE001
        this.idFilme = scan.nextLine();

        System.out.print("Título: ");
        this.titulo = scan.nextLine();

        System.out.print("Duração (Min): ");
        this.duracao = scan.nextInt();
        scan.nextLine();

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

            int linhasModificadas = stmt.executeUpdate();
            if (linhasModificadas > 0){
                System.out.println("Catálogo atualizado com sucesso!");
            }

        } catch (SQLException e){
            System.out.println("Erro ao atualizar catálogo: "+ e.getMessage());
        }

    }

    // REMOVER FILME
    public void removerFilme(){
        String sql = "DELETE FROM Filme WHERE idFilme = ?";
        Scanner scan1 = new Scanner(System.in);

        System.out.println("REMOVER FILME DO CATÁLOGO: ");
        System.out.println("Digite o ID do filme a ser removido: ");
        this.idFilme = scan1.nextLine();

        try(Connection conectar = BancoDeDados.getConnection();
            PreparedStatement stmt = conectar.prepareStatement(sql)){

            stmt.setString(1, idFilme);

            int linhasModificadas = stmt.executeUpdate();
            if(linhasModificadas > 0){
                System.out.println("Filme "+ this.idFilme + " removido com sucesso!");
            }
            else{
                System.out.println("ID " + idFilme +" inexistente!");
            }

        } catch(Exception e){
            System.out.println("Erro ao remover o filme: "+ e.getMessage());
        }
    }

    public void listarCatalogo(){
        String sql = "SELECT * FROM Filme";

        try(Connection conectar = BancoDeDados.getConnection();
            PreparedStatement stmt  = conectar.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery()){

            System.out.println("FILMES EM CARTAZ:\n ");

            while(resultado.next()){
                this.idFilme = resultado.getString("idFilme");
                this.titulo = resultado.getString("titulo");
                this.duracao = resultado.getInt("duracao");
                this.classIndic = resultado.getString("classIndic");
                this.genero = resultado.getString("genero");

                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=");
                System.out.println(titulo.toUpperCase());
                System.out.println(duracao + " min");
                System.out.println(classIndic + " anos");
                System.out.println(genero);
                System.out.println(idFilme);
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=");

                }

        } catch (SQLException e){
            System.out.println("Erro ao listar filmes: "+ e.getMessage());
        }
    }
    //</editor-fold>

}
