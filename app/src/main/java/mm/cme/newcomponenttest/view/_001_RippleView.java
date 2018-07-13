package mm.cme.newcomponenttest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/13
 * Email：ibelieve1210@163.com
 */
public class _001_RippleView extends View {

    private Context mContext;

    //定义控件长宽高和半径
    private int radius;
    private Paint paint;

    private int startDiameter = 200;//波纹出现时的直径
    private int midDiameter;//波纹颜色最深时的直径
    private int endDiameter;//波纹消失时的直径（也即控件宽高中最小的一个）
    private int rippleWidth = 2;//波纹的宽度
    private int rippleColor = Color.parseColor("#ffffff");//波纹的颜色

    private int maxPaintAlpha = 140;

    private List<Integer> radiusList = new ArrayList<>();//放置绘制出来的波
    private long current = System.currentTimeMillis();//获得当前时间

    //开启handle进行重复绘制
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidate();//刷新的方法
            //隔一段时间添加一个波
            if (System.currentTimeMillis() - current > 1400) {
                radiusList.add(startDiameter / 2);
                current = System.currentTimeMillis();//当前时间重新赋值刷新
            }
            //改变半径的值
            for (int i = 0; i < radiusList.size(); i++) {
                radiusList.set(i, radiusList.get(i) + 1);//不断的改变半径
            }
            //性能优化，控制波的数量(迭代器)
            Iterator<Integer> iterator = radiusList.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();//获取这个值
                if (next >= endDiameter / 2) {//大于结束时半径并且包含则移除
                    if (radiusList.contains(next)) {
                        iterator.remove();//使用迭代器来移除（否则有异常）
                    }
                }
            }
            handler.postDelayed(runnable, 40);
        }
    };

    public _001_RippleView(Context context) {
        this(context, null);
    }

    public _001_RippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public _001_RippleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        startDiameter = dp2px(5);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(rippleWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(rippleColor);
        radius = startDiameter / 2;
        radiusList.add(radius);
    }

    protected void onDraw(Canvas canvas) {
        endDiameter = Math.min(canvas.getWidth(), canvas.getHeight());
        midDiameter = startDiameter + (endDiameter - startDiameter) / 2;

        //绘制波纹，同时改变透明度
        for (int i = 0; i < radiusList.size(); i++) {
            int r = radiusList.get(i);//绘制的半径
            if (r < midDiameter / 2) {
                paint.setAlpha(maxPaintAlpha * (r - startDiameter / 2) / ((endDiameter - startDiameter) / 2));//根据半径来让透明度变化
            } else {
                paint.setAlpha(maxPaintAlpha - maxPaintAlpha * (r - startDiameter / 2) / ((endDiameter - startDiameter) / 2));//根据半径来让透明度变化
            }
            canvas.drawCircle(endDiameter / 2, endDiameter / 2, r, paint);
        }
        super.onDraw(canvas);
    }

    public void onStart() {
        handler.post(runnable);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dp2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 设置RippleView开始显示时的直径
     *
     * @param startDiameterDp 直径（单位：dp）
     */
    public void setStartDiameter(int startDiameterDp) {
        startDiameter = dp2px(startDiameterDp);
        radius = startDiameter / 2;
        radiusList.clear();
        radiusList.add(radius);
    }

    /**
     * 设置RippleView结束显示时的直径
     *
     * @param endDiameter 直径（单位：px）
     */
    public void setEndDiameter(int endDiameter) {
        this.endDiameter = endDiameter;
    }

    /**
     * 设置RippleView线条的颜色
     *
     * @param rippleColor 颜色
     */
    public void setRippleColor(int rippleColor) {
        paint.setColor(rippleColor);
    }
}