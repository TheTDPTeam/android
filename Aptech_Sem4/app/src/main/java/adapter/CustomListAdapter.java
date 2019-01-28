package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;


public abstract  class CustomListAdapter<T> extends BaseAdapter {
    private int layout;
    private LayoutInflater inflater;
    private List<T> items;

    public CustomListAdapter(Context context,int layout, ArrayList<T> items) {
        this.layout = layout;
        inflater = (LayoutInflater.from(context));

        if(items == null){
            this.items = new ArrayList<T>();
        }else{
            this.items = items;
        }
        notifyChanged();
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
        notifyChanged();
    }

    public void cleanup() {
        items.clear();
    }

    public void notifyChanged(){
        this.items = modifyArrayAdapter(this.items);

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            getViewHolder(viewHolder,view);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        T model = items.get(i);
        setViewHolder(viewHolder, model);
        addListener(viewHolder, model);
        return view;
    }

    protected abstract void getViewHolder(ViewHolder vh,View v);
    protected abstract void setViewHolder(ViewHolder vh, T model);
    protected abstract void addListener(ViewHolder vh, T model);
    protected abstract List<T> modifyArrayAdapter(List<T> models); //Used for modifying the model list before populating
}


