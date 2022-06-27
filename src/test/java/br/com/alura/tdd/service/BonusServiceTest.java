package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdd.modelo.Funcionario;
import tdd.service.BonusService;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
		BonusService bonus = new BonusService();
//		assertThrows(IllegalArgumentException.class, () -> bonus.calcularBonus(new Funcionario("Dani", LocalDate.now(), new BigDecimal("20000"))));
		
		try {
			bonus.calcularBonus(new Funcionario("Dani", LocalDate.now(), new BigDecimal("20000")));
			fail("Não deu Exception!");
		} catch (Exception e) {
			assertEquals("Funcionario não pode ter Salário Maior que R$10.000", e.getMessage());
		}
		
	}
	
	@Test
	void bonusDeveriaDezPorcentoDoSalario() {
		BonusService bonus = new BonusService();
		BigDecimal valor = bonus.calcularBonus(new Funcionario("Dani", LocalDate.now(), new BigDecimal("5000")));
		
		assertEquals(new BigDecimal("500.00"), valor);
	}
	
	@Test
	void bonusComSalarioIgualLimite() {
		BonusService bonus = new BonusService();
		BigDecimal valor = bonus.calcularBonus(new Funcionario("Dani", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), valor);
	}
	
	

}
