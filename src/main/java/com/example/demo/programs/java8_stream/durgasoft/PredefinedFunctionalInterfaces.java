package com.example.demo.programs.java8_stream.durgasoft;

import com.example.demo.programs.java8_stream.dto.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefinedFunctionalInterfaces {
    /*
    * Predicate - to check boolean condition and return true or false
    * Function
    * Consumer
    * Supplier*/
    public static void main(String[] args) {

        /*----Predicate : can be created or String  Employee Integer or any type...:  Method Name: test(T t) )*/
        // write a predicate to check length >10 in string..
        String[] str= {"Deepak","Raj","Amar","Narendra modi","Amit sah"};
        Predicate<String> p= s-> s.length()>5;
        for(String s:str){
            if(p.test(s))
                System.out.println(s);
        }

        // Create predicate to to check length of string even--
        Predicate<String> p1= s->s.length()%2==0;
        for(String s:str){
            if(p1.test(s))
                System.out.println(s);
        }

        //create a predicate which gives salary >5000 from list of Employee..
        ArrayList<Employee> empList= new ArrayList<Employee>();
        empList.add(new Employee("Deepak","10",32,15000));
        empList.add(new Employee("Raj","10",20,25000));
        empList.add(new Employee("Shyam","10",15,85000));
        empList.add(new Employee("Rohit","10",40,1000));

        Predicate<Employee> p2= emp-> emp.getSalary()>5000;
        for(Employee e:empList){
            if(p2.test(e)){
                System.out.println(e);
            }
        }

        //Create a predicate and join with and() to check salary >5000 and age >20
        Predicate<Employee> p3= emp->emp.getSalary()>5000;
        Predicate<Employee> p4= emp->emp.getAge()>20;

        for(Employee e:empList){
            if(p3.and(p4).test(e))
                System.out.println("Employee whose sal>5000 and age >20 is:- "+e);
        }
        //Use or() to join two predicate - print employee whose salary>500 or age>20..
        for(Employee e:empList){
            if(p3.or(p4).test(e))
                System.out.println("Employe whose sal >5000 and age >20 is:- "+e);
        }

        // use .negate() method to print salary not equal to 5000..
        for(Employee e:empList){
            if(p3.negate().test(e))
                System.out.println("Employe whose samlary not >5000 are: "+e);
        }


        /* Function : - Perform some operation and return some result...: Method Name: apply()*/

        //Create a Function which takes a Integer and return square of it:...
        Function<Integer,Integer> f= i-> i*i;
        System.out.println("Function which takes integer 10 and return square of it as : "+f.apply(10));

        //Create a Function which takes string an dreturn length...
        Function<String,Integer> f2= s->s.length(); // can be replace with String:length - method ref..
        System.out.println("Length of Ramaswamy is : "+f2.apply("Ramaswamy"));

        //Create a Function which returns employee name whose salary is > than 5000 : We will create predicate to check the condition but function to return the value..
        Function<Employee,String> f3= emp-> {
            if (emp.getSalary()>5000) return emp.getName();
            return emp.getName()+"'s salary less than 5000";
        };
        for(Employee e:empList){
           System.out.println("Employee name is "+f3.apply(e));
        }

        //Function Chaining - create two function and call both ...
        // Create two function one which gives sware other which gives cube and call accordingly as needd,...
        Function<Integer,Integer> f5= i->i*i;
        Function<Integer,Integer> f6= i->i*i*i;

        System.out.println(f5.andThen(f6).apply(10));// - apply first f5 then f6 on result..
        System.out.println(f6.andThen(f5).apply(4));//apply first f6 then f5 on result

        System.out.println("------INSIDE CONSUMER-----------------------------------------------------");
        /* Consumer: Doesnot retunr any value just do some operation... Method Name: accept(Object o)*/
        // Create a Consumer which prints ndame salary>500 and age.. use Function for salary..
        Consumer<Employee> c1= emp->{
          System.out.println("Name is "+emp.getName());
          System.out.println("Age is "+emp.getAge());
          System.out.println(f3.apply(emp));// instead of condtion which filters employee sal>500 we can resuse Function already created.
        };
        for(Employee e:empList){
            if(p4.test(e))// instead of condition we can reuse predicated already created...
                c1.accept(e);
        }

        /* Supplier : No input jsut give some output as supplier logic Method NAme: get()
        * eg: If we need date obejct , or random OTP generation..which wont take any input but will just give output.*/

        //Crate a supplier which give current date when eever required..
        Supplier<Date> s= ()->new Date(); // method ref can be used - Date:new
        System.out.println(s.get());

        // Cateate a Supplier to generate radndom OTP when so ever needed-----
        Supplier<Integer> s2=()->{
            int otp=0;
            otp= (int) (otp+Math.random()*100000);// *100 as random will give 0.99999 so t get whole number we multiply by 10 or more..
            return otp;
        };
        System.out.println("OTP Generated is "+s2.get());
    }
}
