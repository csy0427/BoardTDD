import java.util.List;
import java.util.Map;

public abstract class BoardFunction {
    GetFunc manager;

    abstract void sol();

    public void setManager(GetFunc manager) {
        this.manager = manager;
    }
}
