package com.sanroman.accesodatos.hibernatetutorial.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanroman.accesodatos.hibernatetutorial.model.Domicilio;
import com.sanroman.accesodatos.hibernatetutorial.model.Usuario;

public class UsuarioSimpleQueryTest {

	public static void main(String[] args) {
		Session session = null;
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		System.out.println("Iniciando sesion Hibernate...");
		session = factory.openSession();
		// HQL seLect * from Usuario where name
		// SQL select * FROM USER_table where nombre='Juan'
		Query query = session.createQuery("from Usuario");
		List<Usuario> userList = query.list();
		System.out.println("Listado completo de usuarios");
		for (Usuario user : userList) {
			System.out.println(user.getName());
		}
		for (Usuario user : userList) {
			System.out.println("Usuario: " + user.getName());
			for (Domicilio d : user.getDomicilios()) {
				System.out.println("\t" + d.toString());
			}
			System.out.println("-------------------------------");
		}
		Query query2 = session
				.createQuery("from Usuario u where u.domicilios.size>1");
		System.out.println("Usuario con mas de un domicilio");
		userList = query2.list();
		for (Usuario user : userList) {
			System.out.println(user.getName());
		}
		System.out
				.println("Paginando la consulta de usuarios[tam pagina: 2, primer registro: 2]");
		Query query3 = session.createQuery("from Usuario");
		query3.setMaxResults(2);
		query3.setFirstResult(1);
		userList = query3.list();
		for (Usuario user : userList) {
			System.out.println(user.getName());
		}
		session.close();

	}

}
