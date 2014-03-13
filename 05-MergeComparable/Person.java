public class Person implements Comparable{
    private String name ;
    private int age ;
    
    public Person(String name, int age){
	this.name = name ;
	this.age = age ;
    }

    public String toString(){
	return name;
    }

    public int getAge(){
	return age;
    }

    public int compareTo(Object o){
	Person p = (Person) o ;
	return this.getAge() - p.getAge();
    }
}
