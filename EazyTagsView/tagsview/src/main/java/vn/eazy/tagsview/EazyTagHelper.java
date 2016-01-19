package vn.eazy.tagsview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longzma11 on 12/12/15.
 */
public class EazyTagHelper {
    private List<EazyTag> tags;
    private TagsGroup group;
    private Context context;

    public EazyTagHelper(TagsGroup group, Context context) {

        this.group = group;
        this.context = context;
    }


}
