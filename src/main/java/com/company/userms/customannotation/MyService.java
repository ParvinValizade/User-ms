package com.company.userms.customannotation;

import com.company.userms.model.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    DbAccess db;

    public List<User> getAll() {
        List<User> students = db.getResultList("select * from users");
        return students;
    }

    public void insertStudent(User s) {
        db.executeUpdate("insert into users(id,firstname,lastname,pin) values(?,?,?,?)",
                Arrays.asList(s.getId(),s.getFirstname(), s.getLastname(), s.getPin()));

    }

    public void updateStudent(User s) {
        db.executeUpdate("update users set firstname=?,lastname=?,pin=? where id=",
                Arrays.asList(s.getFirstname(), s.getLastname(), s.getPin(), s.getId() + ""));
    }

    @MyTransactional
    public void insertStudents() {
        insertStudent(User.builder()
                .id("id1")
                .firstname("Parvin101")
                .lastname("Valizade")
                .pin("gfhjdfgt101")
                .build());
        insertStudent(User.builder()
                .id("dergfw202")
                .firstname("Parvin202")
                .lastname("Valizade")
                .pin("gfhjddffr202")
                .build());
        insertStudent(User.builder()
                .id("csertyus303")
                .firstname("Parvin303")
                .lastname("Valizade")
                .pin("gfhjdkd2sders303")
                .build());
    }

    @MyTransactional
    public void insertStudentsExcp() {
        insertStudent(User.builder()
                .id("dqwsdr606")
                .firstname("Parvin808")
                .lastname("Valizade")
                .pin("gfhjdkd5sdcdt606")
                .build());
        User s = getAll().get(0);
        s.setFirstname("Parvin800");
        updateStudent(s);

    }
}
