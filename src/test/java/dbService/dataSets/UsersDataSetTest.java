package dbService.dataSets;

import dbService.HibernateUtil;
import org.junit.Test;

public class UsersDataSetTest {
    UserDataSet userDataSet = new UserDataSet();

    @Test
    public void testAddUser() throws Exception {
        System.out.println("Id "+userDataSet.addUser("Sergey", "1234", 34, "Chkalova"));
        System.out.println("Id "+userDataSet.addUser("Ivan", "Boss", 40, "Nikolaev siti"));

        System.out.println(userDataSet.getUserForName("Sergey"));

        Users users = userDataSet.getUserForName("Sergey");
        users.setPassword("12345");
        users.setAge(45);
        users.setAdress("Nikolaev, Chkalova str.");
        userDataSet.updateUser(users);

        System.out.println(userDataSet.userContains("Ivan"));

        System.out.println(userDataSet.readAllUser());

        System.out.println(userDataSet.userDel("Sergey", "12345"));

        System.out.println(userDataSet.userDel("Ivan", "Boss"));

        HibernateUtil.shutdown();

    }
}