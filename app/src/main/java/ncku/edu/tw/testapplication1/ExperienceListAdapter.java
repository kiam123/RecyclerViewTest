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

public class ExperienceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList arrayList;
    Context mContext;

    public ExperienceListAdapter(Context context) {
        mContext = context;
        arrayList = new ArrayList<Experience>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_view_experince,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Experience experience = (Experience) arrayList.get(position);
        ((ViewHolder)holder).bindToHobby(experience);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void addItem(Experience experience) {
        arrayList.add(experience);
        notifyDataSetChanged();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.experienceAddImage);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    arrayList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        public void bindToHobby(Experience experience) {
            textView.setText(experience.getExperience());
        }
    }
}
