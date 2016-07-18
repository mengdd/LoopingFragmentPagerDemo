package com.ddmeng.loopingfragmentpager;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArrayListFragment extends ListFragment {
    public static final String KEY_NUM = "num";
    public static final String KEY_TITLE = "title";

    private int mNum;
    private String title;


    @BindView(R.id.text)
    TextView textView;

    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static ArrayListFragment newInstance(int num, String title) {
        ArrayListFragment f = new ArrayListFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt(KEY_NUM, num);
        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return f;
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mNum = arguments.getInt(KEY_NUM);
            title = arguments.getString(KEY_TITLE);
        }
    }

    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pager_list, container, false);
        ButterKnife.bind(this, v);
        textView.setText("Fragment #" + mNum + ", title: " + title);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + id);
    }

}
