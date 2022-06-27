package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.modelo.Desempenho;
import tdd.modelo.Funcionario;
import tdd.service.ReajusteService;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void init() {
		System.out.println("Incializou");
		this.service = new ReajusteService();
		funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach
	public void finaliza() {
		System.out.println("Finalizou");
	}
	
	@BeforeAll
	public static void antesTodos() {
		System.out.println("Antes de Todos");
	}
	
	@AfterAll
	public static void depoisTodos() {
		System.out.println("Depois de Todos");
	}

	@Test
	public void reajusteDeveSerTresPorcentoDesempenhoADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveSer15PorCentoDesempenhoBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveSer20PorCentoDesempenhoExcelente() {
		service.concederReajuste(funcionario, Desempenho.EXCELENTE);		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
