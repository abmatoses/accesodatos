package com.sanroman.accesodatos.hibernatetutorial.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.sanroman.accesodatos.hibernatetutorial.model.Servicio;

public class CriteriaTest {

	public static void main(String[] args) {
		Session session=null;
		Configuration cfg=new Configuration();
		SessionFactory factory=cfg.configure().buildSessionFactory();
		System.out.println("Iniciando sesion Hibernate...");
		session=factory.openSession();
		Criteria criteria=session.createCriteria(Servicio.class);
		criteria.add(Restrictions.or(Restrictions.like("nombre", "servicio%"),Restrictions.sizeGt("usuarios", 1)));
		/*Criterion c1=Restrictions.isNull("descripcion");
		Criterion c2=Restrictions.isNull("descripcion");
		Criterion c3=Restrictions.isNull("descripcion");
		Criterion c4=Restrictions.or(Restrictions.and(c1, c2), c3);
		criteria.add(c4);*/
		List<Servicio> res=criteria.list();
		for(Servicio s:res){
			System.out.println(s.getId() + ","+s.getNombre());
		}
		session.close();

	}

}
