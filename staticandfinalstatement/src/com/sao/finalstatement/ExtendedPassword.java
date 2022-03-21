package com.sao.finalstatement;

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

//    @Override // we change to parent class this field -> (final)
//    public void storePassword() {
//        System.out.println("Saving password = " + this.decryptedPassword);
//    }
}
