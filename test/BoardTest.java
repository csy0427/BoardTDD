import org.junit.Before;
import org.junit.Test;
import  java.util.*;
import static org.junit.Assert.*;

public class BoardTest {
   // int i=0;
    BoardManager bm=new BoardManager();
    Map<String,String> tmp_map=new HashMap<>();
    String title;
    String content;
    String key=" ";

    @Before
    public void setUp() {
        title="123";
        content="abc";
    }

    @Test
    public void 게시글추가(){
        key=bm.addPost(title,content);
        assertEquals(title, bm.getBoardPost(key).get("title"));
        assertEquals(content,bm.getBoardPost(key).get("content"));
    }

    @Test(expected=NullPointerException.class)
    public void 게시글읽기() throws Exception{
        key=bm.addPost(title,content);
        Map<String, String> tmp=bm.getBoardPost(key);
        assertEquals(title, tmp.get("title"));
        assertEquals(content,tmp.get("content"));

        //예외 발생 예상 구간
        bm.getBoardPost("123");
    }

    @Test(expected=NullPointerException.class)
    public void 게시글수정(){
        bm.modifyPost(key,"567","def");
        assertEquals("567",bm.getBoardPost(key).get("title"));
        assertEquals("def",bm.getBoardPost(key).get("content"));

        //예외 발생 예상 구간
        bm.getBoardPost("123");
    }

    @Test(expected=NullPointerException.class)
    public void 게시글삭제(){
        key=bm.addPost(title,content);
        assertEquals(1,bm.getPostNumber());
        bm.deletePost(key);
        assertEquals(0,bm.getPostNumber());

        //예외 발생 예상 구간
        bm.getBoardPost("123");
    }

    @Test(expected=NullPointerException.class)
    public void 조회수증가(){
        tmp_map=new HashMap<>();
        key=bm.addPost(title,content);
        tmp_map=bm.getBoardPost(key);
        assertEquals("1",tmp_map.get("views"));
        tmp_map=bm.getBoardPost(key);
        assertEquals("2",tmp_map.get("views"));

        //예외 발생 예상 구간
        bm.getBoardPost("123");
    }

    /*
    * 새로운 기능 추가
    *
    * */

    @Test(expected=NullPointerException.class)
    public void 댓글달기(){
        key=bm.addPost(title,content);
        bm.addComment(key,"이 글 좋네요!");
        List<String> tmp_comment=bm.getComment(key);
        assertEquals("이 글 좋네요!",tmp_comment.get(0));

        //예외 발생 예상 구간
        bm.getBoardPost("123");
    }

}
