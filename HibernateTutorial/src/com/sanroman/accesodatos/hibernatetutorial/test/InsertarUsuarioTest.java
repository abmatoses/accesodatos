package com.sanroman.accesodatos.hibernatetutorial.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sanroman.accesodatos.hibernatetutorial.model.Domicilio;
import com.sanroman.accesodatos.hibernatetutorial.model.Empresa;
import com.sanroman.accesodatos.hibernatetutorial.model.Servicio;
import com.sanroman.accesodatos.hibernatetutorial.model.Usuario;

public class InsertarUsuarioTest {

	public static void main(String[] args) {
		Session session = null;
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		System.out.println("Iniciando sesion Hibernate...");
		session = factory.openSession();
		System.out.println("Sesion Hibernate iniciada...");
		Transaction tr = session.beginTransaction();
		// Creando usuario
		Domicilio d1 = new Domicilio();
		d1.setTipoVia(1);
		// d1.setCodigoPostal(28020);
		d1.setNombreVia("luna");
		d1.setNumero(20);

		Domicilio d2 = new Domicilio();
		d2.setTipoVia(2);
		// d2.setCodigoPostal(28030);
		d2.setNombreVia("sol");
		d2.setNumero(20);

		Usuario user = new Usuario();
		user.setEmail("luis@gmail.com");
		user.setName("Jose");
		user.setTelefono("913345566");
		user.getDomicilios().add(d1);
		user.getDomicilios().add(d2);

		session.save(user);

		Empresa e = new Empresa();
		e.setCIF("ff666799");
		e.setCodEmpresa("emp1234");
		e.setTelefono("916667755");
		e.setUrl("http://alvan.com");
		session.save(e);

		Servicio s = new Servicio();
		s.setDescripcion("servicios de fontaneria");
		s.setEmpresa(e);
		s.setId(12);
		s.setNombre("fontaneria");
		session.save(s);

		tr.commit();
		session.close();
		System.out.println("Cerrando sesion Hibernate...");
	}

}
