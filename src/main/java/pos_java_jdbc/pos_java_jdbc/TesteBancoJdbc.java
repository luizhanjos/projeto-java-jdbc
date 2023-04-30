package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

@SuppressWarnings("restriction")
public class TesteBancoJdbc {

	@Test
	public void initInsert() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userPosJava = new Userposjava();

		userPosJava.setNome("Sara");
		userPosJava.setEmail("saraputa@gmail.com");

		userPosDAO.salvar(userPosJava);

	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(6L);

			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() {

		try {
			UserPosDAO dao = new UserPosDAO();

			Userposjava objBanco = dao.buscar(6L);

			objBanco.setNome("Nome mudado");

			dao.atualizar(objBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initDeletar() {

		try {

			UserPosDAO dao = new UserPosDAO();

			dao.deletar(13L);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initDeletarTudo() {

		try {

			UserPosDAO dao = new UserPosDAO();

			dao.deletarTudo();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void salvarTelefone() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Telefone telefone = new Telefone();

		telefone.setNumero("(71)9 9160-6278");
		telefone.setTipo("cel");
		telefone.setUsuario(99L);

		userPosDAO.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregarFonesUser() {
		
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFone = dao.listarUserFone(16L);
		
		for (BeanUserFone beanUserFones : beanUserFone) {
			System.out.println(beanUserFones);
			System.out.println("================================================================================");
		}
	}
	
	@Test
	public void deleteFoneAndUser() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFoneForUser(17L);
		
	}
}