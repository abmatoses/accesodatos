package com.sanroman.accesodatos.hibernatetutorial.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanroman.accesodatos.hibernatetutorial.model.*;
public class SQLInjectionTest {

	public static void main(String[] args) {
		Session session=null;
		Configuration cfg=new Configuration();
		SessionFactory factory=cfg.configure().buildSessionFactory();
		System.out.println("Iniciando sesion Hibernate...");
		session=factory.openSession();
		String id="23 or 1=1";
		Query query=session.createQuery("from Usuario where name=?");
		query.setParameter(0,id);
		List<Usuario> list=query.list();
		if(list.size()>0)System.out.println("usuario autenticado...");
		else System.out.println("Usuario no autenticado...");
		session.close();

	}

}
