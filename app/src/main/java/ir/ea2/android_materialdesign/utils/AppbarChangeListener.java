package ir.ea2.android_materialdesign.utils;

import com.google.android.material.appbar.AppBarLayout;

public abstract class AppbarChangeListener implements AppBarLayout.OnOffsetChangedListener {
    public enum  State{
        NORMAL , MINI
    }
    private static  State currentState = State.NORMAL ;

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if(Math.abs(verticalOffset)>= appBarLayout.getTotalScrollRange()/2){
            if (currentState != State.MINI){
                onStateChanged(appBarLayout ,State.MINI);
            }
            currentState = State.MINI;
        }else{
            if (currentState != State.NORMAL){
                onStateChanged(appBarLayout ,State.NORMAL);
            }
            currentState = State.NORMAL;
        }

    }
    public abstract  void onStateChanged (AppBarLayout appBarLayout , State state);
}
