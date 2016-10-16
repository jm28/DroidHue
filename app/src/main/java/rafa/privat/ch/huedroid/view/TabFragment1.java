package rafa.privat.ch.huedroid.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHGroup;

import java.util.ArrayList;
import java.util.List;

import rafa.privat.ch.huedroid.R;

/**
 * Created by rafa on 16.10.16.
 */

public class TabFragment1 extends ListFragment {

    private PHHueSDK phHueSDK;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment_1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        phHueSDK = PHHueSDK.create();
        PHBridge bridge = phHueSDK.getSelectedBridge();
        List<PHGroup> groups = bridge.getResourceCache().getAllGroups();

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String>();

        for (PHGroup group : groups) {
            your_array_list.add(group.getName());
        }

        Log.e("adsdaas", "dsaasadsdasdsadsadsa");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getListView().getContext(), android.R.layout.simple_list_item_1, your_array_list);
        setListAdapter(arrayAdapter);

        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}
