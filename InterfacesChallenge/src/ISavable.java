import java.util.List;

/**
 * Created by eclipze on 11/24/2016.
 */
public interface ISavable {

    List<String> write();
    void read(List<String> savedValues);

}
