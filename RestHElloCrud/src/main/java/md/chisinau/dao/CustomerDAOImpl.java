package md.chisinau.dao;

import java.util.List;

import md.chisinau.pojo.Customers;
import md.chisinau.util.HiberanteUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAOImpl implements CustomersDAO {

	public List<Customers> getAllCustomers() {
		List<Customers> result = null;
		Session session = null;
		session = HiberanteUtil.getSessionFactory().openSession();
		session.beginTransaction();
		result = session.createCriteria(Customers.class).list();
		session.getTransaction().commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
		return result;
	}

	public Customers getCustomerById(int id) {
		Session session = null;
		Transaction transaction = null;
		Customers customer = null;
		try {
			session = HiberanteUtil.getSessionFactory().openSession();
			customer = (Customers) session.get(Customers.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return customer;
	}

	public void updateCustomer(Customers customer) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HiberanteUtil.getSessionFactory().openSession();
			tx = session.getTransaction();
			tx.begin();
			session.update(customer);
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteCustomer(Customers customer) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HiberanteUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();
			session.delete(customer);
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void addCustomer(Customers customer) {
		Session session = null;
		try {
			session = HiberanteUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
