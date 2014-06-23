package md.chisinau.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberanteUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("failed to create session factory " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
