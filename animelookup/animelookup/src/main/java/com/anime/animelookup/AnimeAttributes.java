package com.anime.animelookup;

import com.google.gson.annotations.SerializedName;

public class AnimeAttributes {
    public Titles titles;
    public String averageRating;
    public int episodeCount;
    public String showType;
    public boolean nsfw;

    public AnimeAttributes(){
        this.titles = titles;
        this.averageRating = averageRating;
        this.episodeCount = episodeCount;
        this.showType = showType;
        this.nsfw = nsfw;
    }

    public Titles getTitles() {
        return titles;
    }

    public void setTitles(Titles titles) {
        this.titles = titles;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public static class Titles {
        public String en;
        @SerializedName("en_jp")
        public String enJp;
        @SerializedName("en_us")
        public  String enUs;
        @SerializedName("ja_jp")
        public String jaJp;

        public Titles(String en, String enJp, String enUs, String jaJp) {
            this.en = en;
            this.enJp = enJp;
            this.enUs = enUs;
            this.jaJp = jaJp;
        }

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getEnJp() {
            return enJp;
        }

        public void setEnJp(String enJp) {
            this.enJp = enJp;
        }

        public String getEnUs() {
            return enUs;
        }

        public void setEnUs(String enUs) {
            this.enUs = enUs;
        }

        public String getJaJp() {
            return jaJp;
        }

        public void setJaJp(String jaJp) {
            this.jaJp = jaJp;
        }

        @Override
        public String toString() {
            if(en != null){
                return en;
            }else if(enJp != null){
                return enJp;
            }else {
                return enUs;
            }
        }
    }
}
