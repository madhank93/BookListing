package madhank93.android.in.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

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

        String completeUrl = mUrl + mParams;

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Book> books = QueryUtils.fetchEarthquakeData(completeUrl);
        return books;
    }
}
