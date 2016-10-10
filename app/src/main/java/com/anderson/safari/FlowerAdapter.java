package com.anderson.safari;

/**
 * Created by Anderson on 10/3/2016.
 */
public class FlowerAdapter extends ArrayAdapter<Flowers> {
    private  ArrayList<Flowers> items;
    private Context mContext;
    public FlowerAdapter(Context context, int textViewResourceID, ArrayList<Flowers> items){
        super(context,textViewResourceID,items);
        mContext = context;
        this.items = items;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        Flowers flowers = items.get(position);
        if(v==null){
            LayoutInflater inflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.flowers_list_items,null);

        }
        TextView title = (TextView)v.findViewById(R.id.textView3);
        if (title != null) {
            title.setText(flowers.getName());
        }
        return v;
    }

