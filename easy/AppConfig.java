import org.springframework.context.annotation.*; 
@Configuration 
public class AppConfig { 
@Bean 
public Course course() { 
return new Course("Java", "3 months"); 
} 
@Bean 
public Student student() { 
return new Student("Aman", course()); 
} 
