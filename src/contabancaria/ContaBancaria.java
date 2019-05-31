package contabancaria;

import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.Scanner;

public class ContaBancaria {

    public static void main(String[] args) {

        ArrayList<Conta> dados = new ArrayList();
        int opc = -1;
        int teste = 0;

        Scanner teclado = new Scanner(System.in);
        while (opc != 0) {
            System.out.println("Digite a opção desejada: \n"
                    + "1- Abrir conta\n"
                    + "2- Depósito\n"
                    + "3- Saque\n"
                    + "4- Exibir contas\n"
                    + "5- Fechar conta\n"
                    + "6- Pagar Mensalidade\n"
                    + "7- Saldo\n"
                    + "0- Finalizar operação");
            opc = teclado.nextInt();
            if (opc == 1) {
                System.out.println("----------------- Abrir conta -----------------");
                Conta c = new Conta();
                c.abrirConta();
                dados.add(c);
                teste = 1;
            }
            if (opc == 2) {
                if (teste == 1) {
                    System.out.println("----------------- Depósito -----------------");
                    System.out.println("Informe o nº da conta que deseja depositar:  ");
                    int busca = teclado.nextInt();
                    for (Conta objetoC : dados) {
                        if (busca == objetoC.getNumConta()) {
                            objetoC.depositar(objetoC);
                        }
                    }
                } else {
                    System.out.println("Para realizar o depósito necessário abrir uma conta antes");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
            if (opc == 3) {
                if (teste == 1) {
                    System.out.println("----------------- Saque -----------------");
                    System.out.println("Informe o n° da conta que deseja realizar o saque: ");
                    int bsc = teclado.nextInt();
                    for (Conta objetoC : dados) {
                        if (bsc == objetoC.getNumConta()) {
                            objetoC.sacar(objetoC);
                        }
                    }
                } else {
                    System.out.println("Para realizar o saque necessário abrir uma conta antes");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
            if (opc == 4) {
                if (teste == 1) {
                for (Conta c : dados) {
                    c.exibeConta(c);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
                }else{
                    System.out.println("Para exibir dados");
                }
            }
            if (opc == 5) {
                if (teste == 1) {
                    System.out.println("----------------- Fechar Conta -----------------");
                    System.out.println("Informe o n° da conta que deseja fechar: ");
                    int contaf = teclado.nextInt();
                    for (Conta c : dados) {
                        if(contaf == c.getNumConta()){
                        c.fecharConta(c);
                        } 
                    }
                    for (int i = 0; i < dados.size(); i++) {
                        if(contaf == dados.get(i).getNumConta()){
                        System.out.println(dados.get(i).getNumConta());
                        dados.remove(i);
                        break;
                }
                    }

                } else {
                    System.out.println("Para fechar uma conta é necessário ter aberto uma conta antes.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                    }
                }
                
            }
            if (opc == 6) {
                if (teste == 0) {
                     
                    System.out.println("Para verificar o saldo é necessário ter aberto uma conta.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                    }
                } else if (teste == 1) {
                    for (Conta c : dados) {
                        c.pagarMensalidade(c);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            }
            if (opc == 7) {
                if (teste == 0) {
                    System.out.println("Para verificar o saldo é necessário ter aberto uma conta.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                    }
                } else if (teste == 1) {
                    System.out.println("Informe a conta que deseja verificar o saldo: ");
                    int contab = teclado.nextInt();
                     for (int i = 0; i < dados.size(); i++) {
                        if(contab == dados.get(i).getNumConta()){
                        System.out.println(dados.get(i).getSaldo());
                        break;
                }
                    }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            }
           
        }
    }

