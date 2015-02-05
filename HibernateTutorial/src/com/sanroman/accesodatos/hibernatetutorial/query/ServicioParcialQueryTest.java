package com.sanroman.accesodatos.hibernatetutorial.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanroman.accesodatos.hibernatetutorial.model.Usuario;

public class ServicioParcialQueryTest {

	public static void main(String[] args) {
		Session session=null;
		Configuration cfg=new Configuration();
		SessionFactory factory=cfg.configure().buildSessionFactory();
		System.out.println("Iniciando sesion Hibernate...");
		session=factory.openSession();
		Query query=session.createQuery("select nombre,descripcion from Servicio");
		List<Object[]> queryRes=query.list();
		for(Object[]res:queryRes){
			System.out.print("nombre: " + res[0]);
			System.out.println(" descripcion: " + res[1]);
		}
		Criteria criteria=session.createCriteria(Usuario.class);
		session.close();

	}

}
