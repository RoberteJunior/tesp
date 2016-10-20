package br.unibh.seguros.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.seguros.entidades.Funcionario;
import br.unibh.seguros.entidades.Setor;

@Stateless
@LocalBean
public class ServicoFuncionario implements DAO<Funcionario, Long> {
	@Inject
	EntityManager em;

	@Inject
	private Logger log;

	@Inject
	private ServicoSetor ss;
	
	@Override
	public Funcionario insert(Funcionario t) throws Exception {
		log.info("Persistindo " + t);
		em.persist(t);
		return t;
	}

	@Override
	public Funcionario update(Funcionario t) throws Exception {
		log.info("Atualizando " + t);
		return em.merge(t);
	}

	@Override
	public void delete(Funcionario t) throws Exception {
		log.info("Removendo " + t);
		Object c = em.merge(t);
		em.remove(c);
	}

	@Override
	public Funcionario find(Long k) throws Exception {
		log.info("Encontrando pela chave " + k);
		return em.find(Funcionario.class, k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> findAll() throws Exception {
		log.info("Encontrando todos os objetos");
		return em.createQuery("from Funcionario").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> findByName(String name) throws Exception {
		log.info("Encontrando o " + name);
		return em.createNamedQuery("Funcionario.findByName").setParameter("nome", name + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> findByNameComFuncionarios(String name) throws Exception {
		log.info("Encontrando o " + name);
		return em.createNamedQuery("Funcionario.findByNameComFuncionarios").setParameter("nome", name + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> findByCpfComFuncionario(String name) throws Exception {
		log.info("Encontrando o " + name);
		return em.createNamedQuery("Funcionario.findByCpfComFuncionario").setParameter("cpf", name + "%")
				.getResultList();
	}

	public List<String> getPermissoes(Setor setor) {

		ArrayList<String> lista = new ArrayList<String>();

		if (hierarquiaSetorPossui(setor, "Atendimento")) {

			lista.add("Gerente de Atendimento");
			lista.add("corretor");
		} else if (hierarquiaSetorPossui(setor, "Concessão")) {

			lista.add("Gerente de Concessão");
			lista.add("Analista de Concessão");
		} else if (hierarquiaSetorPossui(setor, "Financeiro")) {

			lista.add("Gerente Financeiro");
			lista.add("Analista financeiro");
		} else if (hierarquiaSetorPossui(setor, "Tecnologia da Informação")) {

			lista.add("Gerente de TI");
			lista.add("Administrador");
		} else if (hierarquiaSetorPossui(setor, "Diretoria")) {

			lista.add("Diretoria");
		}
		lista.add("Consulta");
		return lista;

	}

	public boolean hierarquiaSetorPossui(Setor setor, String nome){
		try{
			if (setor != null) {
				if (setor.getNome().startsWith(nome)){
					return true;
				}
				Setor s = ss.findByIDComSetorSuperior(setor.getId()).get(0);
				if (s.getSetorSuperior() != null){
					return hierarquiaSetorPossui(s.getSetorSuperior(),nome);
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

}