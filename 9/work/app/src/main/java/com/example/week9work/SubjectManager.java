package com.example.week9work;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("콜드 브루");
        subjectList.add("자바 칩 프라푸치노");
        subjectList.add("쿨 라임 피지오");
        subjectList.add("돌체 라떼");
        subjectList.add("망고 패션 푸르트 블랜디드");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }
    public String getSubjectByPos(int pos) {
        return subjectList.get(pos);
    }
    //    추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

    //    삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }
    public void updateSubject(int pos, String subject) {
        subjectList.set(pos, subject);
    }

}
