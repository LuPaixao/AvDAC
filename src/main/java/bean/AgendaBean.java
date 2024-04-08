package bean;

import java.util.List;

import javax.annotation.ManagedBean;

import dao.AgendaDao;
import entidades.Agenda;

@ManagedBean
public class AgendaBean {
	
	private Agenda agenda = new Agenda();
	private List<Agenda> lista;
	
	public String salvar() {
		AgendaDao.salvar(agenda);
		agenda = new Agenda();
		return null;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Agenda> getLista() {
		if (lista == null) {
			lista = AgendaDao.listar();
		}
		return lista;
	}

	public void setLista(List<Agenda> lista) {
		this.lista = lista;
	}
	
	
}
