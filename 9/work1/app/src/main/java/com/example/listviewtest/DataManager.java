package com.example.listviewtest;

import java.util.ArrayList;

public class DataManager {

        private ArrayList<String> subjectList;

        public DataManager(){
            subjectList = new ArrayList<String>();
            subjectList.add("모바일 소프트웨어");
            subjectList.add("네트워크");
            subjectList.add("웹서비스");
            subjectList.add("운영체제");
            subjectList.add("웹프로그래밍2");
        }

        public ArrayList<String> getSubjectList(){
            return subjectList;
        }

        public void addData(String newSubject){
            subjectList.add(newSubject);
        }

        public void removeData(int idx){
            subjectList.remove(idx);
        }

}
