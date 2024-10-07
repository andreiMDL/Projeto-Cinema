import java.sql.PreparedStatement;
import java.util.Scanner;


public class Options {

    Scanner scn = new Scanner(System.in);
    Cliente cliente = new Cliente();
    Administrador adm = new Administrador();
    Filme filme = new Filme();
    Sessao sessao = new Sessao();

    public void exibirOptions() {

        while (true) {
            System.out.println("Selecione uma opção: \n" +
                    "[1] Fazer Login " +
                    "[2] Fazer Cadastro " +
                    "[3] Ver Sessões " +
                    "[4] Admin" +
                    "[5] Encerrar ");

            System.out.printf("Digite aqui: ");
            int opt = scn.nextInt();

            if (opt == 1) {
                if (cliente.fazerLogin()){
                    exibirOptionsLogin();
                }else {
                    opcoesLogin();
                }

            }
            else if (opt == 2) {
                cliente.cadastroCliente();

            }
            else if(opt == 3){
                sessao.exibirSessao();
            }

            else if (opt == 4) {
                if(adm.acessoAdm()){
                    adm.optionAdm();
                }
                return;
            } else if (opt == 5){
                System.out.println("Obrigado e Volte Sempre!");
                System.exit(0);
            }
            else{
                System.out.println("Resposta Inválida! ");

            }
        }
    }

    public void opcoesLogin(){
        Scanner scanOpt = new Scanner(System.in);

        while (true){
            System.out.println("Email não encontrado. Deseja se cadastrar?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            System.out.printf("Digite aqui: ");
            int option = scanOpt.nextInt();

            if (option == 1){
                cliente.cadastroCliente();
            }
            if (option == 2){
                System.out.println("Continuando sem login");
                return;
            }
            else {
                System.out.println("Resposta inválida! ");
                return;
            }


        }
    }

    public void exibirOptionsLogin() {

        while (true) {
            System.out.println("Selecione uma opção: \n" +
                    "[1] Ver Sessões " +
                    "[2] Comprar Ingressos " +
                    "[3] Editar Dados " +
                    "[4] Fazer Logout " +
                    "[5] Admin " +
                    "[6] Encerrar");

            System.out.printf("Digite aqui: ");
            int opt = scn.nextInt();

            if (opt == 1) {
                sessao.exibirSessao();
            }
            else if (opt == 2) {
                cliente.comprarIngressos();
            }
            else if(opt == 3){
                cliente.atualizarDados();
            }
            else if(opt == 4){
                cliente.fazerLogout();
            }
            else if(opt == 5){
                if(adm.acessoAdm()){
                    adm.optionAdm();
                }
            } else if (opt == 6) {
                System.out.println("Obrigado e Volte Sempre!");
                System.exit(0);
            } else{
                System.out.println("Resposta Inválida! ");
            }
        }
    }

}

