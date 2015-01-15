package com.sanroman.accesodatos.hibernatetutorial.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanroman.accesodatos.hibernatetutorial.model.Usuario;

public class RecuperarUsuarioTest {

	public static void main(String[] args) {
		Session session=null;
		Configuration cfg=new Configuration();
		SessionFactory factory=cfg.configure().buildSessionFactory();
		System.out.println("Iniciando sesion Hibernate...");
		session=factory.openSession();
		Usuario user=(Usuario) session.get(Usuario.class, 34);
		user.print();
		session.close();

	}

}
