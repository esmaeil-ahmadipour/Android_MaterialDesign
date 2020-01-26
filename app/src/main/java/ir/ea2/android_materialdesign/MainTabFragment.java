package ir.ea2.android_materialdesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainTabFragment extends Fragment {
    public static final String TITLE_KEY="title_key";
    private TextView mainTabTextView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_main_tab,container , false);
        mainTabTextView = view.findViewById(R.id.fr_main_tab_txt);
       Bundle bundle = getArguments();
       if(bundle != null){
           mainTabTextView.setText(bundle.getString(TITLE_KEY));
       }
        return view;
    }

    public static MainTabFragment newInstance(String titleString) {

        Bundle args = new Bundle();
         args.putString(TITLE_KEY , titleString);
         MainTabFragment fragment = new MainTabFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
