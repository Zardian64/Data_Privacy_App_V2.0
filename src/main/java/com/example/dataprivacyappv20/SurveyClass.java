package com.example.dataprivacyappv20;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class SurveyClass {

    private static String question1;
    private static String a1, a2, a3, a4;
    private static String Name;



    public SurveyClass() {

    }

    public static String getQuestion() { return question1; }
    public static void setQuestion(String question) {question1 = question; }

    public static void setName(String name) { Name = name;}
    public static String getName() { return Name; }

    public static String getA1() { return a1; }
    public static String getA2() { return a2; }
    public static String getA3() { return a3; }
    public static String getA4() { return a4; }

    public static void setA1(String a1) { SurveyClass.a1 = a1; }
    public static void setA2(String a2) { SurveyClass.a2 = a2; }
    public static void setA3(String a3) { SurveyClass.a3 = a3; }
    public static void setA4(String a4) { SurveyClass.a4 = a4; }
}

