import java.util.List;
import java.util.Map;

public class AddComment implements BoardFunction {
    IOManager manager=new IOManager();
    @Override
    public void sol(Map<String,Map<String,String>> list, List<String> boardnumber){
        ///manager.addComment(list,boardnumber);
        manager.PrintList(list, boardnumber);
        String id=manager.inputBoardNumber();
        System.out.println("Enter the comment");
        String tmp_comment=input.nextLine();
        bm.addComment(id,tmp_comment);
    }
}
