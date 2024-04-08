package com.anime.animelookup;

import java.util.List;

public class KitsuResponse <T> {
    public List<T> data;
    public Meta meta;
    public Links links;

    public KitsuResponse(List<T> data, Meta meta, Links links) {
        this.data = data;
        this.meta = meta;
        this.links = links;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public static class Links {
        public String first;
        public String next;
        public String last;

        public Links(  String first, String next, String last) {
            this.first = first;
            this.next = next;
            this.last = last;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }

    public static class Meta {
        public int count;
        public Meta(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}

