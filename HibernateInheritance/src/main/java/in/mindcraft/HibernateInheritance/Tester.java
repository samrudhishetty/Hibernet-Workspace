package in.mindcraft.HibernateInheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {
	public static void main(String[] args) {
		Account a1 = new Account();
		a1.setAccid(101);
		a1.setBalance(500);
		a1.setName("sam");
		
		
		SavingsAccount save = new SavingsAccount();
		save.setAccid(102);
		save.setInterestRate(5);
		
		CurrentAccount current = new CurrentAccount();
		save.setAccid(103);
		current.setOverLimit(1000);
		
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(a1);
		session.save(save);
		session.save(current);
		tx.commit();
	
		
		
	}
}

