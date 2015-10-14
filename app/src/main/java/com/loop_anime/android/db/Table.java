package com.loop_anime.android.db;

/**
 * User: Yilun Chen
 * Date: 15/10/14
 */
public class Table {

    public static class Anime {

        public static final String TABLE_NAME = "anime";

        public static final String ID = TABLE_NAME + "_" + "id";

        public static final String TITLE = TABLE_NAME + "_" + "title";

        public static final String POSTER = TABLE_NAME + "_" + "poster";

        public static final String GENRES = TABLE_NAME + "_" + "genres";

        public static final String THEMES = TABLE_NAME + "_" + "themes";

        public static final String PLOT_SUMMARY = TABLE_NAME + "_" + "plot_summary";

        public static final String RUNNING_TIME = TABLE_NAME + "_" + "running_time";

        public static final String START_TIME = TABLE_NAME + "_" + "start_time";

        public static final String END_TIME = TABLE_NAME + "_" + "end_time";

        public static final String STATUS = TABLE_NAME + "_" + "status";

        public static final String RATING = TABLE_NAME + "_" + "rating";

        public static final String IMDB_ID = TABLE_NAME + "_" + "imdb_id";

        public static final String RATING_COUNT = TABLE_NAME + "_" + "rating_count";

        public static final String CREATE_TIME = TABLE_NAME + "_" + "create_time";

        public static final String TYPE_SERIES = TABLE_NAME + "_" + "type_series";

        public static final String BIG_POSTER = TABLE_NAME + "_" + "big_poster";

        public static final String CREATE_SQL =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + ID + " INTEGER PRIMARY KEY UNIQUE ON CONFLICT REPLACE, "
                        + TITLE + " TEXT NOT NULL, "
                        + POSTER + " TEXT, "
                        + GENRES + " TEXT, "
                        + THEMES + " TEXT, "
                        + PLOT_SUMMARY + " TEXT, "
                        + RUNNING_TIME + " INTEGER, "
                        + START_TIME + " TEXT, "
                        + END_TIME + " TEXT, "
                        + STATUS + " TEXT, "
                        + RATING + " INTEGER, "
                        + IMDB_ID + "  TEXT, "
                        + RATING_COUNT + " INTEGER, "
                        + CREATE_TIME + " TEXT, "
                        + TYPE_SERIES + " TEXT, "
                        + BIG_POSTER + " TEXT "
                        + ");";

    }
}
