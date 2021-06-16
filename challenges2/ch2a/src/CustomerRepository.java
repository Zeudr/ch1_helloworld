import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerRepository {

    protected void checkDbConnection(Statement statement) {
        if (statement == null) {
            throw new IllegalStateException("Error --> DB-Connection Failed");
        }
    }

    protected Statement makeDBConnection(String url, String user, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Session makeHBConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer");
        EntityManager entityManager = emf.createEntityManager();

        return entityManager.unwrap(org.hibernate.Session.class);
    }

    protected void prepDB(Statement statement, boolean isMysqlDB) {
        String keyWord;
        if (isMysqlDB) {
            keyWord = "AUTO_INCREMENT";
        } else {
            keyWord = "IDENTITY";
        }

        String dropTable = "DROP TABLE IF EXISTS Customer";
        String createTable = String.format("CREATE TABLE Customer(Id int NOT NULL %s, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));", keyWord);

        try {
            statement.execute(dropTable);
            statement.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void savePerson(Statement statement, String firstname, String lastname) {
        String insertQuery = String.format("INSERT INTO Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname);

        try {
            statement.executeUpdate(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void getPerson(Statement statement, String firstname, String lastname) {
        String selectQuery = String.format("FROM Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname);

        Customer customer = createCustomer(selectQuery);
        System.out.println(String.format("Saved in DB --> %s %s", customer.getFirstname(), customer.getLastname()));
    }

    private Customer createCustomer(String selectQuery) {
        Session session = makeHBConnection();
        session.beginTransaction();
        List<Customer> customers = session.createQuery(selectQuery).getResultList();
        session.getTransaction().commit();
        session.close();

        return new Customer(customers.get(0).getFirstname(), customers.get(0).getLastname());
    }

}
