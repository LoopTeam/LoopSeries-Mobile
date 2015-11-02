package com.loop_anime.android.model.dao;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
@SuppressWarnings("unused")
public class Episode implements Serializable {

    /**
     * id : 139
     * episode : 1
     * episode_title : Transmigration
     * poster : /img/episodes/thetvdb/episodes/70973/300522.jpg
     * rating : 0
     * views : 0
     * comments : 0
     * air_date : 25-07-1991 00:07:00
     * summary :
     * rating_count : 0
     * imdb_id :
     * rating_up : 0
     * rating_down : 0
     * last_update : 03-02-2015 10:02:10
     * create_time : 03-02-2015 10:02:10
     * absolute_number : 1
     * season : 15
     */

    @SerializedName("id")
    int id;
    @SerializedName("episode")
    int episode;
    @SerializedName("episode_title")
    String episodeTitle;
    @SerializedName("poster")
    String poster;
    @SerializedName("rating")
    int rating;
    @SerializedName("views")
    int views;
    @SerializedName("comments")
    int comments;
    @SerializedName("air_date")
    String airDate;
    @SerializedName("summary")
    String summary;
    @SerializedName("rating_count")
    int ratingCount;
    @SerializedName("imdb_id")
    String imdbId;
    @SerializedName("rating_up")
    int ratingUp;
    @SerializedName("rating_down")
    int ratingDown;
    @SerializedName("last_update")
    String lastUpdate;
    @SerializedName("create_time")
    String createTime;
    @SerializedName("absolute_number")
    int absoluteNumber;
    @SerializedName("season")
    int season;

    public void setId(int id) {
        this.id = id;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setRatingUp(int ratingUp) {
        this.ratingUp = ratingUp;
    }

    public void setRatingDown(int ratingDown) {
        this.ratingDown = ratingDown;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setAbsoluteNumber(int absoluteNumber) {
        this.absoluteNumber = absoluteNumber;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public int getEpisode() {
        return episode;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public String getPoster() {
        return poster;
    }

    public int getRating() {
        return rating;
    }

    public int getViews() {
        return views;
    }

    public int getComments() {
        return comments;
    }

    public String getAirDate() {
        return airDate;
    }

    public String getSummary() {
        return summary;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public String getImdbId() {
        return imdbId;
    }

    public int getRatingUp() {
        return ratingUp;
    }

    public int getRatingDown() {
        return ratingDown;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getAbsoluteNumber() {
        return absoluteNumber;
    }

    public int getSeason() {
        return season;
    }
}
