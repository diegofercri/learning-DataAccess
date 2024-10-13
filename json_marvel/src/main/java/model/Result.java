package model;

import java.util.List;

public class Result {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private List<Character> results;

        public List<Character> getResults() {
            return results;
        }

        public void setResults(List<Character> results) {
            this.results = results;
        }
    }
}
