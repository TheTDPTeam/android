package adapter;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ViewHolder {
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private ImageView imageView_1;
    private ListView lv_1;
    public ViewHolder(){

    }

    public ListView getLv_1() {
        return lv_1;
    }

    public void setLv_1(ListView lv_1) {
        this.lv_1 = lv_1;
    }

    public TextView getTv_1() {
        return tv_1;
    }

    public void setTv_1(TextView tv_1) {
        this.tv_1 = tv_1;
    }

    public TextView getTv_2() {
        return tv_2;
    }

    public void setTv_2(TextView tv_2) {
        this.tv_2 = tv_2;
    }

    public TextView getTv_3() {
        return tv_3;
    }

    public void setTv_3(TextView tv_3) {
        this.tv_3 = tv_3;
    }

    public TextView getTv_4() {
        return tv_4;
    }

    public void setTv_4(TextView tv_4) {
        this.tv_4 = tv_4;
    }

    public ImageView getImageView_1() {
        return imageView_1;
    }

    public void setImageView_1(ImageView imageView_1) {
        this.imageView_1 = imageView_1;
    }
}
