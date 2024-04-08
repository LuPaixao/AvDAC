package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Agenda;
import util.JPAUtil;

public class AgendaDao {
	
	public static void salvar(Agenda agenda) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(agenda);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void atualizar(Agenda agenda) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Agenda agenda) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		agenda = em.find(Agenda.class, agenda.getId());
		em.remove(agenda);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Agenda> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select g from Agenda g");
		List<Agenda> resultado = q.getResultList();
		em.close();
		return resultado;
	}
	
	public static Long contar() {
		 EntityManager em = JPAUtil.criarEntityManager();
		 Query q = em.createQuery("select g from Agenda g");
		 Long quantidade = (Long) q.getSingleResult();
		 em.close();
		 return quantidade;
	}
	
}
