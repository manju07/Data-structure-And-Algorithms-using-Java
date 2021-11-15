package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 */
class InnerEmpMgrCount {

    static Map<String, Integer> getEmpsUnderMgrCount(Map<String, String> empMgr) {
        Map<String, List<String>> mgrEmp = new HashMap<String, List<String>>();
        for (Map.Entry<String, String> data : empMgr.entrySet()) {
            String emp = data.getKey();
            String mgr = data.getValue();
            if (!emp.equals(mgr)) {
                List<String> empList = mgrEmp.get(mgr);
                if (!mgrEmp.containsKey(mgr)) {
                    empList = new ArrayList<String>();
                }
                empList.add(emp);
                mgrEmp.put(mgr, empList);
            }
        }

        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for (String emp : empMgr.keySet()) {
            populateResult(emp, mgrEmp, resultMap);
        }
        return resultMap;
    }

    static int populateResult(String emp, Map<String, List<String>> mgrEmp, Map<String, Integer> resultMap) {
        int count = 0;
        if (!mgrEmp.containsKey(emp)) {
            resultMap.put(emp, 0);
            return 0;
        } else if (resultMap.containsKey(emp))
            count = resultMap.get(emp);
        else {
            List<String> empList = mgrEmp.get(emp);
            count = empList.size();
            for (String tempEmp : empList) {
                count += populateResult(tempEmp, mgrEmp, resultMap);
            }
            resultMap.put(emp, count);
        }
        return count;
    }

}

/**
 * EmpMgrCount
 */
public class EmpMgrCount {

    public static void main(String[] args) {
        Map<String, String> empMgr = new HashMap<String, String>();
        empMgr.put("A", "C");
        empMgr.put("B", "C");
        empMgr.put("C", "F");
        empMgr.put("D", "E");
        empMgr.put("E", "F");
        empMgr.put("F", "F");
        Map<String, Integer> resultMap = InnerEmpMgrCount.getEmpsUnderMgrCount(empMgr);
        System.out.println(resultMap);
    }
}