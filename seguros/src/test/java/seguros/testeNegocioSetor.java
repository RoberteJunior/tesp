package seguros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import br.unibh.seguros.entidades.Setor;
import br.unibh.seguros.negocio.ServicoFuncionario;
import br.unibh.seguros.negocio.ServicoSetor;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteNegocioSetor {

	@Deployment  public static Archive<?> createTestArchive() { // Cria o pacote
																// que vai ser
																// instalado no
																// Wildfly para
																// realizacao
																// dos testes
																// return
																// ShrinkWrap.create(WebArchive.class,
																// "testeseguro.war")
																// .addClasses(Setor.class,
																// Pessoa.class,
																// Funcionario.class,
																// Segurado.class,
																// Proposta.class,
																// Veiculo.class,
																// Questionario.class,
																// Tramitacao.class,
																// TipoCombustivel.class,
																// EtapaProcesso.class,
																// TipoDecisao.class,
																// Resources.class,
																// DAO.class,
																// ServicoSetor.class,
																// ServicoFuncionario.class)
																// .addAsResource("META-INF/persistence.xml",
																// "METAINF/persistence.xml")
																// .addAsWebInfResource(EmptyAsset.INSTANCE,
																// "beans.xml");
																// 
		}

	// Realiza as injecoes com CDI @Inject private Logger log;

	@Inject
	private ServicoSetor ss;

	@Inject
	private ServicoFuncionario sf;

	@Test
	public void teste01_inserirSemErro() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Setor o = new Setor(null, "Tecnologia da Informação", "TI", null, null);
		ss.insert(o);
		Setor aux = (Setor) ss.findByName("Tecnologia da Informação").get(0);
		assertNotNull(aux);
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void teste02_inserirComErro() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Setor o = new Setor(null, "Tecnologia da Informação@", "TI", null, null);
			ss.insert(o);
		} catch (Exception e) {
			assertTrue(checkString(e, "Caracteres permitidos: letras, espaços, ponto e aspas simples"));
		}
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void teste03_atualizar() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Setor o = (Setor) ss.findByName("Tecnologia da Informação").get(0);
		o.setNome("Tecnologia da Informação modificado");
		ss.update(o);
		Setor aux = (Setor) ss.findByName("Tecnologia da Informação modificado").get(0);
		assertNotNull(aux);
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test  public void teste04_excluir() throws Exception {   log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());   Setor s = (Setor) ss.findByName("Tecnologia da Informação modificado").get(0);   ss.delete(s);   assertEquals(0, ss.findByName("Tecnologia da Informação modificado").size());   log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());  }

@Test  public void teste05_incluirSetorComUsuario() throws Exception {   log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());   // Persiste o setor   Setor s = new Setor(null, "Tecnologia da Informação", "TI", null, new HashSet<Funcionario>());   ss.insert(s);   // Persiste o funcionario com o setor   Funcionario f = new Funcionario(1L, "João da Silva", "M", "11111111111", "(31)2333-4444", "(31)3333-4444",     "(31)93333-4444", "joao@gmail.com", new Date(), new Date(), s, "Administrador", "joaosilva", "12345678");   sf.insert(f);   // Vincula o funcionario ao setor   s.getFuncionarios().add(f);   // Faz as alterações no banco de dados   ss.update(s);   // Recupera o setor e verifica se possui um funcionario   Setor s2 = (Setor) ss.findByNameComFuncionarios("Tecnologia da Informação").get(0);   assertEquals(1, s2.getFuncionarios().size());   // Recupera o funcionario e verifica se possui o setor   Funcionario f2 = (Funcionario) sf.findByCpfComSetor("11111111111").get(0);   assertEquals(f2.getSetor().getNome(), "Tecnologia da Informação");   log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());  }    private boolean checkString(Throwable e, String str){   if (e.getMessage().contains(str)){    return true;   } else if (e.getCause() != null){    return checkString(e.getCause(), str);   }   return false;  } }