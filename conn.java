import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {

            // sql workbench username and password
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");

            s = c.createStatement();

            s.executeUpdate("Create Database if not exists library");
            s.executeUpdate("Use library");
            s.executeUpdate(
                    "Create table if not exists bookTable(bookID int primary key,bookName varchar(255),bookAuthor varchar(255), bookGenre varchar(255))");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
