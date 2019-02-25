package com.example.inspectordemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;

@Service
public class ExampleService {

    public String piyopiyoMethod(String arg1, Integer arg2) {
        String ret = "";
        if (Strings.isNullOrEmpty(arg1) || Objects.isNull(arg2)) {
            ret = "input NULL.";
        } else if (Strings.isNullOrEmpty(arg1) && Objects.isNull(arg2)) {
            ret = generatePiyoString(arg1);
        } else if (Strings.isNullOrEmpty(arg1) && Objects.nonNull(arg2)) {
            ret = generateHogeString(arg2);
        } else {
            ret = generatePiyoString(arg1) + " / " + generateHogeString(arg2);
        }
        return ret;
    }

    private String generateHogeString(@NonNull Integer arg1) {
        String ret = "";
        if (0 < arg1 && arg1 < 10) {
            ret = "That num is too little : " + arg1 + ".";
        } else if (10 == arg1) {
            ret = "That num is enough value : " + arg1 + ".";
        } else if (10 < arg1) {
            ret = "That num is enough value : " + arg1 + ".";
        } else {
            ret = "That num is not interested.";
        }
        return ret;
    }

    private String generatePiyoString(@NonNull String arg1) {
        String ret = "";

        if (arg1.endsWith("a")) {
            ret = "str startWith " + arg1.substring(0, 1).toUpperCase() + "and endWith A.";
        } else if (arg1.endsWith("b")) {
            ret = "str startWith " + arg1.substring(0, 1).toUpperCase() + "and endWith B.";
        } else {
            ret = "str startWith " + arg1.substring(0, 1).toUpperCase() + "and endWith Otners.";
        }
        return ret;
    }

    private void badPracticeMethod() {
        // 不要な代入
        String name = null; // ここの代入は不要
        if (true) {
            name = "foo";
        } else {
            name = "bar";
        }

        // 同じ式
        String a = "abcdefg".toUpperCase().substring(0, 2).replace("a", "b").toString();
        String b = "aaaaaaa".toUpperCase().substring(0, 2).replace("a", "b").toString();
        String c = "zzzzzzz".toUpperCase().substring(0, 2).replace("a", "b").toString();
        String d = "1234567".toUpperCase().substring(0, 2).replace("a", "b").toString();

        // 思考停止の StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("The specified value = [");
        sb.append("hoge");
        sb.append("] is illegal.");
        String result = sb.toString();

        // Java7まで
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        StringBuilder sb2 = new StringBuilder();
        for (String e : list) {
            if (sb2.length() > 0)
                sb2.append(", ");
            sb2.append(e);
        }
        String result2 = sb2.toString();

        if (result != null && result.length() > 0) {
            if(result2 != null && result.length() > 0) {
                if (result.equals(result2)) {
                    System.out.println("equals!!");
                } else {
                    System.out.println("not equals!!");
                }                
            }
        }
    }
}
