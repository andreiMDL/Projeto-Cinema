import java.util.Scanner;

public class Options {

    Scanner scn = new Scanner(System.in);
    Cliente cliente = new Cliente();
    Administrador adm = new Administrador();

    public void exibirOptions() {

        while (true) {
            System.out.println("Selecione uma opção: \n" +
                    "[1] Fazer Cadastro " +
                    "[2] Ver Sessões " +
                    "[3] Comprar Ingressos" +
                    "[4] Editar Dados " +
                    "[5] Admin " +
                    "[6] Encerrar");

            System.out.printf("Digite aqui: ");
            int opt = scn.nextInt();

            if (opt == 1) {
                cliente.cadastroCliente();
            }
            else if (opt == 2) {

            }
            else if(opt == 3){

            }
            else if(opt == 4){

            }
            else if(opt == 5){
                adm.acessoAdm();

            } else if (opt == 6) {
                System.out.println("Obrigado e Volte Sempre!");
                break;
            } else{
                System.out.println("Resposta Inválida! ");
            }
        }
    }
}

