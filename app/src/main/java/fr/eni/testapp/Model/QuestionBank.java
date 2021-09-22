package fr.eni.testapp.Model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {

    //Récupère liste question et générer une nouvelle question
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

        Collections.shuffle(mQuestionList);

        mNextQuestionIndex = 0;
    }

    public Question getQustion() {
        if (mNextQuestionIndex == mQuestionList.size()) {
            mNextQuestionIndex = 0;
        }
        return mQuestionList.get(mNextQuestionIndex++);
    }
}
