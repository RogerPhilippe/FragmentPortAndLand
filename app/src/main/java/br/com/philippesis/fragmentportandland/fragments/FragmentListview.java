package br.com.philippesis.fragmentportandland.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.philippesis.fragmentportandland.R;
import br.com.philippesis.fragmentportandland.utils.Utils;

public class FragmentListview extends Fragment {

    private ListView lvMain;

    private ArrayAdapter<String> listAdapter;

    private FragmentMain fragmentMain;

    private FragmentSecondary fragmentSecondary;

    private FragmentTransaction fragmentTransaction;

    private int orientationScreen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listview_layout, null);

        lvMain = (ListView) view.findViewById(R.id.idlvMain);

        String[] items = new String[] {"MF - Main Fragment", "MF - Change Default Text",
                "SF - Secondary Fragment", "SF - Change Default Text"};

        listAdapter = new ArrayAdapter<>(parent.getContext(), android.R.layout.simple_list_item_1, items);

        lvMain.setAdapter(listAdapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Utils utils = new Utils();

                if(getResources().getConfiguration().orientation == 1) {
                    orientationScreen = R.id.idFrameMain;
                } else {
                    orientationScreen = R.id.idFrameRight;
                }

                switch (position) {
                    case 0:
                        fragmentMain = new FragmentMain();
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(orientationScreen, fragmentMain, "frag_main");
                        fragmentTransaction.addToBackStack("frag_stack");
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        fragmentMain = (FragmentMain) getFragmentManager().findFragmentByTag("frag_main");
                        if(fragmentMain != null) {
                            fragmentMain.setDefaultText(utils.getValueDialog(parent.getContext()));
                        }
                        break;
                    case 2:
                        fragmentSecondary = new FragmentSecondary();
                        fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(orientationScreen, fragmentSecondary, "frag_second");
                        fragmentTransaction.addToBackStack("frag_stack");
                        fragmentTransaction.commit();
                        break;
                    case 3:
                        fragmentSecondary = (FragmentSecondary) getFragmentManager().findFragmentByTag("frag_second");
                        if(fragmentSecondary != null) {
                            fragmentSecondary.setTvDefaultText(utils.getValueDialog(parent.getContext()));
                        }
                        break;
                }
            }
        });

        return view;

    }

}
