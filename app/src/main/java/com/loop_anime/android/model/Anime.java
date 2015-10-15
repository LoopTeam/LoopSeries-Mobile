package com.loop_anime.android.model;

import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import java.io.Serializable;
import java.util.List;

import static com.loop_anime.android.db.Table.Anime.BIG_POSTER;
import static com.loop_anime.android.db.Table.Anime.CREATE_TIME;
import static com.loop_anime.android.db.Table.Anime.END_TIME;
import static com.loop_anime.android.db.Table.Anime.GENRES;
import static com.loop_anime.android.db.Table.Anime.ID;
import static com.loop_anime.android.db.Table.Anime.IMDB_ID;
import static com.loop_anime.android.db.Table.Anime.PLOT_SUMMARY;
import static com.loop_anime.android.db.Table.Anime.POSTER;
import static com.loop_anime.android.db.Table.Anime.RATING;
import static com.loop_anime.android.db.Table.Anime.RATING_COUNT;
import static com.loop_anime.android.db.Table.Anime.RUNNING_TIME;
import static com.loop_anime.android.db.Table.Anime.START_TIME;
import static com.loop_anime.android.db.Table.Anime.STATUS;
import static com.loop_anime.android.db.Table.Anime.TABLE_NAME;
import static com.loop_anime.android.db.Table.Anime.THEMES;
import static com.loop_anime.android.db.Table.Anime.TITLE;
import static com.loop_anime.android.db.Table.Anime.TYPE_SERIES;

/**
 * User: Yilun Chen
 * Date: 15/10/14
 */
@StorIOSQLiteType(table = TABLE_NAME)
@SuppressWarnings("unused")
public class Anime implements Serializable {


    /**
     * id : 2
     * title : The Kawai Complex Guide to Manors and Hostel Behavior
     * poster : /img/episodes/thetvdb/posters/278196-1.jpg
     * genres : Animation,Comedy
     * themes :
     * plot_summary : Usa, a high-school student aspiring to begin a bachelor lifestyle...
     * running_time : 25
     * start_time : 2014-04-04
     * end_time :
     * status : Ended
     * rating : 8
     * imdb_id : 0
     * rating_count : 3
     * create_time : 2014-09-17T01:09:54+0200
     * type_series : anime
     * big_poster :
     */

    @StorIOSQLiteColumn(key = true, name = ID)
    @SerializedName("id")
    int id;

    @StorIOSQLiteColumn(name = TITLE)
    @SerializedName("title")
    String title;

    @StorIOSQLiteColumn(name = POSTER)
    @SerializedName("poster")
    String poster;

    @StorIOSQLiteColumn(name = GENRES)
    @SerializedName("genres")
    String genres;

    @StorIOSQLiteColumn(name = THEMES)
    @SerializedName("themes")
    String themes;

    @StorIOSQLiteColumn(name = PLOT_SUMMARY)
    @SerializedName("plot_summary")
    String plotSummary;

    @StorIOSQLiteColumn(name = RUNNING_TIME)
    @SerializedName("running_time")
    String runningTime;

    @StorIOSQLiteColumn(name = START_TIME)
    @SerializedName("start_time")
    String startTime;

    @StorIOSQLiteColumn(name = END_TIME)
    @SerializedName("end_time")
    String endTime;

    @StorIOSQLiteColumn(name = STATUS)
    @SerializedName("status")
    String status;

    @StorIOSQLiteColumn(name = RATING)
    @SerializedName("rating")
    int rating;

    @StorIOSQLiteColumn(name = IMDB_ID)
    @SerializedName("imdb_id")
    String imdbId;

    @StorIOSQLiteColumn(name = RATING_COUNT)
    @SerializedName("rating_count")
    int ratingCount;

    @StorIOSQLiteColumn(name = CREATE_TIME)
    @SerializedName("create_time")
    String createTime;

    @StorIOSQLiteColumn(name = TYPE_SERIES)
    @SerializedName("type_series")
    String typeSeries;

    @StorIOSQLiteColumn(name = BIG_POSTER)
    @SerializedName("big_poster")
    String bigPoster;

    @SerializedName("animes_seasons")
    List<Integer> animeSeasons;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public void setPlotSummary(String plotSummary) {
        this.plotSummary = plotSummary;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setTypeSeries(String typeSeries) {
        this.typeSeries = typeSeries;
    }

    public void setBigPoster(String bigPoster) {
        this.bigPoster = bigPoster;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getGenres() {
        return genres;
    }

    public String getThemes() {
        return themes;
    }

    public String getPlotSummary() {
        return plotSummary;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public int getRating() {
        return rating;
    }

    public String getImdbId() {
        return imdbId;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getTypeSeries() {
        return typeSeries;
    }

    public String getBigPoster() {
        return bigPoster;
    }

    public List<Integer> getAnimeSeasons() {
        return animeSeasons;
    }

    public void setAnimeSeasons(List<Integer> animeSeasons) {
        this.animeSeasons = animeSeasons;
    }
}
