package tdd.service;

import tdd.modelo.Desempenho;
import tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		funcionario.reajustarSalario(funcionario.getSalario().multiply(desempenho.percentualReajuste()));		
	}

}
