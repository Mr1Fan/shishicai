package com.ssc2018.dqb.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.ssc2018.dqb.activity.NewsDetailsActivity;
import com.ssc2018.dqb.adapter.BaseRecyclerAdapter;
import com.ssc2018.dqb.adapter.RecyclerViewHolder;
import com.ssc2018.dqb.bean.NewsBean;
import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：MrXu on 2017/12/27 11:31
 * 邮箱：17610872621@163.com
 */
public class LTTiCaiFrag extends NewsBaseFragment implements BaseRecyclerAdapter.Delegate{
    private List<NewsBean> list = new ArrayList<>();

    @Override
    protected void initData() {
        super.initData();
        list.clear();
        NewsBean bean1 = new NewsBean("喜子排列3:重点关注胆码9", "2017-09-27 11:00:46", "http://img1.cache.netease.com/sports/2015/1/9/20150109104612dc35e.jpg", "【胆码】三胆947二胆94独胆9；\n" +
                "【定位】9**；\n" +
                "【五码】46789\n" +
                "【组选大底】936,937,938,939,940,941,942,943,944,945,\n" +
                "946,947,948,949,950,951,952,953,954,955,\n" +
                "双色球专刊终极航母来了！！排三260期专家球博士命中直选！！3D第270期专家子墨，老李背着手，悠杉命中组选！");

        NewsBean bean2 = new NewsBean("乾坤排列3:重点关注胆码5", "2017-09-27 11:00:46", "http://img2.cache.netease.com/sports/2015/1/9/20150109104437f4c60.jpg", "银胆】1,3\n" +
                "【乾坤一注】513\n" +
                "【组选精选】505,506,507,508,509,510,511,512,513,514,\n" +
                "515,516,517,518,519,520,521,522,523,524,\n" +
                "双色球专刊终极航母来了！！排三260期专家球博士命中直选！！3D第270期专家子墨，老李背着手，悠杉命中组选！");

        NewsBean bean3 = new NewsBean("牡丹花排列三:个位两胆码8 9", "2017-09-27 11:00:46", "http://img3.cache.netease.com/sports/2015/1/9/201501091044328b4ec.jpg", "排列三17282开奖回顾：302，奇偶偶，全小，和值5，跨度3，002路，质合质\n" +
                "奇偶分析：上一期开出了奇偶偶，上期偶号出号占多，本期关注偶号出号希望较大\n" +
                "大小分析：上一期开出了全小，上期小号强势出击，本期关注大号有望回补\n" +
                "012路分析：上一期开出了002路，012路比为2:0:1，本期关0路码出号\n" +
                "质合分析：上一期开出了质合质，上期质数优势出号，本期关注合数有所发挥\n" +
                "本期胆码推荐：\n" +
                "百位：4 9\n" +
                "十位：0 6\n" +
                "个位：8 9");

        NewsBean bean4 = new NewsBean("寒若冰七星彩:旧码012569", "2017-09-27 11:00:46", "http://img3.cache.netease.com/sports/2015/1/9/201501091044534a568.jpg", "[上期中4位]\n" +
                "17119期开奖号码2665036\n" +
                "17120期开奖号码1283878\n" +
                "17121期开奖号码5161209\n" +
                "综上：新码4，旧码012569，跳码378\n" +
                "17122期七星彩新旧跳走势分析：\n" +
                "一位：上期开出跳码5，近10期新旧跳比2：6：2，本期建议关注旧码出号，重点看好06防新码4跳码8\n" +
                "二位：上期开出旧码1，近10期新旧跳比2：5：3，本期建议关注旧码出号，重点看好25防新码4跳码3\n" +
                "三位：上期开出跳码6，近10期新旧跳比2：7：1，本期建议关注旧码出号，重点看好59防新码4跳码3\n" +
                "四位：上期开出旧码1，近10期新旧跳比3：4：3，本期建议关注旧码出号，重点看好56防新码4跳码8\n" +
                "五位：上期开出旧码2，近10期新旧跳比2：7：1，本期建议关注旧码出号，重点看好69防新码4跳码7\n" +
                "六位：上期开出跳码0，近10期新旧跳比2：3：5，本期建议关注旧码出号，重点看好25防新码4跳码3\n" +
                "七位：上期开出新码9，近10期新旧跳比5：5：0，本期建议关注旧码出号，重点看好56防新码4跳码7\n" +
                "一位0648二位2543三位5943四位5648五位6947六位2543七位5647！");

        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(getActivity(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.refreshComplete();
    }

    @Override
    public void onRefresh() {
        //下拉刷新
        initData();
    }

    @Override
    public void onLoadMore() {
        //上拉加载
        recyclerView.loadMoreComplete();
        ToastUtils.show("没有更多数据了", getActivity());
    }

    @Override
    protected void initView() {
//        Fresco.initialize(getContext());
        super.initView();
    }

    @Override
    public int getFragmentViewById() {
        return R.layout.lt_football_frag;
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
//        SimpleDraweeView new_img= (SimpleDraweeView) holder.getView(R.id.new_img);
//        new_img.setImageURI(Uri.parse(newsBean.imgs));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("hemaiBean", newsBean);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
