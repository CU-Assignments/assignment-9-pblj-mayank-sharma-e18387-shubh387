import org.hibernate.*; 
import org.springframework.transaction.annotation.Transactional; 
public class BankService { 
private SessionFactory sessionFactory; 
public BankService(SessionFactory sessionFactory) { 
this.sessionFactory = sessionFactory; 
} 
@Transactional 
public void transferMoney(int fromId, int toId, double amount) { 
Session session = sessionFactory.getCurrentSession(); 
Account from = session.get(Account.class, fromId); 
Account to = session.get(Account.class, toId); 
if (from.getBalance() < amount) { 
throw new RuntimeException("Insufficient Balance"); 
} 
from.setBalance(from.getBalance() - amount); 
to.setBalance(to.getBalance() + amount); 
session.update(from); 
session.update(to); 
BankTransaction txn = new BankTransaction(fromId, toId, amount); 
session.save(txn); 
} 
} 
