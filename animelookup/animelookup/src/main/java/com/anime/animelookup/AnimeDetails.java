package com.anime.animelookup;

import java.util.List;


public class AnimeDetails {
    public String id;
    public String type;
    public Attributes attributes;
    public AnimeDetails(String id, String type, Attributes attributes) {
        this.id = id;
        this.type = type;
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public static class Attributes extends AnimeAttributes {
        public String startDate;
        public String endDate;
        public  String nextRelease;
        public String ageRating;
        public String ageRatingGuide;
        public  String subtype;
        public  String status;
        public List<String> abbreviatedTitles;
        public PosterImage posterImage;
        public String description;
        public String synopsis;


        public Attributes(String startDate, String endDate, String nextRelease, String ageRating,
                                  String ageRatingGuide, String subtype, String status, List<String> abbreviatedTitles,
                                  PosterImage posterImage, String description, String synopsis) {
            super();
            this.startDate = startDate;
            this.endDate = endDate;
            this.nextRelease = nextRelease;
            this.ageRating = ageRating;
            this.ageRatingGuide = ageRatingGuide;
            this.subtype = subtype;
            this.status = status;
            this.abbreviatedTitles = abbreviatedTitles;
            this.posterImage = posterImage;
            this.description = description;
            this.synopsis = synopsis;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getNextRelease() {
            return nextRelease;
        }

        public void setNextRelease(String nextRelease) {
            this.nextRelease = nextRelease;
        }

        public String getAgeRating() {
            return ageRating;
        }

        public String getAgeRatingGuide() {
            return ageRatingGuide;
        }

        public void setAgeRatingGuide(String ageRatingGuide) {
            this.ageRatingGuide = ageRatingGuide;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<String> getAbbreviatedTitles() {
            return abbreviatedTitles;
        }

        public void setAbbreviatedTitles(List<String> abbreviatedTitles) {
            this.abbreviatedTitles = abbreviatedTitles;
        }

        public PosterImage getPosterImage() {
            return posterImage;
        }

        public void setPosterImage(PosterImage posterImage) {
            this.posterImage = posterImage;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static class PosterImage {
            public String tiny;
            public String large;
            public String small;
            public String medium;
            public String original;

            public String getTiny() {
                return tiny;
            }

            public void setTiny(String tiny) {
                this.tiny = tiny;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }
        }
    }
}
