package app.refactoring.com.refactoringretrofit.bean;

import java.util.List;

/**
 * unknown at 2018/7/24
 */

public class ChangeModel {
    private List<Title> mTitles;

    public List<Title> getTitles() {
        return mTitles;
    }

    public void setTitles(List<Title> titles) {
        mTitles = titles;
    }

    public static class Title {
        private String       problem;
        private List<Answer> mAnswers;

        public String getProblem() {
            return problem;
        }

        public void setProblem(String problem) {
            this.problem = problem;
        }

        public List<Answer> getAnswers() {
            return mAnswers;
        }

        public void setAnswers(List<Answer> answers) {
            mAnswers = answers;
        }
    }

    public static class Answer {
        private String  strAnswer;
        private boolean isShow;

        public boolean isShow() {
            return isShow;
        }

        public void setShow(boolean show) {
            isShow = show;
        }

        public String getStrAnswer() {
            return strAnswer;
        }

        public void setStrAnswer(String strAnswer) {
            this.strAnswer = strAnswer;
        }
    }
}
