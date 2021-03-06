package com.tht.movies.utilities;

import android.net.Uri;

public class TmbdUtils {

    public static final int CONTENT_TYPE_MOVIE = 100;
    public static final int CONTENT_TYPE_TV = 200;

    private static final String BASE_URL = "https://image.tmdb.org/t/p/";
    private static String SIZE = "w342";

    public static String createImageUrl_P(String size, String s) {
        if (size != null && !(size.equals(""))) {
            SIZE = size;
        }
        String temp = BASE_URL + SIZE + "/" + s;
        Uri uri = Uri.parse(temp);
        //Log.v("Image Utils: Created", uri.toString());
        return uri.toString();
    }

}
