import java.util.List;
import java.util.Map;

public class ModifyPost implements BoardFunction {
    IOManager manager = new IOManager();

    @Override
    public void sol(Map<String, Map<String, String>> list, List<String> boardnumber) {
        manager.modifyPost(list, boardnumber);
    }
}