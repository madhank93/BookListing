package madhank93.android.in.booklisting;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Book>> {

    /** URL for earthquake data from the USGS dataset */
    private static final String BOOK_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes?q=";
    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int BOOKLIST_LOADER_ID = 1;
    private String searchParams;
    private EditText editTitle;
    private static final String LOG_TAG = MainActivity.class.getName();
    private ListView listView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = (EditText) findViewById(R.id.search_title);

        Button searchButton = (Button) findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchParams = editTitle.getText().toString();

                // Get a reference to the LoaderManager, in order to interact with loaders.
                LoaderManager loaderManager = getLoaderManager();

                // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                // because this activity implements the LoaderCallbacks interface).
                loaderManager.initLoader(BOOKLIST_LOADER_ID, null, MainActivity.this);

                }
        });

    }

    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        return new BookLoader(this,BOOK_REQUEST_URL,searchParams);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {

        if (data != null && !data.isEmpty()) {
            //mAdapter.addAll(earthquakes);
            updateUi(data);
        }

        getLoaderManager().restartLoader(0, null, this);

    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        bookAdapter.clear();
        loader.reset();
    }

    private void updateUi(final List<Book> books) {

        // Create a new {@link ArrayAdapter} of earthquakes
        bookAdapter = new BookAdapter(this, books);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(bookAdapter);

    }

}
