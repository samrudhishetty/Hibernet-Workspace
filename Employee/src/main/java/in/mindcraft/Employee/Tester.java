package in.mindcraft.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class Tester {

	public static void main(String[] args) {
		
		Address a1 = new Address();
		a1.setCity("thane");
		a1.setState("MH");
		a1.setStreet("majiwade");
		
		Employee e1 = new Employee();
		e1.setEmpid(1);
		e1.setName("sam");
		
		e1.getList().add(a1);

		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		
		
		session.save(a1);
		session.save(e1);
		
		tx.commit();

	}

}
