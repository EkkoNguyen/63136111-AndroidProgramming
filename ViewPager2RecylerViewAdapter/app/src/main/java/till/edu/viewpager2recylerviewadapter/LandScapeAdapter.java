package till.edu.viewpager2recylerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> listData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View viewItem = cai_bom.inflate(R.layout.item_land, parent, false);

        ItemLandHolder holderCreated = new ItemLandHolder(viewItem);
        return holderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lấy đối tượng hiển thị
        LandScape landScapeHienThi = listData.get(position);
        // Lấy thông tin
        String caption = landScapeHienThi.getLandCaption();
        String tenFileAnh = landScapeHienThi.getLandImageFileName();
        // Đặt vào các trường thông tin của holder
        holder.tvCaption.setText(caption);
        // Đặt ảnh
            String packageName = holder.itemView.getContext().getPackageName();
            int imageId = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.ivLandScape.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaption);
            ivLandScape = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int viTriDuocClick = getAdapterPosition();
            LandScape phanTuDuocClick = listData.get(viTriDuocClick);
            // Lấy thông tin
            String ten = phanTuDuocClick.getLandCaption();
            String tenFileAnh = phanTuDuocClick.getLandImageFileName();
            // Toast Tên
            String chuoiThongBao = "Bạn vừa click vào: " + ten;
            Toast.makeText(view.getContext(), chuoiThongBao, Toast.LENGTH_SHORT).show();
        }
    }
}
