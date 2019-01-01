package br.com.philippesis.fragmentportandland;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.philippesis.fragmentportandland.fragments.FragmentListview;

public class MainActivity extends FragmentActivity {

    private FragmentListview fragmentListview;

    private FragmentManager fragmentManager;

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState == null) {
            fragmentListview = new FragmentListview();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.idFrameMain, fragmentListview, "");
            //fragmentTransaction.addToBackStack("fragment_stack");
            fragmentTransaction.commit();
        }

    }
}
