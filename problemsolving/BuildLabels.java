package problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all Labels from given folders
 * 
 * @author Manjunath Asundi
 */
public class BuildLabels {

    /**
     * Folder
     */
    static class Folder {
        int id;
        String displayName;
        int parentId;

        Folder(int id, String displayName, int parentId) {
            this.id = id;
            this.displayName = displayName;
            this.parentId = parentId;
        }
    }

    /**
     * Label
     */
    static class Label {
        String displayName;

        Label(String displayName) {
            this.displayName = displayName;
        }
    }

    public static List<Label> buildLabels(List<Folder> fList) {
        Map<Integer, Folder> rootChildMap = new HashMap<>();
        List<Label> labels = new ArrayList<>();
        for (int i = 0; i < fList.size(); i++) {
            for (int j = 0; j < fList.size(); j++) {
                if (fList.get(i).parentId == fList.get(j).id)
                    rootChildMap.put(fList.get(i).id, fList.get(j));
            }
        }
        Map<Integer, String> resultMap = new HashMap<>();
        for (int i = 0; i < fList.size(); i++) {
            Folder folder = fList.get(i);
            String displayName = "";
            if (folder.parentId != -1) {
                displayName = buildLabelsUtil(rootChildMap, folder, displayName, resultMap);
                resultMap.put(folder.id, displayName);
            } else {
                displayName = folder.displayName;
                resultMap.put(folder.id, folder.displayName);
            }
            labels.add(new Label(displayName));
        }
        return labels;
    }

    public static String buildLabelsUtil(Map<Integer, Folder> rootChildMap, Folder folder, String displayName,
            Map<Integer, String> resultMap) {
        if (folder.parentId == -1)
            return folder.displayName;
        if (resultMap.containsKey(folder.id))
            return resultMap.get(folder.id);
        String resultString = displayName + folder.displayName;
        String temp = buildLabelsUtil(rootChildMap, rootChildMap.get(folder.id), displayName, resultMap);
        if (temp != null)
            resultString = temp + "/" + resultString;
        if (!resultMap.containsKey(folder.id))
            resultMap.put(folder.id, resultString);
        return resultString;
    }

    public static void main(String[] args) {
        List<Folder> folderList = new ArrayList<Folder>();
        folderList.add(new Folder(1, "A", -1));
        folderList.add(new Folder(2, "B", 1));
        folderList.add(new Folder(3, "C", 1));
        folderList.add(new Folder(4, "D", 2));
        folderList.add(new Folder(5, "E", 3));
        List<Label> buildLabels = buildLabels(folderList);
        for (Label label : buildLabels) {
            System.out.println(label.displayName);
        }
    }
}
