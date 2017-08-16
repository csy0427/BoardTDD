import java.util.List;
import java.util.Map;

public class BoardManager {
    Board board;

    public BoardManager() {
        board = new Board();
    }

    public List<String> getBoardNumber() {
        return board.getBoardNumber();
    }

    public Map<String, Map<String, String>> getBoardList() {
        return board.getList();
    }

    public String addPost(String title, String content) {
        String key = board.setPost(title, content);
        return key;
    }

    public void modifyPost(String key, String title, String content) {
        board.modifyPost(key, title, content);
    }

    public void deletePost(String key) {
        board.deletePost(key);
    }

    public Map<String, String> getBoardPost(String key) {
        return board.getPost(key);
    }

    public int getPostNumber() {
        return board.getTotal_number();
    }

    public void addComment(String key, String s) {
        board.setComment(key, s);
    }

    public List<String> getComment(String key) {
        return board.getComment(key);
    }
}
