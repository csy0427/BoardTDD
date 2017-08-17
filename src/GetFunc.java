import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GetFunc {

    BoardManager bm = new BoardManager();
    Scanner input = new Scanner(System.in);
    List<String> comments = new ArrayList<>();
    Map<String, Map<String, String>> list;
    List<String> boardnumber;

    public GetFunc(Map<String, Map<String, String>> list, List<String> boardnumber) {
        this.list = list;
        this.boardnumber = boardnumber;
    }

    public void PrintList() {
        updateBoard();
        if (isEmptyPost()) return;
        else {
            for (int i = 0; i < boardnumber.size(); i++) {
                String key = boardnumber.get(i); //key 획득
                System.out.println("     게시글 번호       |          제목          ");
                System.out.printf("     %s                   %s\n", key, list.get(key).get("title"));
            }
        }
    }

    public String inputBoardNumber() {
        System.out.println("Enter the board number");
        String id = input.nextLine();
        if (list.get(id) == null) {
            System.out.println("You enter the wrong board number.");
            id = " ";
        }
        return id;
    }

    public void getPost() {
        if (isEmptyPost()) return;
        PrintList();
        String id = " ";
        while (id.equals(" ")) id = inputBoardNumber();
        Map<String, String> tmp = bm.getBoardPost(id);
        comments = bm.getComment(id);
        System.out.println("   게시글 번호   |          제목           ");
        System.out.printf("    %s              %s\n", id, tmp.get("title"));
        System.out.println("   내용");
        System.out.println(tmp.get("content"));
        System.out.printf("조회수: %s\n", tmp.get("views"));
        System.out.println("댓글 : ");
        if (comments.size() == 0) return;
        for (int i = 0; i < comments.size(); i++) {
            System.out.println(i + 1 + " 번째 댓글 :  " + comments.get(i));
        }

    }

    public void addPost() {
        System.out.print("제목 :  ");
        String tmp_title = input.nextLine();
        System.out.print("내용 :  ");
        String tmp_content = input.nextLine();
        bm.addPost(tmp_title, tmp_content);
        updateBoard();
    }

    public void modifyPost() {
        if (isEmptyPost()) return;
        PrintList();
        String id = " ";
        while (id.equals(" ")) id = inputBoardNumber();
        System.out.print("수정 제목 :  ");
        String tmp_title = input.nextLine();
        System.out.print("수정 내용 :  ");
        String tmp_content = input.nextLine();
        bm.modifyPost(id, tmp_title, tmp_content);
        updateBoard();

    }

    public void deletePost() {
        if (isEmptyPost()) return;
        PrintList();
        String id = " ";
        while (id.equals(" ")) id = inputBoardNumber();
        bm.deletePost(id);
        updateBoard();

    }

    public void addComment() {
        if (isEmptyPost()) return;
        PrintList();
        String id = " ";
        while (id.equals(" ")) id = inputBoardNumber();
        System.out.println("Enter the comment");
        String tmp_comment = input.nextLine();
        bm.addComment(id, tmp_comment);
        updateBoard();

    }

    public void updateBoard() {
        list = bm.getBoardList();
        boardnumber = bm.getBoardNumber();
    }

    public boolean isEmptyPost() {
        if (boardnumber.size() == 0) {
            System.out.println("NO POST.......");
            return true;
        }
        return false;
    }
    public void exitBoard(){
        System.out.println("Bye........");
        System.exit(0);
    }
}
