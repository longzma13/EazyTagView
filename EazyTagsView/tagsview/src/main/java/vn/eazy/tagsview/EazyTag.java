package vn.eazy.tagsview;

/**
 * Created by LongLe on 12/12/15.
 */
public class EazyTag {
    private int id;
    private String tag;

    public EazyTag(){

    }
    public EazyTag(int id,String tag){
        this.id = id;
        this.tag = tag;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

