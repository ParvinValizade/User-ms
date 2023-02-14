package com.company.userms.customannotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class MyConnection {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/ms1_user?allowPublicKeyRetrieval=true&createDatabaseIfNotExist=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";

    private String username = "root";

    private String password = "password";

    public void openConnection() {
        con = null;
        try {
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
