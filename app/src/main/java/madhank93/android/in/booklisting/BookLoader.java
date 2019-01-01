package madhank93.android.in.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class BookLoader extends AsyncTaskLoader<List<Book>> {

    /** Tag for log messages */
    private static final String LOG_TAG = BookLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /** Query search params */
    private String mParams;

    public BookLoader(Context context, String mUrl, String mParams) {
        super(context);
        this.mUrl = mUrl;
        this.mParams = mParams;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {

        if (mUrl == null) {
            return null;
        }

        return null;
    }
}
