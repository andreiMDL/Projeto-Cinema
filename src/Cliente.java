import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    //<editor-fold desc="Atributos">
    private String nome;
    private String cpf; //CPF usado como Primary key
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;
    private List<Reserva> historicoReserva;
    //</editor-fold>

    //<editor-fold desc="Construtor">
    public Cliente(String nome, String cpf, String telefone, String email, LocalDate dataDeNascimento, List<Reserva> historicoReserva) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.historicoReserva = historicoReserva;
    }

    public Cliente() {

    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public List<Reserva> getHistoricoReserva() {
        return historicoReserva;
    }

    public void setHistoricoReserva(List<Reserva> historicoReserva) {
        this.historicoReserva = historicoReserva;
    }
    //</editor-fold>

    //<editor-fold desc="Ações">

    //Realizar cadastro de cliente

    public void cadastroCliente(){
        // SQL para inserir dados no banco
        String sql = "INSERT INTO Cliente (cpf, nome, email, telefone, dataNascimento) VALUES (?, ?, ?, ?, ?)";

        Scanner scan = new Scanner(System.in);

        // Captura da resposta do usuário
        System.out.println("Digite seu cpf (Apenas Números): ");
        this.cpf = scan.nextLine();

        System.out.println("Digite seu nome: ");
        this.nome = scan.nextLine();

        System.out.println("Digite seu email: ");
        this.email = scan.nextLine();

        System.out.println("Digite seu telefone: ");
        this.telefone = scan.nextLine();
        telefone = formatarTelefone(telefone);

        System.out.println("Digite sua data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scan.nextLine();
        dataNascimentoStr = formatData(dataNascimentoStr);

        // Formatando modelo de data String para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDeNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        // Tentativa de conexão ao banco de dados e inserção das informações
        try (Connection conectar = BancoDeDados.getConnection(); //Faz a conexão com banco de dados
             PreparedStatement stmt = conectar.prepareStatement(sql)){ // Joga as informações pro banco de dados

            stmt.setString(1, this.cpf);
            stmt.setString(2, this.nome);
            stmt.setString(3, this.email);
            stmt.setString(4, this.telefone);
            stmt.setDate(5, java.sql.Date.valueOf(this.dataDeNascimento));

            // Executa a inserção ao banco de dados
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Cliente cadastrado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: "+ e.getMessage());
        }
    }

    // Histórico de reservas
    public void verHistReserva(){

    }

    // Atualizar ou editar dados cadastrais
    public void atualizarDados(){

    }
    //</editor-fold>

    //<editor-fold desc="Formatações">
    // Formata a entrada dos dados para que o usuário não precise usar caracteres especiais
    public String formatarCPF(){
        return cpf.replaceAll("\\D", "").replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public String formatData(String dataDeNascimento){
        return dataDeNascimento.replaceAll("\\D", "").replaceFirst("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");
    }

    public String formatarTelefone(String telefone){
        return this.telefone.replaceAll("\\D", "").replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }
    //</editor-fold>
}
