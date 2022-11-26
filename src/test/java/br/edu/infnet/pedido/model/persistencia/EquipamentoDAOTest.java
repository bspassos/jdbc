package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Equipamento;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EquipamentoDAOTest {

	
	@Before
	public void inicializar() {
		IDAO equipamentoDAO = new EquipamentoDAO();
		Equipamento equipamento = new Equipamento("Monitor 17", 30f);
		equipamentoDAO.salvar(equipamento);
	}
	
	
	@Test
	public void test() {
		IDAO equipamentoDAO = new EquipamentoDAO();
		Equipamento equipamento = new Equipamento("Monitor 17", 30f);
		boolean validacao = equipamentoDAO.salvar(equipamento);
		Assert.assertTrue(validacao);
	}
	

	@Test
	public void testUpdate() {
		IDAO equipamentoDAO = new EquipamentoDAO();
		List<Equipamento> lista = equipamentoDAO.listarTodos();
		Equipamento equipamento = new Equipamento("Desktop Dell Core i7", 280f, lista.get(0).getId());
		boolean validacao = equipamentoDAO.atualizar(equipamento);
		Assert.assertTrue(validacao);
	}


	@Test
	public void testDelete() {
		IDAO equipamentoDAO = new EquipamentoDAO();
		List<Equipamento> lista = equipamentoDAO.listarTodos();
		Equipamento equipamento = new Equipamento(lista.get(lista.size()-1).getId());
		boolean validacao = equipamentoDAO.deletar(equipamento);
		Assert.assertTrue(validacao);
	}
	
	
	@Test
	public void testListaEquipamentos() {
		IDAO equipamentoDAO = new EquipamentoDAO();
		List<Equipamento> lista = equipamentoDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	

	@Test
	public void testObterEquipamento() {
		IDAO equipamentoDAO = new EquipamentoDAO();
		List<Equipamento> lista = equipamentoDAO.listarTodos();
		Equipamento equipamento = (Equipamento) equipamentoDAO.obter(lista.get(0).getId());
		Assert.assertNotNull(equipamento);;
	}
	

}
