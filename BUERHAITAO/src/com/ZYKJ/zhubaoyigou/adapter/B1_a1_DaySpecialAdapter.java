package com.ZYKJ.zhubaoyigou.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ZYKJ.zhubaoyigou.R;
import com.ZYKJ.zhubaoyigou.utils.AnimateFirstDisplayListener;
import com.ZYKJ.zhubaoyigou.utils.ImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * @author lss 2015年6月26日 天天特价Adapter
 *
 */
public class B1_a1_DaySpecialAdapter extends BaseAdapter {
	private Activity context;
	List<Map<String, String>> data = new ArrayList<Map<String, String>>();
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

	public B1_a1_DaySpecialAdapter(Activity context, List<Map<String, String>> data) {
		this.context = context;
		this.data=data;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder ViewHolder=null;
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		if(convertView==null){
			ViewHolder=new ViewHolder();
			convertView=LinearLayout.inflate(context, R.layout.b1_a1_dayspecial1, null);
			ViewHolder.im_b1_a1_pic1=(ImageView) convertView.findViewById(R.id.im_b1_a1_pic1);
			 LayoutParams params = ViewHolder.im_b1_a1_pic1.getLayoutParams();  
			 params.height=width/3-10;  
			 params.width =width/3;  
			 ViewHolder.im_b1_a1_pic1.setLayoutParams(params);  
			ViewHolder.tv_b1_a1_chanpinname1=(TextView) convertView.findViewById(R.id.tv_b1_a1_chanpinname1);
			ViewHolder.tv_b1_a1_chanpinjianjie1=(TextView) convertView.findViewById(R.id.tv_b1_a1_chanpinjianjie1);
			ViewHolder.tv_b1_a1_zhehoujia1=(TextView) convertView.findViewById(R.id.tv_b1_a1_zhehoujia1);
			ViewHolder.tv_b1_a1_yuanjia1=(TextView) convertView.findViewById(R.id.tv_b1_a1_yuanjia1);
			convertView.setTag(ViewHolder);
		}else{
			ViewHolder=(ViewHolder) convertView.getTag();
		}
		ImageLoader.getInstance().displayImage((String)data.get(position).get("goods_image"), ViewHolder.im_b1_a1_pic1, ImageOptions.getOpstion(), animateFirstListener);
//		ImageLoader.getInstance().displayImage((String)data.get(position).get("goods_image"), ViewHolder.im_b1_a1_pic1);
		ViewHolder.tv_b1_a1_chanpinname1.setText(data.get(position).get("goods_name"));
		ViewHolder.tv_b1_a1_chanpinjianjie1.setText(data.get(position).get("goods_jingle"));
		ViewHolder.tv_b1_a1_zhehoujia1.setText("￥"+data.get(position).get("goods_promotion_price"));
		ViewHolder.tv_b1_a1_yuanjia1.setText("￥"+data.get(position).get("goods_price"));
		ViewHolder.tv_b1_a1_yuanjia1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		
		return convertView;
	}
	public final class ViewHolder {  
        public ImageView im_b1_a1_pic1;
        public TextView tv_b1_a1_chanpinname1;
        public TextView tv_b1_a1_chanpinjianjie1;
        public TextView tv_b1_a1_zhehoujia1;
        public TextView tv_b1_a1_yuanjia1;
    }  
}
