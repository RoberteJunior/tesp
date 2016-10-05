package seguros;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unibh.seguros.entidades.EtapaProcesso;
import br.unibh.seguros.entidades.Funcionario;
import br.unibh.seguros.entidades.Proposta;
import br.unibh.seguros.entidades.Questionario;
import br.unibh.seguros.entidades.Segurado;
import br.unibh.seguros.entidades.Setor;
import br.unibh.seguros.entidades.TipoCombustivel;
import br.unibh.seguros.entidades.TipoDecisao;
import br.unibh.seguros.entidades.Tramitacao;
import br.unibh.seguros.entidades.Veiculo;

public class TesteValidador {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	public void testeValidacaoSetorOK() {
		System.out.println("--------testeValidacaoSetorOK-------------------------------------------------------------------");		
		Setor o = new Setor(1L, "Recursos Humanos", "RH", null, null);
		System.out.println(o);
		Set<ConstraintViolation<Setor>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Setor> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoSetorErro() {
		System.out.println("-----------testeValidacaoSetorErro----------------------------------------------------------------");		
		Setor o = new Setor(1L, "Recursos Humanos@", "RH", null, null);
		System.out.println(o);
		Set<ConstraintViolation<Setor>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Setor> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}

	@Test
	public void testeValidacaoFuncionarioOK() {
		
		System.out.println("---------testeValidacaoFuncionarioOK------------------------------------------------------------------");		
		Date data = new Date();
		Funcionario o = new Funcionario(1L,"joao","M","10010880690","(31)7070-7070", "(31)8080-8080", 
				"(31)9608-0558", "robertejunior@hotmail.com", data, data, null, "AABR", "robertejunior", "1234578");
		System.out.println(o);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Funcionario> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoFuncionarioErro() {
		System.out.println("---------testeValidacaoFuncionarioErro------------------------------------------------------------------");		
		Date data = new Date();
		Funcionario o = new Funcionario(1L,"joao","M","10010880690","(31)7070-7070", "(31)8080-8080", 
				"(31)9608-055833", "robertejunior@hotmail.com", data, data, null, "AABR", "robertejunior", "1234578");
		System.out.println(o);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Funcionario> c : constraintViolations) {
			System.out.println(" Erro de Validacao Funcionario Erro: " + c.getMessage()+" numero de erros: "+ constraintViolations.size());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
	
	
	
	@Test
	public void testeValidacaoSeguradoOK() {
		System.out.println("----------testeValidacaoSeguradoOK-----------------------------------------------------------------");		
		Date data = new Date();
		Segurado o = new Segurado(1L,"João","M","10010880690","(31)7070-7070", "(31)8080-8080", "(31)9608-0558", "robertejunior@hotmail.com", data, data, 
				"A", "1578965", "SSP", "96874552", "B", data, data, "rau a", "201", "ap203", "30.180-100", "centro", "belo horizonte", "MG");
		
		System.out.println(o);
		Set<ConstraintViolation<Segurado>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Segurado> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoSeguradoErro() {
		System.out.println("---------testeValidacaoSeguradoErro------------------------------------------------------------------");		
		Date data = new Date();
		Segurado o = new Segurado(1L,"João","M","10010880690","(31)7070-7070", "(31)8080-8080", "(31)9608-0558", "robertejunior@hotmail.com", data, data, 
				"A", "1578965", "SSP", "96874552", "B", null, data, "rau a", "201", "ap203", "30.180-100", "centro", "belo horizonte", "MG");
		
		System.out.println(o);
		Set<ConstraintViolation<Segurado>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Segurado> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage()); 
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
	
	
	
	@Test
	public void testeValidacaoPropostaOK() {
		
		System.out.println("------testeValidacaoPropostaOK---------------------------------------------------------------------");		
		Date data = new Date();
	
		Proposta o = new Proposta(1L, data, "A", "JGJG", new BigDecimal("90.00"), new BigDecimal("80.00"), data, data, 3,new BigDecimal("50.00"), 10, "SANTANDER", "AGENCIA", "CONTA", null,null,null,null,null);
		System.out.println(o);
		Set<ConstraintViolation<Proposta>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Proposta> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoPropostaErro() {
		System.out.println("-------testeValidacaoPropostaErro--------------------------------------------------------------------");		
		
		Date data = new Date();
		Proposta o = new Proposta(1L, data, "A", "aaaaaaaaaaaaaa", new BigDecimal("90.00"), new BigDecimal("80.00"), data, data, 3,new BigDecimal("50.00"), 10, "brasil", "conta", "saldo", null, null, null, null, null);
		System.out.println(o);
		Set<ConstraintViolation<Proposta>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Proposta> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
	
	
	@Test
	public void testeValidacaoTramitacaoOK() {
		
		System.out.println("----------testeValidacaoTramitacaoOK-----------------------------------------------------------------");		
		
		Tramitacao o = new Tramitacao(1L, null,EtapaProcesso.APROVADA, new Date(20-01-2015), TipoDecisao.AUTOMATICA, null,null, null, null);
		System.out.println(o);
		Set<ConstraintViolation<Tramitacao>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Tramitacao> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoTramitacaoErro() {
		
		
		System.out.println("--------testeValidacaoTramitacaoErro-------------------------------------------------------------------");		
		Tramitacao o = new Tramitacao(1L, null,EtapaProcesso.APROVADA, null, TipoDecisao.AUTOMATICA, null,null, null, null);
		System.out.println(o);
		Set<ConstraintViolation<Tramitacao>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Tramitacao> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
	
	
	
	@Test
	public void testeValidacaoQuestionarioOK() {
		
		
	
		Questionario o = new Questionario(1L, true, "teste", true, true, true, true, true, 1L, true, true, true, null);
		System.out.println(o);
		Set<ConstraintViolation<Questionario>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Questionario> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoQuestionarioErro() {
		
		
		Questionario o = new Questionario(1L, true, "8888", true, true, true, true, true, 1L, true, true, true, null);
		System.out.println(o);
		Set<ConstraintViolation<Questionario>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Questionario> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
	
	
	
	@Test
	public void testeValidacaoVeiculoOK() {
		
		
	
		Veiculo o = new Veiculo(1L, "VW", "fox", 2011, 2011, "GXO-4455", "teste", TipoCombustivel.GASOLINA, true, true, null);
		System.out.println(o);
		Set<ConstraintViolation<Veiculo>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Veiculo> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoVeiculoErro() {
		
		
		Veiculo o = new Veiculo(1L, "VW", "gol", 2016, 2016, "put-3340", "abcdefghijklea", TipoCombustivel.GASOLINA, true, true, null);
		System.out.println(o);
		Set<ConstraintViolation<Veiculo>> constraintViolations = validator.validate(o);
		for (ConstraintViolation<Veiculo> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}
	
	
	
	
}