import javax.persistence.*; 
import java.util.Date; 
@Entity 
public class Transaction { 
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private int txnId; 
private int fromAcc; 
private int toAcc; 
private double amount; 
private Date txnDate = new Date(); 
// Constructors, getters, setters 
} 
