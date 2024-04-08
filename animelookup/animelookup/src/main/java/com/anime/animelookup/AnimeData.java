package com.anime.animelookup;

public class AnimeData {
    public String id;
    public String type;
   public AnimeAttributes attributes;

    public AnimeData(String id, String type, AnimeAttributes attributes) {
        this.id = id;
        this.type = type;
        this.attributes = attributes;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AnimeAttributes getAttributes(){
        return attributes;
    }

    public void setAttributes(AnimeAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
      if(attributes.getTitles().getEn() != null){
          return attributes.getTitles().getEn();
      }else if(attributes.getTitles().getEnJp() != null){
          return attributes.getTitles().getEnJp();
      }else {
          return attributes.getTitles().getEnUs();
      }
    }


}
