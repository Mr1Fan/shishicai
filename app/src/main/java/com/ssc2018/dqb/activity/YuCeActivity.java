package com.ssc2018.dqb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.bean.NewsBean;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 13:12
 * 邮箱：17610872621@163.com
 */
public class YuCeActivity extends BaseActivty implements BaseRecyclerAdapter.Delegate,XRecyclerView.LoadingListener {

    public XRecyclerView recyclerView;
    private List<NewsBean> list = new ArrayList<>();


    @Override
    public void onRefresh() {
        //下拉刷新
        initData();
    }

    @Override
    public void onLoadMore() {
        recyclerView.loadMoreComplete();
        ToastUtils.show("没有更多数据了",this);
    }

    @Override
    public List<NewsBean> getData() {
        return list;
    }


    @Override
    public int getView(ViewGroup parent, int viewType) {
        return R.layout.items_news;
    }

    @Override
    public <T> void bindView(RecyclerViewHolder holder, int position, T item) {
        final NewsBean newsBean = (NewsBean) item;
        holder.setText(R.id.news_title, newsBean.names);
        holder.setText(R.id.news_time, newsBean.data);
        // ImageView new_img= (ImageView) holder.getView(R.id.new_img);
        //   new_img.setImageURI(Uri.parse(newsBean.imgs));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YuCeActivity.this, NewsDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("hemaiBean", newsBean);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        list.clear();
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(this, this);
        recyclerView.setAdapter(adapter);
        NewsBean bean1 = new NewsBean("秦风122期:除4余3看03 07 27", "2017-10-17 11:47", "res://com.cqssc1030.xin6/" + R.mipmap.baiwangdajiang, "双色球17121期开奖号码：11 18 19 22 24 32+07，大小比5：1，奇偶比2：4，和值126，012路比2:2:2，蓝球1路小码07。\n" +
                "双色球第17122期分析：\n" +
                "红球分析：\n" +
                "除4分析：每个号码除4余数共有0-3，4个数字。此法细分双色球号码，每期必有至少一个余数不会开出，有利于杀码和定胆。(除了余1号码是9个数字外，其余都是8个数字组成)\n" +
                "余1：01 05 09 13 17 21 25 29 33 上期开出号码无，近10期出号走2-1-1-0-2-2-3-0-0，近期余1号码上奖势头转折，其中，09 21 25 33开出2次，01 13 29开出1次，轮空号码05 17。根据出号走势，本期看好余1号码持续上奖，参考2~3枚。推荐：05 17 29\n" +
                "余2：02 06 10 14 18 22 26 30上期开出号码18 22，近10期出号走势3-1-2-2-4-2-2-1-1-2，近期余2号码走势转折，22开出4次，10 14 30开出3次，02 06 18 26开出2次，轮空号码无。根据出号走势，本期余2号码持续上奖，参考2~3枚。推荐：06 26\n" +
                "余3：03 07 11 15 19 23 27 31 上期开出号码11 19，近10期出号走势1-2-1-1-2-0-1-1-1-3-2，近期余3号码整体出号走势转强，目前上奖看好2至3个，其中，11 15开出3次，19 23 31开出2次，03 27开出1次，轮空号码07。根据出号走势，本期余3号码看出号看好，看好2-3个。推荐03 07 27\n" +
                "余0：04 08 12 16 20 24 28 32上期开出号码24 32，近10期出号走势1-2-1-1-2-1-1-1-2-2，近期余2号码上奖走势转折，其中，08 16开出3次，04 32开出2次，12 20 24 28开出1次，轮空号码无。根据出号走势，本期余0号码看好上奖，参考2-3枚。推荐：12 28。\n" +
                "红球推荐（10码）：03 05 06 07 12 17 26 27 28 29\n" +
                "蓝球推荐（4码）：15 10 04 08\n" +
                "心水推荐： 03 06 12 17 27 29+04");

        NewsBean bean2 = new NewsBean("颖彩122期:本期独蓝推荐15", "2017-10-17 14:32", "res://com.cqssc1030.xin6/" + R.mipmap.huiyuanzixun, " 双色球17121期开奖号码：11 18 19 22 24 32+07，大小比5：1，奇偶比2：4，和值126，012路比2:2:2，蓝球1路小码07。\n" +
                "颖彩双色球17122期蓝球分析\n" +
                "一区（01-04）：近10期开出号码01 02各一次，目前该区号码近期表现转折，从遗漏数据分析，目前该区号码03遗漏24期，04遗漏22期，根据近期蓝色球出号走势，本期不看好该区号码出号，推荐号码：暂无。\n" +
                "二区（05-08）：上期开出号码07，近10期中开号码05 07各一次， 从走势上看，该区号码近期表现转折；从遗漏数据分析，08遗漏41期，目前该区号码看好出号，推荐出号：08。\n" +
                "三区（09-12）：近10期中开出号码09 11各一次，从走势上看，该区号码近期表现转折。从遗漏数据分析，目前该区10遗漏39期，根据近期蓝球走势来看，本期看好该区号码继续出号，本期推荐号码：10\n" +
                "四区（13-16）：近10开出号码13 14各一次，16二次，从走势上看，该区号码表现转折。从号码遗漏期数分析，15遗漏52期，根据近期蓝球走势，本期看好该区号码出号。推荐号码：15。\n" +
                "综合推荐\n" +
                "三码蓝球：08 10 15\n" +
                "二蓝：10 15\n" +
                "独蓝：15");

        NewsBean bean3 = new NewsBean("球博士122期:后区2码07 11", "2017-09-29 08:37",  "res://com.cqssc1030.xin6/" + R.mipmap.baiwangdajiang,"【前胆推荐】\n" +
                "前区独胆：21\n" +
                "前区双胆：15,21\n" +
                "【前区预测】\n" +
                "前区10码：06,07,15,19,21,23,25,31,33,35\n" +
                "前区12码：01,06,07,08,15,19,21,23,25,31,33,35\n" +
                "前区14码：01,02,04,06,07,08,15,19,21,23,25,31,33,35\n" +
                "前区16码：01,02,04,06,07,08,15,19,20,21,22,23,25,31,33,35\n" +
                "前区18码：01,02,04,06,07,08,11,15,17,19,20,21,22,23,25,31,33,35\n" +
                "【后区预测】\n" +
                "后区6码：02,03,07,09,11,12\n" +
                "后区4码：07,09,11,12\n" +
                "后区2码：07,11\n" +
                "双色球专刊终极航母来了！！双色球111期专家张哥命中6红，报纸专家命中5红！大乐透105期专家冯将军命中4+1！");

        NewsBean bean4 = new NewsBean("晶晶亮透122期:看好大号回补", "2017-10-17 14:31", "res://com.cqssc1030.xin6/" + R.mipmap.baiwangdajiang, "2017121期大乐透开奖号码 前区：01 06 12 26 31后区：01 07\n" +
                "上期开奖号前区区间比为3：0：2，奇偶比为2：3，和值为76，大小比为2：1，无号码连号\n" +
                "17122期大乐透号码分析：\n" +
                "【前区说明】\n" +
                "上期奇偶比为2:3，上期偶号热出，本期看好偶号延热，关注2：3或1：4\n" +
                "上期大小比为2:3，上期小号反弹，本期看好大号回补，关注3：2或4：1\n" +
                "上期前区间比为3：0：2，根据上期走势，本期看好第1区间有2码以上开出，关注2：2：1或3：1：1\n" +
                "上期和值76点，本期看好和值84以内\n" +
                "第17122期前区组选大底：03 08 11 15 18 24 28 33\n" +
                "精选号码：03 11 18 24 28\n" +
                "【后区说明】\n" +
                "上期开出01 07，小大、全奇的组合，本期看好间距5，看好04 09");

        NewsBean bean5 = new NewsBean("喜子排列3:重点关注胆码9", "2017-10-17 14:24", "res://com.cqssc1030.xin6/" + R.mipmap.huiyuanzixun, "【胆码】三胆947二胆94独胆9；\n" +
                "【定位】9**；\n" +
                "【五码】46789\n" +
                "【组选大底】936,937,938,939,940,941,942,943,944,945,\n" +
                "946,947,948,949,950,951,952,953,954,955,\n" +
                "双色球专刊终极航母来了！！排三260期专家球博士命中直选！！3D第270期专家子墨，老李背着手，悠杉命中组选！");

        NewsBean bean6 = new NewsBean("球博士排列3:重点关注胆码2", "2017-10-17 14:12",  "res://com.cqssc1030.xin6/" + R.mipmap.baiwangdajiang,"一、【胆码】：金胆2；银胆:8\n" +
                "二、【定位胆】：2*\n" +
                "三、【定位双胆】：28*、2*7\n" +
                "四、【五码】25678\n" +
                "五、【六码】：235678\n" +
                "六、【金一注】：287\n" +
                "七、【直选（组选）】271,272,273,274,275,276,277,278,279,280,\n" +
                "281,282,283,284,285,286,287,288,289,290,\n" +
                "双色球专刊终极航母来了！！排三260期专家球博士命中直选！！3D第270期专家子墨，老李背着手，悠杉命中组选");

        NewsBean bean7 = new NewsBean("蓝色妖姬3d:冷码回补一枚", "2017-10-17 14:31", "", "福彩3D第2017282期开奖号码为：5 6 8，组六形态，大小比为3:0，奇偶比为1:2，和值为19，跨度为3。福彩3D2017283期专家预测号码：\n" +
                "质合预测：2017282期质合比值开出1:2，由于物极必反的道理，最新一期看好2质1合成为主流。\n" +
                "冷号：上期的奖号里没有出现冷码，结合近30期开出号码情况来看，下期冷态号码或将回补一枚。\n" +
                "跨度参考：282期开出跨度值3，近期跨度值表现出的走势规律比较明显，连续三期开出0路跨度，283期考虑2路区间跨度值。\n" +
                "除3余数分析：上期012路走势开出1:0:2的比值，综合多期012路数据分析，下期优先考虑1路号码回补。");

        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        list.add(bean6);
        list.add(bean7);
        recyclerView.refreshComplete();
    }

    @Override
    public void findView() {
        recyclerView = (XRecyclerView) findViewById(R.id.xrecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallClipRotatePulse);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);
        recyclerView.setLoadingListener(this);

        ((TextView) findViewById(R.id.title)).setText("彩票预测");
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.yuce_layout;
    }
}
