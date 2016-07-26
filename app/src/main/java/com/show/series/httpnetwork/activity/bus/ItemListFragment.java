package com.show.series.httpnetwork.activity.bus;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.show.series.httpnetwork.model.Event;
import com.show.series.httpnetwork.model.EventItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by lihf on 16/7/26.
 */
public class ItemListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    EventBus.getDefault().post(new Event.ItemListEvent(EventItem.ITEMS));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    //订阅者
    @Subscribe(threadMode = ThreadMode.MAIN)//如果集成了eventbus2.4,没有注解；只有在eventbus3.0才有注解
    public void onEventMainThread(Event.ItemListEvent event){
        setListAdapter(new ArrayAdapter<EventItem>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1, event.getItems()));
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        EventBus.getDefault().post(getListView().getItemAtPosition(position));
    }
}
