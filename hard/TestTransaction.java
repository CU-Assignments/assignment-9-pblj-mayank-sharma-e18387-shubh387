public class MainApp { 
public static void main(String[] args) { 
AnnotationConfigApplicationContext ctx = new 
AnnotationConfigApplicationContext(AppConfig.class); 
BankService service = ctx.getBean(BankService.class); 
try { 
service.transferMoney(101, 102, 500); 
System.out.println("Transaction Successful!"); 
} catch (Exception e) { 
System.out.println("Transaction Failed: " + e.getMessage()); 
} 
ctx.close(); 
} 
} 
