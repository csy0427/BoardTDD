public abstract class BoardFunction {
    GetFunc manager;

    abstract void sol();

    public void setManager(GetFunc manager) {
        this.manager = manager;
    }
}
