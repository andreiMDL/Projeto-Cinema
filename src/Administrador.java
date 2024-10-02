import java.util.Scanner;
import java.io.Console;

public class Administrador extends Filme {

    //<editor-fold desc="Construtor Super Classe">
    public Administrador(String idFilme, String titulo, int duracao, String classIndic, String genero) {
        super(idFilme, titulo, duracao, classIndic, genero);


    }
    //</editor-fold>

    public Administrador() {

    }

    //<editor-fold desc="Acesso ao perfil ADMINISTRADOR">
    public boolean acessoAdm(){

        Scanner scan2 = new Scanner(System.in);
        boolean isAdm = false;//Torna a entrada como adm falsa
        Console console = System.console();// Instância do console


        System.out.printf("Digite a senha: ");
        String senha = scan2.nextLine();

        if(verficarSenha(senha)){
            System.out.println("Entrou como ADMINISTRADOR");
            isAdm = true;//Torna a entrada como adm Verdadeira
        }
        else{
            System.out.println("Senha Incorreta. Acesso Negado.");
        }

        return isAdm;
    }

    private boolean verficarSenha(String senhaDigitada) {
        final String SENHA_CORRETA = "Adm123";// Define a senha de acesso ao ADM
        return SENHA_CORRETA.equals(senhaDigitada);//Compara a senha correta com a senha digitada
    }
    //</editor-fold>

    //<editor-fold desc="Menu de Opções ADM">
    public void optionAdm(){
        while (true){

            Filme filme = new Filme();
            Scanner scan3 = new Scanner(System.in);
            Cliente cliente = new Cliente();
            Sessao sessao = new Sessao();

            System.out.println("-=-=- Menu ADM -=-=-");
            System.out.println("[1] Adicionar Filme ");
            System.out.println("[2] Remover Filme ");
            System.out.println("[3] Exibir Clientes ");
            System.out.println("[4] Abrir Sessão ");
            System.out.println("[5] Fechar Sessão ");
            System.out.println("[6] Exibir Sessões ");
            System.out.println("[7] Sair de ADM");

            int opcao = scan3.nextInt();
            scan3.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("-=- Adicionar Filme -=- ");
                    filme.adicionarFilme();
                    break;

                case 2:
                    System.out.println("-=- Remover Filme -=-");
                    filme.removerFilme();
                    break;

                case 3:
                    cliente.exibirClientes();
                    break;

                case 4:
                    sessao.abrirSessao();
                    break;
                case 5:

                case 6:
                    sessao.exibirSessao();
                    break;
                case 7:
                    System.out.println("Saindo de ADMINISTRADOR...");
                    return;
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Override de Getters and Setters">

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



}
