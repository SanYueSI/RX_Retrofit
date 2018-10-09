package app.refactoring.com.refactoringretrofit.bean;

import java.util.List;

/**
 * unknown at 2018/7/25
 */

public class TitleModel {
    private List<Title> mTitleList;

    public List<Title> getTitleList() {
        return mTitleList;
    }

    public void setTitleList(List<Title> titleList) {
        mTitleList = titleList;
    }

    public static class Title {
        private String title;
        private boolean isShow;

        public boolean isShow() {
            return isShow;
        }

        public void setShow(boolean show) {
            isShow = show;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
