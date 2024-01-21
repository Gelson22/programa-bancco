package Programa;

import utilitario.Util;

public class Conta {

	private static int contadorContas = 1;
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;

	public Conta(Pessoa pessoa) {
		this.numeroConta = contadorContas;
		this.pessoa = pessoa;
		contadorContas += 1;

	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return"\nNúmero da conta: " + this.getNumeroConta() +
			  "\nNome:"  + this.pessoa.getNome() +   
			  "\nCPF: "  + this.pessoa.getCpf() +
              "\nEmail:" + this.pessoa.getEmail() +
			  "\nSaldo:" + Util.doubleToString(this.getSaldo()) +
			  "\n";
	}
	
	public void depositar(double valor ) {
		if (valor>0) {
			setSaldo(getSaldo()+ valor);
			System.out.println("seu deposito foi realizado com sucesso ! ");
		}else {
			System.out.println("Não foi possivel realizar o deposito ");
		}
		
	}
	public void sacar(double valor ) {
	   if(valor>0 &&this.getSaldo() >=valor ) {
		   setSaldo(getSaldo()-valor );
		   System.out.println("saque realizado com sucesso ! ");
	   }else {
		   System.out.println("não foi possivel realizar o saque ! ");
	   }
	}
	
	public void transferir (Conta contaParaDeposito, double valor  ) {
		if(valor>0 && this.getSaldo()>=valor ) {
			setSaldo(getSaldo() - valor );
			
			contaParaDeposito.saldo=contaParaDeposito.getSaldo() + valor;
			System.out.println("transferencia realizada com sucesso ! ");
		}else {
			System.out.println("não foi possivel realizar a transferencia ! ");
		}
		
		
	
	}
	
}