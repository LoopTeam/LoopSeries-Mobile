package com.loop_anime.android.model.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * User: Yilun Chen
 * Date: 15/11/2
 */
public class DirectLink {

    @SerializedName("direct_link")
    private DirectLinkEntity directLink;

    public void setDirectLink(DirectLinkEntity directLink) {
        this.directLink = directLink;
    }

    public DirectLinkEntity getDirectLink() {
        return directLink;
    }

    public static class DirectLinkEntity {
        @SerializedName("dq")
        private List<String> dq;

        public void setDq(List<String> dq) {
            this.dq = dq;
        }

        public List<String> getDq() {
            return dq;
        }
    }
}
