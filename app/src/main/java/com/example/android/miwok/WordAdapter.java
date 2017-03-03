package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by richard on 2/23/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.
    public WordAdapter(Activity context, ArrayList<Word> words) {
        // 0 in int resource because view is getting inflated in getView method
        super(context, 0, words);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Get the imagview that will display the pics
        if (currentWord.hasImage()) {
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.pics_imageview);
            imageView.setImageResource(currentWord.getDrawableResource());
        }

        // Get the textview that will display the miwok number
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_textview);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Get the textview that will display the default language number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_textview);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;
    }

}
