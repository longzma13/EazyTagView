package vn.eazy.tagsview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LongLe on 12/12/15.
 */
public class TagsGroup extends ViewGroup {
    private View childView;
    private int paddingHorizontal;
    private int paddingVertical;
    private List<EazyTag> tags;
    private Typeface typeface;
    public TagsGroup(Context context) {
        super(context);
        initRootView();
    }
    public void setTypeFaceTag(Typeface typeFaceTag){
        this.typeface = typeFaceTag;
    }
    public Typeface getTypeFaceTag(){
        return this.typeface;
    }
    public TagsGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initRootView();
    }

    public TagsGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initRootView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TagsGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initRootView();
    }

    /**
     * init root view by programtimacally
     */
    private void initRootView() {
        paddingHorizontal = getResources().getDimensionPixelSize(R.dimen.flowlayout_horizontal_padding);
        paddingVertical = getResources().getDimensionPixelSize(R.dimen.flowlayout_vertical_padding);
//        setHelper(new EazyTagHelper(this,getContext()));
        tags = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int layoutWidth = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
        int layoutHeight = 0;

        int cursorX = 0;
        int cursorY =0;
        int lineHeight = 0;
        boolean breakLine = false;
        int childCount = getChildCount();

        //Base values
        cursorX = getPaddingLeft();
        cursorY = getPaddingTop();
        layoutHeight = getPaddingTop();

        for(int i=0; i<childCount;i++){
            View child = getChildAt(i);
            if(child.getVisibility() == View.GONE){
                continue;
            }

            //Measure children itself
            child.measure( getChildMeasureSpec(widthMeasureSpec, 0, child.getLayoutParams().width),
                    getChildMeasureSpec(heightMeasureSpec, 0, child.getLayoutParams().height));

            //get child measurements
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            //TODO if free width is not enough, we need break line
            if(cursorX + childWidth > layoutWidth){
                breakLine = true;
            }

            if(breakLine){
                cursorX = getPaddingLeft();
                cursorY += lineHeight;

                layoutHeight += lineHeight;
                lineHeight = 0;

                breakLine = false;
            }

            //TODO in the end, we need to move cursor to left
            cursorX += childWidth + paddingHorizontal;

            //TODO lineHeight is equal the height of highest child in row
            lineHeight = Math.max(lineHeight,(childHeight + paddingVertical));
        }

        //TODO increase layout height by the height of last row
        layoutHeight += lineHeight;
        setMeasuredDimension(layoutWidth,layoutHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int layoutWidth = r - l;

        int cursorX = 0;
        int cursorY = 0;
        int lineHeight = 0;
        boolean breakLine = false;
        int childCount = getChildCount();

        //base values
        cursorX = getPaddingLeft();
        cursorY = getPaddingTop();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (cursorX + childWidth > layoutWidth) {
                breakLine = true;
            }

            if (breakLine) {
                cursorX = getPaddingLeft();
                cursorY += lineHeight;

                lineHeight = 0;
                breakLine = false;
            }

            child.layout(cursorX, cursorY, cursorX + childWidth, cursorY + childHeight);

            // In the end, we need to move cursor to left
            cursorX += childWidth + paddingHorizontal;

            // lineHeight is equal the height of highest child in row
            lineHeight = Math.max(lineHeight, (childHeight + paddingVertical));
        }

    }

    public View getChildView() {
        return childView;
    }

    public void setChildView(View childView) {
        this.childView = childView;
    }

    private void addViewGroup(EazyTag tag) {
        if (getChildView() == null) {
            EazyTagView tagView = EazyTagViewFactoty.createTagViewBlueType(tag.getId(), tag.getTag(), getContext());
            if (getTypeFaceTag() != null) {
                tagView.setTypreFaceTag(getTypeFaceTag());
            }
            addView(tagView);
        }
    }

    public void addTag(EazyTag tag) {
        getTags().add(tag);
        addViewGroup(tag);
    }

    public void addTags(List<EazyTag> tags) {
        removeAllTag();
        this.setTags(new ArrayList<>(tags));
        for (EazyTag tag : tags) {
            addTag(tag);
            addViewGroup(tag);
        }
    }

    public void addTags(EazyTag... tags) {
        removeAllTag();
        for (EazyTag tag : tags) {
            addTag(tag);
            addViewGroup(tag);
        }
    }

    public void removeTag(int index) {
        getTags().remove(index);
        removeViewAt(index);
    }

    public void removeTag(EazyTag tag) {
        getTags().remove(tag);
    }

    public void removeAllTag() {
        getTags().clear();
        removeAllViews();
    }

    /**
     *  set listener when user click a tagView.
     * @param clickListener
     */
    public void setTagOnClickListener(View.OnClickListener clickListener){
        for(int i =0; i< getChildCount(); i++){
            View view = getChildAt(i);
            if(view instanceof EazyTagView){
                view.setOnClickListener(clickListener);
            }
        }
    }

    public List<EazyTag> getTags() {
        return tags;
    }
    public EazyTag getEazyTagById(int id){
        for(EazyTag tag : tags){
            if(tag.getId() == id){
                return tag;
            }
        }
        return null;
    }
    public void setTags(List<EazyTag> tags) {
        this.tags = tags;
    }
}
