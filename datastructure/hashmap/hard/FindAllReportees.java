package datastructure.hashmap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Find all reportees for every manager
 * @category HashMap
 * @author Manjunath Asundi
 */
public class FindAllReportees {

    // A —> A
    // B —> A
    // C —> B
    // D —> B
    // E —> D
    // F —> E
    // Employee->Manager
    // For each of the employee who are the reportees

    // A -> {B}
    // B -> {C,D};
    // D -> {E}
    // E -> {F}

    // A -> {B,C,D,E,F}
    // B -> {C,D,E,F}
    // D -> {E, F}
    // E -> {F}

    public static void getResultList(Character mgr, Map<Character, List<Character>> mgrToEMap,
            List<Character> resultList) {
        if (!mgrToEMap.containsKey(mgr))
            return;
        List<Character> empList = mgrToEMap.get(mgr);
        for (Character emp : empList) {
            resultList.add(emp);
            getResultList(emp, mgrToEMap, resultList);
        }
    }

    public static void findAllReportees(Map<Character, Character> empToMgr) {
        Map<Character, List<Character>> mgrToEmp = new HashMap<>();
        Map<Character, ArrayList<Character>> resultMap = new HashMap<>();
        for (Map.Entry<Character, Character> entry : empToMgr.entrySet()) {
            if (entry.getKey() == entry.getValue())
                continue;
            List<Character> list = new ArrayList<>();
            if (!mgrToEmp.containsKey(entry.getValue())) {
                list.add(entry.getKey());
            } else {
                list = mgrToEmp.get(entry.getValue());
                list.add(entry.getKey());
            }
            mgrToEmp.put(entry.getValue(), list);
        }

        for (Map.Entry<Character, List<Character>> entry : mgrToEmp.entrySet()) {
            Character mgr = entry.getKey();
            ArrayList<Character> resultList = new ArrayList<Character>();
            getResultList(mgr, mgrToEmp, resultList);
            resultMap.put(mgr, resultList);
        }

        for (Entry<Character, ArrayList<Character>> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<Character, Character> empToMgr = new HashMap<>();

        // X-> {Y, Z}
        // Y-> {P}

        // A —> A
        empToMgr.put('A', 'A');
        // B —> A
        empToMgr.put('B', 'A');
        // C —> B
        empToMgr.put('C', 'B');
        // D —> B
        empToMgr.put('D', 'B');
        // E —> D
        empToMgr.put('E', 'D');
        // F —> E
        empToMgr.put('F', 'E');
        // Y->X
        empToMgr.put('Y', 'X');
        // Z->X
        empToMgr.put('Z', 'X');
        // P->Y
        empToMgr.put('P', 'Y');
        // X->A
        empToMgr.put('X', 'A');
        findAllReportees(empToMgr);
    }
}