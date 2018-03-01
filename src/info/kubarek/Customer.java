package info.kubarek;

public class Customer
{
    public Customer(String firstName, String lastName, int age, int salary)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
        setEmail(firstName + "." + lastName + "@example.com");
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return Email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        Email = email;
    }

    /**
     * @return the salary
     */
    public int getSalary()
    {
        return Salary;
    }

    /**
     * @param salary
     *            the salary to set
     */
    public void setSalary(int salary)
    {
        Salary = salary;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return LastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return FirstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public int getAge()
    {
        return Age;
    }

    public void setAge(int age)
    {
        Age = age;
    }

    private String FirstName;

    private String LastName;

    private int Age;

    private int Salary;

    private String Email;

    public String toString()
    {
        return String.format("[%s %s %d %d %s]", getFirstName(), getLastName(),
                getAge(), getSalary(), getEmail());
    }

}
