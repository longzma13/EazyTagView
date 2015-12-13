package vn.eazy.tagsview;

import android.content.Context;

/**
 * Created by longzma11 on 12/12/15.
 */
public class EazyTagViewFactoty {
    public static EazyTagView createTagViewOrangeType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_type1).setContentColor(R.color.type_1);
    }
    public static EazyTagView createTagViewBlueType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_type2).setContentColor(R.color.type_2);
    }
    public static EazyTagView createTagViewVioletType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_type3).setContentColor(R.color.type_3);
    }
    public static EazyTagView createTagViewBlackType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_type4).setContentColor(R.color.type_4);
    }
}
