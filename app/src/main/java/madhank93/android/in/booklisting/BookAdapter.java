package madhank93.android.in.booklisting;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }



}
