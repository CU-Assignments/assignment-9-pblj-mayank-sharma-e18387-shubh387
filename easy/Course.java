public class Course { 
private String courseName; 
private String duration; 
public Course(String courseName, String duration) { 
this.courseName = courseName; 
this.duration = duration; 
} 
public String getCourseName() { return courseName; } 
public String getDuration() { return duration; } 
@Override 
public String toString() { 
return "Course: " + courseName + ", Duration: " + duration; 
} 
}
