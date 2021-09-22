package fr.eni.testapp.Model;

public class User {
    private String mPseudo;

    public String getPseudo() {
        return mPseudo;
    }

    public void setPseudo(String pseudo) {
        mPseudo = pseudo;
    }

    @Override
    public String toString() {
        return "User{" +
                "mPseudo='" + mPseudo + '\'' +
                '}';
    }
}
