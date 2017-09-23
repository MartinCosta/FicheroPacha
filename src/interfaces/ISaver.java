package interfaces;

public interface ISaver {
    public abstract void save(String name, String data);
    public abstract void delete();
    public abstract String getName ();
    public abstract void setName (String name);
}
