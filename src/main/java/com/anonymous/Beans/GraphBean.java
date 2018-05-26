package com.anonymous.Beans;

import java.util.List;

/**
 * Created by akash.mercer on 15-05-2016.
 */
public class GraphBean {

    private List<String> graphNameList;

    private List<Integer> graphValueList;

    private String email;

    public GraphBean(){

    }

    public List<String> getGraphNameList() {
        return graphNameList;
    }

    public void setGraphNameList(List<String> graphNameList) {
        this.graphNameList = graphNameList;
    }

    public List<Integer> getGraphValueList() {
        return graphValueList;
    }

    public void setGraphValueList(List<Integer> graphValueList) {
        this.graphValueList = graphValueList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
