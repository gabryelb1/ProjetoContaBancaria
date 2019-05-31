package contabancaria;

import java.util.Scanner;


public class Conta {
    Scanner ler = new Scanner(System.in);
    public int numConta;
    private String tipo;
    private String nome;
    private float saldo;
    private boolean status;
    private static int contador = 20190;

    public Conta() {
        this.saldo = 0;
        this.status = true;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static int getContador() {
        return contador++;
    }

    public static void setContador(int contador) {
        Conta.contador = contador++;
    }
 
    public void abrirConta(){
        System.out.println("Informe o nome do cliente: ");
        this.nome = ler.next();
        System.out.println("Informe o tipo de conta: CC ou CP");
        this.tipo = ler.next();
        if ("cc".equals(getTipo()) || "CC".equals(getTipo()) || "cp".equals(getTipo()) || "CP".equals(getTipo())){
        this.setStatus(true);
        }
        if("cc".equals(getTipo()) || "CC".equals(getTipo())){
        this.setSaldo(50);
        }else if("cp".equals(getTipo()) || "CP".equals(getTipo())){
        this.setSaldo(150);
        }
        setContador(contador);
        this.setNumConta(getContador());
        System.out.println("Conta é: "+ getNumConta());
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
    }
    public void depositar(Conta objetoC){
     if(this.getStatus()==false){
         System.out.println("Conta inválida ou não foi aberta ainda.");
     }if(this.getStatus()== true){
         float deposito;
         System.out.print("Informe o valor a ser depositado: R$ ");
         deposito = ler.nextFloat();
         objetoC.setSaldo(getSaldo()+deposito);
     }
     try { Thread.sleep (1000); } catch (InterruptedException ex) {}
    }
    public void sacar(Conta objetoC){
       if(this.getStatus()==false){
         System.out.println("Conta inválida ou não foi aberta ainda.");
     }if(this.getStatus()== true){
         System.out.print("Informe o valor do saque: R$ ");
         float saque = ler.nextFloat();
         if(saque<=objetoC.getSaldo()){
             objetoC.setSaldo(objetoC.getSaldo()-saque);
             System.out.println("Saque realizado com sucesso.");
         }else{
             System.out.println("Saldo insuficiente.");
         }
         try { Thread.sleep (1000); } catch (InterruptedException ex) {}
     }
    }
    public void fecharConta(Conta objetoC){
    if(this.getStatus()==false){
         System.out.println("Conta inválida.");
     }else if(getSaldo()==0 && getStatus()==true){
        System.out.println("Conta encerrada com suceso.");
        this.setStatus(false);
     }else if(getSaldo()>0 && getStatus()==true){
        System.out.println("Para encerrar a conta é necessário sacar todo saldo da conta");
     }else if(getSaldo()<0 && getStatus()==true){
        System.out.println("Saldo da conta está negativo, necessário depositar um valor para zerar a conta.");
     }
    try { Thread.sleep (1000); } catch (InterruptedException ex) {}
    }
    public void pagarMensalidade(Conta objetoC){
    if(this.getStatus()==false){
         System.out.println("Conta inválida.");
     }if("cc".equals(getTipo()) || "CC".equals(getTipo()) && getStatus()==true){
       if(getSaldo()>=12){
           setSaldo(getSaldo()-12);
           System.out.println("Mensalidade paga com sucesso.");
       }else{
           System.out.println("Saldo insuficiente para realizar o pagamento.");
       }
     }else if("cp".equals(getTipo()) || "CP".equals(getTipo()) && getStatus()==true){
         if(getSaldo()>=25){
             setSaldo(getSaldo()-25);
             System.out.println("Mensalidade paga com sucesso.");
         }else{
           System.out.println("Saldo insuficiente para realizar o pagamento.");
       }
     }
    }
   public void exibeConta(Conta c){
        if(c.getStatus()==false){
            System.out.println("Conta invalida.");
        }else{
        System.out.println("\tDados da conta: ");
        System.out.println("Número da conta: " + c.getNumConta());
        System.out.println("Tipo da conta: " +c.getTipo());
        System.out.println("Nome do Cliente: " +c.getNome());
        if(c.getStatus()== true){
            System.out.println("Status da conta: Aberta");
        }else{
            System.out.println("Status da conta: Fechada");
        }
       try { Thread.sleep (1000); } catch (InterruptedException ex) {}
    }
 
   }
   public void saldo(Conta c){
   if(c.getStatus()==false){
            System.out.println("Conta invalida.");
        }else{
        System.out.println("Saldo disponivel R$ "+c.getSaldo());
   }
   
   }
   public String toString(){
   return "Nome: "+this.nome+
          "\n Conta: "+this.numConta;
   }
}
