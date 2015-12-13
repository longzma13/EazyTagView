package vn.eazy.tagsviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import vn.eazy.tagsview.EazyTag;
import vn.eazy.tagsview.TagsGroup;

public class MainActivity extends AppCompatActivity {
    private TagsGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = (TagsGroup) findViewById(R.id.tagsGroup);
        group.addTag(new EazyTag(123,"Bundesliga"));
        group.addTag(new EazyTag(13,"Oberbayern"));
        group.addTag(new EazyTag(2323,"Halbseit"));
        group.addTag(new EazyTag(1212,"Fullball"));
        group.addTag(new EazyTag(4324,"Sport"));
        group.addTag(new EazyTag(3232,"Das Spiel im Liveticker"));
        group.setTagOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EazyTag tag = group.getEazyTagById(v.getId());
                if(tag != null){
                    Log.v("debug","Id: "+ tag.getId() + " - tag:" + tag.getTag());
                }
            }
        });
    }
}
