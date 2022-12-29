package com.example.newsx.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.newsx.R;
import com.example.newsx.WebViewController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tv9MarathiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tv9MarathiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private WebView webView;

    public tv9MarathiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tv9MarathiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tv9MarathiFragment newInstance(String param1, String param2) {
        tv9MarathiFragment fragment = new tv9MarathiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv9_marathi, container, false);
        webView = view.findViewById(R.id.tv9marathiWV);
        webView.loadUrl("https://www.tv9marathi.com/");
        webView.setWebViewClient(new WebViewController());

        return view;
    }
}