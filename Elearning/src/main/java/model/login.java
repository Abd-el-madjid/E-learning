package model;

public class login {
    private final DaoAdmin DaoAdmin;
    private final DaoUser DaoUser;

    //
    public login() {
        this.DaoUser = new DaoUser();
        this.DaoAdmin = new DaoAdmin();
    }

    // check the login info
    // return the privilege level of the account if found
    public String authenticate(String email, String password) {
        // check if the account belongs to an admin
        boolean admin = DaoAdmin.checkadmin(email, password);

        if (admin) {
            return "admin";

        }

        // check if the account belongs to a normal user [teacher,student]
        boolean user = DaoUser.checkClogin(email, password);

        if (user) {
            return DaoUser.getType(email);

        }

        //
        return null;

    }


}