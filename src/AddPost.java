import java.util.List;
import java.util.Map;

public class AddPost implements BoardFunction {
    IOManager manager=new IOManager();
    @Override
    public void sol(Map<String,Map<String,String>> list, List<String> boardnumber) {
        manager.addPost(list,boardnumber);
    }
}