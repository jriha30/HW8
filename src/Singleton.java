import java.util.ArrayList;

public class Singleton {
    private static Singleton instance = null;
    public ArrayList<String> clientInputs = new ArrayList<String>();

    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }
}