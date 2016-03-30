package com.manuelmaly.hn.model;

/**
 * Created by austin on 3/18/16.
 */
public class HNFavorite {
    private int mPostId;
    private String mUrl;
    private String mTitle;
    private String mAuthor;

    public HNFavorite(int mPostId, String mUrl, String mTitle, String mAuthor) {
        this.mPostId = mPostId;
        this.mUrl = mUrl;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
    }

    public int getPostId() {
        return mPostId;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }
}
