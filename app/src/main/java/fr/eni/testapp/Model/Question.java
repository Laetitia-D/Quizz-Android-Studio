package fr.eni.testapp.Model;

import java.util.List;

public class Question {

    //Classe pour les questions, liste des questions et index bonne réponse
    private String mQuestion;
    private List<String> mChoiceList;
    private int mReponseIndex;

    public Question(String question, List<String> choiceList, int reponseIndex) {
        this.setQuestion(question);
        this.setChoiceList(choiceList);
        this.setReponseIndex(reponseIndex);
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        mChoiceList = choiceList;
    }

    public int getReponseIndex() {
        return mReponseIndex;
    }

    public void setReponseIndex(int reponseIndex) {
        mReponseIndex = reponseIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mChoiceList=" + mChoiceList +
                ", mReponseIndex=" + mReponseIndex +
                '}';
    }
}
