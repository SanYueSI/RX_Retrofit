package app.refactoring.com.refactoringretrofit.bean;

import java.util.List;

/**
 * unknown at 2018/6/19
 */

public class FoodDataOut {
    private Result result;
    private String resultcode;
    private String reason;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result {
        private List<Data> data;

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
    }

  public class Data {
        private String title;
        private String burden;
        private List<String> albums;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBurden() {
            return burden;
        }

        public void setBurden(String burden) {
            this.burden = burden;
        }

      public List<String> getAlbums() {
          return albums;
      }

      public void setAlbums(List<String> albums) {
          this.albums = albums;
      }
  }
}

