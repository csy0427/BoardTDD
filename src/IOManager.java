import java.util.*;


public class IOManager {
    Scanner input= new Scanner(System.in);
    BoardManager bm=new BoardManager();
    List<String> comments=new ArrayList<>();

    public  void PrintFirst(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. 게시판 리스트");
        System.out.println("2. 게시판 읽기");
        System.out.println("3. 게시판 추가");
        System.out.println("4. 게시판 수정");
        System.out.println("5. 게시판 삭제");
        System.out.println("6. 댓글 달기");
        System.out.println("7.exit.....(가지마....)");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Enter the number you want (1-6)");

    }

    public void PrintList(Map<String,Map<String,String>> list, List<String> boardnumber){
        for(int i=0;i<boardnumber.size();i++){
            String key=boardnumber.get(i); //key 획득
            System.out.println("     게시글 번호       |          제목          ");
            System.out.printf("     %s                   %s\n",key, list.get(key).get("title"));
        }
    }

    public String inputBoardNumber(){
        System.out.println("Enter the board number");
        String id=input.nextLine();
        return id;
    }

    public void getPost(Map<String,Map<String,String>> list, List<String> boardnumber){
        PrintList(list, boardnumber);
        String id=inputBoardNumber();
        Map<String,String> tmp=bm.getBoardPost(id);
        comments=bm.getComment(id);
        System.out.println("   게시글 번호   |          제목           ");
        System.out.printf("    %s              %s\n", id, tmp.get("title"));
        System.out.println("   내용");
        System.out.println(tmp.get("content"));
        System.out.printf("조회수: %s\n",tmp.get("views"));
        System.out.println("댓글 : ");
        if(comments.size()==0) return;
        for(int i=0;i<comments.size();i++){
            System.out.println(i+1 +" 번째 댓글 :  " +comments.get(i));
        }
    }

    public void addPost(Map<String,Map<String,String>> list, List<String> boardnumber){
        System.out.print("제목 :  ");
        String tmp_title= input.nextLine();
        System.out.print("내용 :  ");
        String tmp_content= input.nextLine();
        bm.addPost(tmp_title,tmp_content);
    }

    public void modifyPost(Map<String,Map<String,String>> list, List<String> boardnumber){
        PrintList(list, boardnumber);
        String id=inputBoardNumber();
        System.out.print("수정 제목 :  ");
        String tmp_title= input.nextLine();
        System.out.print("수정 내용 :  ");
        String tmp_content= input.nextLine();
        bm.modifyPost(id,tmp_title,tmp_content);
    }

    public void deletePost(Map<String,Map<String,String>> list, List<String> boardnumber){
        PrintList(list, boardnumber);
        String id=inputBoardNumber();
        bm.deletePost(id);
    }

    public void addComment(Map<String,Map<String,String>> list, List<String> boardnumber){
        PrintList(list, boardnumber);
        String id=inputBoardNumber();
        System.out.println("Enter the comment");
        String tmp_comment=input.nextLine();
        bm.addComment(id,tmp_comment);
    }
}
