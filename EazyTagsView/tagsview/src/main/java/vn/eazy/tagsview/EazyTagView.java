package vn.eazy.tagsview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by longzma11 on 12/12/15.
 */
public class EazyTagView extends TextView {

    public EazyTagView(Context context) {
        super(context);
        setaPaddingTag();
        setClickable(true);
    }
    public EazyTagView(int id,String tag,Context context){
        super(context);
        setText(tag);
        setId(id);
        setaPaddingTag();
        setClickable(true);
    }
    public EazyTagView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EazyTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EazyTagView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void setaPaddingTag(){
        int paddingLeft_right = getContext().getResources().getDimensionPixelSize(R.dimen.padding_left_right);
        int padding_top_bottom = getContext().getResources().getDimensionPixelSize(R.dimen.padding_top_bottom);
        setPadding(paddingLeft_right,padding_top_bottom,paddingLeft_right,padding_top_bottom);
        requestLayout();
    }
    public EazyTagView setBackgroundTag(int drawable) {
        setClickable(true);
        setBackgroundResource(drawable);
        return this;
    }

    public EazyTagView setContentColor(int color) {
        setTextColor(getContext().getResources().getColorStateList(color));
        return this;
    }

    public EazyTagView setTextTag(String tag) {
        setText(tag);
        return this;
    }
    public EazyTagView setTypreFaceTag(Typeface typeface){
        setTypeface(typeface);
        return this;
    }
}
