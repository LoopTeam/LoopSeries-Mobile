package com.loop_anime.android.model.dao;

import com.google.gson.annotations.SerializedName;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
public class Link {

    /**
     * id : 74673
     * id_episode : 139
     * hoster : anime44
     * link : http://videowing.me/embed/fc037e8a6e8f5cef750f9e995ef21e00?w=718&h=438&file=3x3eyes-01.flv&sv=1
     * status : 1
     * id_user : 0
     * create_time : 2015-05-20T18:23:30+0200
     * subtitles : 1
     * lang : JAP
     * sub_lang : EN
     * used : 0
     * file_type : mp4
     * report : 0
     * quality_type : SQ
     * file_size : 0
     * file_server : videowing.me
     * used_times : 0
     */

    @SerializedName("id")
    private int id;
    @SerializedName("id_episode")
    private int idEpisode;
    @SerializedName("hoster")
    private String hoster;
    @SerializedName("link")
    private String link;
    @SerializedName("status")
    private int status;
    @SerializedName("id_user")
    private int idUser;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("subtitles")
    private int subtitles;
    @SerializedName("lang")
    private String lang;
    @SerializedName("sub_lang")
    private String subLang;
    @SerializedName("used")
    private int used;
    @SerializedName("file_type")
    private String fileType;
    @SerializedName("report")
    private int report;
    @SerializedName("quality_type")
    private String qualityType;
    @SerializedName("file_size")
    private String fileSize;
    @SerializedName("file_server")
    private String fileServer;
    @SerializedName("used_times")
    private int usedTimes;

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEpisode(int idEpisode) {
        this.idEpisode = idEpisode;
    }

    public void setHoster(String hoster) {
        this.hoster = hoster;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setSubtitles(int subtitles) {
        this.subtitles = subtitles;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setSubLang(String subLang) {
        this.subLang = subLang;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setReport(int report) {
        this.report = report;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileServer(String fileServer) {
        this.fileServer = fileServer;
    }

    public void setUsedTimes(int usedTimes) {
        this.usedTimes = usedTimes;
    }

    public int getId() {
        return id;
    }

    public int getIdEpisode() {
        return idEpisode;
    }

    public String getHoster() {
        return hoster;
    }

    public String getLink() {
        return link;
    }

    public int getStatus() {
        return status;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getSubtitles() {
        return subtitles;
    }

    public String getLang() {
        return lang;
    }

    public String getSubLang() {
        return subLang;
    }

    public int getUsed() {
        return used;
    }

    public String getFileType() {
        return fileType;
    }

    public int getReport() {
        return report;
    }

    public String getQualityType() {
        return qualityType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public String getFileServer() {
        return fileServer;
    }

    public int getUsedTimes() {
        return usedTimes;
    }
}
