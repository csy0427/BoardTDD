import java.util.List;
import java.util.Map;

public class SetFunc {
    List<String> boardnumber;
    Map<String,Map<String,String>> list;

    public void init(Map<String,Map<String,String>> list, List<String> boardnumber){
        this.list=list;
        this.boardnumber=boardnumber;
    }

    public void checkNumber(BoardFunction cn){
        cn.sol(list,boardnumber);
    }
}
