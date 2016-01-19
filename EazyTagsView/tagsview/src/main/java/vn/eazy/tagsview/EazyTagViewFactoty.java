package vn.eazy.tagsview;

import android.content.Context;

/**
 * Created by longzma11 on 12/12/15.
 */
public class EazyTagViewFactoty {
    public static EazyTagView createTagViewOrangeType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_orange_selector).setContentColor(R.color.text_color_type1_selector);
    }
    public static EazyTagView createTagViewBlueType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_blue_selector).setContentColor(R.color.text_color_type2_selector);
    }
    public static EazyTagView createTagViewVioletType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_violet_selector).setContentColor(R.color.text_color_type3_selector);
    }
    public static EazyTagView createTagViewBlackType(int id, String tag,Context context){
        return new EazyTagView(id,tag,context).setBackgroundTag(R.drawable.bg_black_selector).setContentColor(R.color.text_color_type4_selector);
    }
}
