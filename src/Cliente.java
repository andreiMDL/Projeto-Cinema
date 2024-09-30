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
    private LocalDate dataNascimento;

    //</editor-fold>

    //<editor-fold desc="Construtor">
    public Cliente(String nome, String cpf, String telefone, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

        System.out.println("Digite seu telefone: (Apenas Números)");
        this.telefone = scan.nextLine();
        telefone = formatarTelefone(telefone);

        System.out.println("Digite sua data de nascimento (Apenas Números): ");
        String dataNascimentoStr = scan.nextLine();


        // Formatando modelo de data String para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        this.dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        // Tentativa de conexão ao banco de dados e inserção das informações
        try (Connection conectar = BancoDeDados.getConnection(); //Faz a conexão com banco de dados
             PreparedStatement stmt = conectar.prepareStatement(sql)){ // Joga as informações pro banco de dados

            stmt.setString(1, this.cpf);
            stmt.setString(2, this.nome);
            stmt.setString(3, this.email);
            stmt.setString(4, this.telefone);
            stmt.setDate(5, java.sql.Date.valueOf(this.dataNascimento));

            // Executa a inserção ao banco de dados
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Cliente cadastrado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: "+ e.getMessage());
        }
    }

    //Efetuar Login
    public boolean fazerLogin() {
        Scanner scanl = new Scanner(System.in);

        System.out.printf("Digite seu email: ");
        String emailInput = scanl.nextLine();

        String sql = "SELECT * FROM Cliente WHERE email = ?";

        try (Connection conectar = BancoDeDados.getConnection();
             PreparedStatement stmt = conectar.prepareStatement(sql)) {

            stmt.setString(1, emailInput);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                System.out.println("Login realizado com sucesso!");
                return true;
            } else {

            }


        } catch (Exception e) {
            System.out.printf("Erro ao realizar login: " + e.getMessage());
            return false;
        }

    return false;
    }

    public void fazerLogout(){
        Options opt = new Options();
        System.out.println("Voltando à tela inicial... ");
        opt.exibirOptions();
    }

    // Atualizar ou editar dados cadastrais
    public void atualizarDados(){

    }

    public void exibirClientes(){
        String sql = "SELECT * FROM Cliente";


        try (Connection conectar = BancoDeDados.getConnection();
             PreparedStatement stmt = conectar.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()){

            System.out.println("CLIENTES CADASTRADOS:\n ");

            while(resultado.next()){
                this.nome = resultado.getString("nome");
                this.cpf = resultado.getString("cpf");
                this.telefone = resultado.getString("telefone");
                this.email = resultado.getString("email");
                java.sql.Date sqlDate = resultado.getDate("dataNascimento");
                if(sqlDate != null){
                    this.dataNascimento = sqlDate.toLocalDate();
                }
                else {
                    this.dataNascimento = null;
                }

                //Formatar a Data de Nascimento para dd/mm/yyyy
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataNascimentoFormatada = this.dataNascimento != null ? this.dataNascimento.format(formatter) : "N/A";

                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=");
                System.out.println("Nome: "+ nome);
                System.out.println("CPF: "+ cpf);
                System.out.println("Telefone: "+ telefone);
                System.out.println("Email: "+ email);
                System.out.println("Data de Nascimento: "+ dataNascimentoFormatada);
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=");

        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Formatações">
    // Formata a entrada dos dados para que o usuário não precise usar caracteres especiais
    public String formatarCPF(){
        return cpf.replaceAll("\\D", "").replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }


    public String formatarTelefone(String telefone){
        return this.telefone.replaceAll("\\D", "").replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }


    //</editor-fold>
}
