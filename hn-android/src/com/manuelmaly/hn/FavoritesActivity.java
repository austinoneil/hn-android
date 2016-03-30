package com.manuelmaly.hn;

import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.manuelmaly.hn.model.HNFavorite;
import com.manuelmaly.hn.model.HNPost;
import com.manuelmaly.hn.parser.BaseHTMLParser;
import com.manuelmaly.hn.util.FontHelper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.util.ArrayList;

@EActivity(R.layout.activity_favorites)
public class FavoritesActivity extends BaseListActivity {

    @ViewById(R.id.favorites_list)
    ListView mPostsList;
    HNFavorite[] favorites;

    @SystemService
    LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        favorites = favoriteList(); // TODO:ao move this after the super.onCreate call
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
    }

    @AfterViews
    public void init() {
        PostsAdapter mPostsAdapter = new PostsAdapter();
        mPostsList.setAdapter(mPostsAdapter);
    }

    private HNFavorite[] favoriteList() {
        ArrayList<HNFavorite> favorites = new ArrayList<HNFavorite>();
        String path = getApplicationContext().getFilesDir() + "/Favorites.db3";
        SQLiteDatabase myDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
       // Cursor cursor = myDatabase.rawQuery("SELECT id, url, title, author FROM Favorites;", new String[]{});
        Cursor cursor = myDatabase.rawQuery("SELECT * FROM Favorites;", new String[]{});
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                favorites.add(new HNFavorite(
                        Integer.parseInt(getStringForColumnName(cursor, "id")),
                        getStringForColumnName(cursor, "url"),
                        getStringForColumnName(cursor, "title"),
                        getStringForColumnName(cursor, "author")));
            }
        }
        return (HNFavorite[])favorites.toArray();

    }

    private String getStringForColumnName(Cursor cursor, String name) {
        return cursor.getString(cursor.getColumnIndex(name));
    }

    class PostsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return favorites.length;
        }

        @Override
        public HNFavorite getItem(int position) {
            return favorites[position];
        }

        @Override
        public long getItemId(int position) {
            // Item ID not needed here:
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            HNFavorite favorite = getItem(position);
            TextView textView = new TextView(parent.getContext());
            textView.setText(favorite.getTitle());
            return textView;
        }
    }
}

