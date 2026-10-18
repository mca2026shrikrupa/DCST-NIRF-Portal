import java.io.*;
import java.lang.reflect.*;
import java.util.*;

enum Programme {
 MCA, BSC, MSC
}

enum StaffType{
 TEACHING, NON_TEACHING
}

enum ActivityType{
 ACADEMIC, NON_ACADEMIC
}

class Address {
String city;
String country;

Address(String city, String country) {
 this.city = city;
 this.country = country;
}

void displayAddress() {
 System.out.println("City: " + city);
 System.out.println("Country: " + country);
    }
}

// Feature 1 and 2: Constructors and static counter
class Student {
String id;
String name;
String department;
Address address;
Programme programme;
int batchYear;

static int studentCount = 0;

Student(String id, String name, String department,
Address address, Programme programme, int batchYear) {
this.id = id;
this.name = name;
this.department = department;
this.address = address;
this.programme = programme;
this.batchYear = batchYear;
studentCount++;
}

static void displayStudentCount() {
System.out.println("Total Students: " + studentCount);
}

void displayStudent() {
 System.out.println("\nStudent ID: " + id);
 System.out.println("Name: " + name);
 System.out.println("Department: " + department);
 System.out.println("Programme: " + programme);
 System.out.println("Batch Year: " + batchYear);
   address.displayAddress();
    }
}

// Feature 1: Shared object references
class ReferenceDemo {
static void demonstrate() {
Address sharedAddress = new Address("Goa", "India");

Student s1 = new Student("101", "Sonal", "DCST",
 sharedAddress,Programme.MCA, 2025);
        
Student s2 = new Student( "102", "Asha", "DCST", sharedAddress,Programme.MCA, 2025);

System.out.println("\nBefore changing the address:");
System.out.println("Student 1 city: " + s1.address.city);
System.out.println("Student 2 city: " + s2.address.city);

 s1.address.city = "Panaji";

System.out.println("\nAfter changing the address:");
System.out.println("Student 1 city: " + s1.address.city);
System.out.println("Student 2 city: " + s2.address.city);

s1.displayStudent();
s2.displayStudent();

Student.displayStudentCount();
}}

// Feature 3: Multiple implementation inheritance
interface AcademicActivity{
 void showAcademicActivity();
}

interface NonAcademicActivity {
 void showNonAcademicActivity();
}

// Demonstrates multiple interface implementation
class StudentActivities implements AcademicActivity, NonAcademicActivity {

public void showAcademicActivity() {
 System.out.println("Academic Activity: Midpoint Examination");}
    
public void showNonAcademicActivity() {
System.out.println("Non-Academic Activity: InfoFest");}
}

// Feature 4: Access modifiers
class Staff {
 public String name = "Ramesh";
 private double salary = 25000;
 protected String department = "DCST";

public void displayStaff() {
 System.out.println("\nStaff Name: " + name);
 System.out.println("Salary: " + salary);
 System.out.println("Department: " + department);
}}

// Feature 5: Abstract class
abstract class DepartmentMember {
String name;

DepartmentMember(String name) {
 this.name = name;
}

abstract void showRole();
}

class Teacher extends DepartmentMember{
Teacher(String name){
 super(name);
}

 void showRole() {
 System.out.println(name + " is a Teaching Staff member.");
}}

class StudentMember extends DepartmentMember{
StudentMember(String name){
super(name);}
    
void showRole(){
 System.out.println(name + " is a Student.");}
}

// Feature 5: Interface
interface ReportDisplay {
 void displayReport();
}

class NIRFReport implements ReportDisplay {
 public void displayReport() {
 System.out.println("Displaying DCST NIRF report.");
 }}

// Feature 6: Class as a type and message passing
interface Displayable {
 void display();}

class StudentReport implements Displayable{
 public void display() {
 System.out.println("Displaying student details for NIRF.");
 }}

class StaffReport implements Displayable {
 public void display(){
 System.out.println("Displaying staff details for NIRF.");
 }}

class ReportManager{
 static void showReport(Displayable report){
  report.display();
}}

// Feature 7: Method overriding
class ActivityReport{
void display(){
 System.out.println("General activity report.");
}}

class AcademicReport extends ActivityReport {
 @Override
 void display(){
 System.out.println("Academic report: Midpoint Examination.");
 }}

// Feature 7: Method overloading
class ReportPrinter{
void printReport(String name) {
System.out.println("Report Name:" + name);
}

void printReport(String name, int year) {
 System.out.println("Report Name: " + name);
 System.out.println("Year: " + year);
}}

// Feature 8: Generic class
class ReportBox<T>{
 T data;

 ReportBox(T data){
 this.data = data;
 }
 void display(){
 System.out.println("Stored Data: " + data);
 }}

// Feature 8: Generic method
class CollectionHelper {
 static <T> void displayItem(T item){
 System.out.println("Item: " + item);
 }}

// Feature 8: Generics and Collections
class NIRFCollections {
 static void demonstrate() {
 // List: stores items in order
 List<String> activities = new ArrayList<>();
 activities.add("Midpoint Examination");
 activities.add("InfoFest");
 System.out.println("List: " + activities);

// Queue: holds items to be processed
Queue<String> courses = new LinkedList<>();
courses.add("MCA");
courses.add("MSC");
System.out.println("Queue: " + courses);

// Set: stores unique items
Set<String> departments = new HashSet<>();
 departments.add("DCST");
 departments.add("DCST");
 departments.add("GBS");
 System.out.println("Set: " + departments);

 // Map: stores key-value pairs
 Map<Integer, String> students = new HashMap<>();
 students.put(101, "Sonal");
 students.put(102, "Asha");
 System.out.println("Map: " + students);

 // Demonstrate generic class
 ReportBox<String> box = new ReportBox<>("DCST NIRF Report");
 box.display();

// Demonstrate generic method
CollectionHelper.displayItem("Academic Activities");
 }}

// Feature 9: Custom exception
class InvalidStudentException extends Exception{
InvalidStudentException(String message) {
super(message);
}}

class ExceptionDemo {
  static void checkStudentId(int id) throws InvalidStudentException {
    if (id <= 0){
     throw new InvalidStudentException("Student ID must be positive.");
 }

 System.out.println("Student ID is valid: " + id);
}

 static void demonstrate(){
  
System.out.println("\n Feature 9: Exception Handling");

 try {
 checkStudentId(-1);
 } catch (InvalidStudentException e){
 System.out.println("Error: " + e.getMessage());
 } 
 finally {
 System.out.println("Student ID check completed.");
 }

//Handling a runtime error
 try {
 int number = 10 / 0;
 System.out.println(number);
    } catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero.");
 }}
}

// Classes used for cloning and persistence
class CloneAddress implements Serializable {
private static final long serialVersionUID = 1L;
String city;

 CloneAddress(String city){
 this.city = city;
 }}

class CloneStudent implements Cloneable, Serializable {
 private static final long serialVersionUID = 1L;
 String name;
 CloneAddress address;

 CloneStudent(String name, CloneAddress address) {
    this.name = name;
    this.address = address;
}

// Shallow copy
public CloneStudent shallowCopy() throws CloneNotSupportedException {
        return (CloneStudent) super.clone();
}

// Deep copy
public CloneStudent deepCopy() throws CloneNotSupportedException {
CloneStudent copy = (CloneStudent) super.clone();
 copy.address = new CloneAddress(this.address.city);
 return copy;
}}

class Feature10Demo {
 static void demonstrate() {
 System.out.println("\nReflection, I/O and Cloning");

 // 1. Reflection: inspect a class
 System.out.println("\n1. Reflection:");
 Class<?> c = CloneStudent.class;
 System.out.println("Class name: " + c.getName());

 for (Field field : c.getDeclaredFields()){
 System.out.println("Field: " + field.getName());
 }

 //File I/O: write and read a file
 System.out.println("\n2. File I/O:");

 try {
 try (FileWriter writer = new FileWriter("student.txt")) {
 writer.write("Student: Rahul\nDepartment: DCST");}
            
 try (BufferedReader reader =
 new BufferedReader(new FileReader("student.txt"))) {
 String line;
 while ((line = reader.readLine()) != null) {
 System.out.println(line);
 }}
 } catch (IOException e) {
  System.out.println("File error: " + e.getMessage());
 }

 // 3. RTTI: check the object's type at runtime
  System.out.println("\n3. RTTI:");
 CloneStudent student =
 new CloneStudent("Rahul", new CloneAddress("Goa"));

 System.out.println("Object type: " + student.getClass().getName());
 System.out.println("Is CloneStudent? " + (student instanceof CloneStudent));

 // 4. Shallow and deep cloning
    System.out.println("\n4. Cloning:");
    try {
     CloneStudent shallow = student.shallowCopy();
     CloneStudent deep = student.deepCopy();

   shallow.address.city = "Margao";
   System.out.println("Original after shallow copy: " + student.address.city);

    deep.address.city = "Panaji";

    System.out.println("Original after deep copy: " + student.address.city);
  } 
  
  catch (CloneNotSupportedException e){
    System.out.println("Cloning error: " + e.getMessage());
  }

        // 5. Persistence: save and load an object
 System.out.println("\n5. Object Persistence:");
try {
     try (ObjectOutputStream out = new ObjectOutputStream(
     new FileOutputStream("student.dat"))) {
        out.writeObject(student);
    }

     try (ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("student.dat"))) {
             CloneStudent saved = (CloneStudent) in.readObject();
            System.out.println("Saved student: " + saved.name);
            System.out.println("Saved city: " + saved.address.city);
            }

        }catch (IOException | ClassNotFoundException e) {
            System.out.println("Persistence error: " + e.getMessage());
        }}}

class Feature2Demo {
static void demonstrate() {
 System.out.println("\nStatic Variables and Enums");
 Student.displayStudentCount();

StaffType staff=StaffType.TEACHING;
ActivityType activity=ActivityType.ACADEMIC;

System.out.println("Staff Type: " + staff);
System.out.println("Activity Type: " + activity);
System.out.println("Programme options: " + Arrays.toString(Programme.values()));
}}

// Main class
public class DCSTPortal {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
int choice;
do {
 System.out.println("\nDCST NIRF PORTAL");
 System.out.println("1.Constructors and Object References");
 System.out.println("2. Static Variables and Enums");
 System.out.println("3. Multiple Interface Implementation");
 System.out.println("4. Access Modifiers");
 System.out.println("5. Abstract Classes and Interfaces");
 System.out.println("6. Class as Type and Message Passing");
 System.out.println("7. Polymorphism: Overriding and Overloading");
 System.out.println("8. Generics and Collections");
 System.out.println("9. Exception Handling");
 System.out.println("10. Reflection, File I/O, Persistence and Cloning");
 System.out.println("0. Exit");
 System.out.print("Enter your choice: ");

 if (!input.hasNextInt()){
 System.out.println("Invalid input. Please enter a number from 0 to 10.");
 input.next();
 choice = -1;
 continue; }

  choice = input.nextInt();

    switch (choice) {
      case 1:
      ReferenceDemo.demonstrate();
      break;

      case 2:
      Feature2Demo.demonstrate();
      break;

      case 3:
      System.out.println("\nMultiple Interface Implementation");
      StudentActivities activity = new StudentActivities();
      activity.showAcademicActivity();
      activity.showNonAcademicActivity();
      break;

      case 4:
      System.out.println("\nAccess Modifiers");
      Staff staff = new Staff();
      staff.displayStaff();
      System.out.println("Public name: " + staff.name);
      System.out.println("Protected department: " + staff.department);
      break;

       case 5:
        System.out.println("\nAbstract Class and Interface");
        DepartmentMember teacher = new Teacher("Rohan");
        DepartmentMember student = new StudentMember("Sonal");
        teacher.showRole();
        student.showRole();
        ReportDisplay report = new NIRFReport();
        report.displayReport();
        break;

        case 6:
        System.out.println("\nMessage Passing");
        StudentReport studentReport = new StudentReport();
        StaffReport staffReport = new StaffReport();
        ReportManager.showReport(studentReport);
        ReportManager.showReport(staffReport);
        break;

        case 7:
        System.out.println("\nPolymorphism");
        ActivityReport report1 = new AcademicReport();
        report1.display();
        ReportPrinter printer = new ReportPrinter();
        printer.printReport("DCST NIRF Report");
        printer.printReport("DCST NIRF Report", 2026);
        break;

        case 8:
        System.out.println("\nGenerics and Collections");
        NIRFCollections.demonstrate();
        break;

        case 9:
        ExceptionDemo.demonstrate();
        break;

        case 10:
        Feature10Demo.demonstrate();
        break;

        case 0:
        System.out.println("Exiting DCST NIRF Portal. Goodbye!");
        break;

        default:
        System.out.println("Invalid choice. Please select a number from 0 to 10.");
        }}
    while (choice != 0);
      input.close();
    }}