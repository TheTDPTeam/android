package adapter;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
public class CustomLoader<T> extends AsyncTaskLoader<List<T>> {
    public CustomLoader(Context context) {
        super(context);
    }
    @Override
    public List<T> loadInBackground() {
        List<T> list = new ArrayList<T>();
        //TODO
        return list;
    }
}