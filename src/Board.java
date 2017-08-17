import java.util.*;

public class Board {
    Scanner input = new Scanner(System.in);
    int choice = 0;
    int totalNmber = 0;

    Map<String, Map<String, String>> list;
    List<String> boardNumber;
    Map<String, List<String>> comments;
    Map<String, String> tmpMap;

    Calendar date;

    public Board() {
        list = new HashMap<>();
        boardNumber = new ArrayList<>();
        comments = new HashMap<>();
    }

    public int getTotal_number() {
        return totalNmber;
    }

    public String setPost(String title, String content) {
        totalNmber++;
        String tmp_key = getBoardNum();
        tmpMap = new HashMap<>();
        tmpMap.put("title", title);
        tmpMap.put("content", content);
        tmpMap.put("views", "0");
        boardNumber.add(tmp_key);
        list.put(tmp_key, tmpMap);
        List<String> s = new ArrayList<>();
        comments.put(tmp_key, s);
        return tmp_key;
    }

    public Map<String, Map<String, String>> getList() {
        return list;
    }


    public List<String> getBoardNumber() {
        return boardNumber;
    }

    public void modifyPost(String key, String title, String content) {
        list.get(key).put("title", title);
        list.get(key).put("content", content);
    }

    public void deletePost(String key) {
        list.remove(key);
        boardNumber.remove(boardNumber.indexOf(key));
        totalNmber--;
    }

    public Map<String, String> getPost(String key) {
        int tmp_views = (Integer.parseInt(list.get(key).get("views")) + 1);
        list.get(key).put("views", String.valueOf(tmp_views));
        return list.get(key);
    }

    public String getBoardNum() {
        date = Calendar.getInstance();
        String tmp_key = Integer.toString(date.get(Calendar.YEAR)) + Integer.toString(date.get(Calendar.MONTH)) +
                Integer.toString(date.get(Calendar.DATE)) + Integer.toString(date.get(Calendar.MILLISECOND));
        return tmp_key;
    }

    public void setComment(String key, String s) {
        comments.get(key).add(s);
    }

    public List<String> getComment(String key) {
        return comments.get(key);
    }
}
