package ncku.edu.tw.testapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HobbyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList arrayList;
    Context mContext;

    public HobbyListAdapter(Context context) {
        mContext = context;
        arrayList = new ArrayList<Hobby>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_view_hoppy,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Hobby hobby = (Hobby) arrayList.get(position);
        ((ViewHolder)holder).bindToHobby(hobby);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void addItem(Hobby hobby) {
        arrayList.add(hobby);
        notifyDataSetChanged();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.hobbyAddImage);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    arrayList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        public void bindToHobby(Hobby hobby) {
            textView.setText(hobby.getHobby());
        }
    }
}
