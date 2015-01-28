package com.sanroman.accesodatos.hibernatetutorial.queries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		for (Usuario user : userList) {
			System.out.println(user.getName());
		}
		session.close();
	}

}
