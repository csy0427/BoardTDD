import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    BoardManager bm = new BoardManager();
    Map<String, String> tmp_map = new HashMap<>();
    String title[] = new String[10];
    String content[] = new String[10];
    String key[] = new String[10];
    int totalSize = 0;

    @Before
    public void setUp() {
        title[0] = "123";
        content[0] = "abc";
        key[0] = bm.addPost(title[0], content[0]);
        tmp_map = new HashMap<>();
        tmp_map = bm.getBoardPost(key[0]);
        totalSize++;
    }

    @Test
    public void 게시글추가() {
        title[totalSize] = "aaa";
        content[totalSize] = "bbb";
        key[totalSize] = bm.addPost(title[totalSize], content[totalSize]);
        totalSize++;
    }

    @Test
    public void 게시글읽기() throws Exception {
        Map<String, String> tmp = bm.getBoardPost(key[0]);
        assertEquals(title[0], tmp.get("title"));
        assertEquals(content[0], tmp.get("content"));
    }

    @Test
    public void 게시글수정() {
        bm.modifyPost(key[0], "567", "def");
        assertEquals("567", bm.getBoardPost(key[0]).get("title"));
        assertEquals("def", bm.getBoardPost(key[0]).get("content"));
    }

    @Test
    public void 게시글삭제() {
        assertEquals(1, bm.getPostNumber());
        bm.deletePost(key[0]);
        assertEquals(0, bm.getPostNumber());
        totalSize--;
    }

    @Test
    public void 조회수증가() {
        assertEquals("1", tmp_map.get("views"));
        tmp_map = bm.getBoardPost(key[0]);
        assertEquals("2", tmp_map.get("views"));
    }

    @Test
    public void 게시글리스트() {
        List<String> boardNumber = bm.getBoardNumber();
        for (int i = 0; i < boardNumber.size(); i++) {
            assertEquals(title[i], bm.getBoardPost(key[i]).get("title"));
            assertEquals(content[i], bm.getBoardPost(key[i]).get("content"));
        }

    }

    /*
    * 새로운 기능 추가
    *
    * */

    @Test
    public void 댓글달기() {
        bm.addComment(key[0], "이 글 좋네요!");
        List<String> tmp_comment = bm.getComment(key[0]);
        assertEquals("이 글 좋네요!", tmp_comment.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void 잘못된게시글번호입력(){
        bm.getBoardPost("123");
    }

}
