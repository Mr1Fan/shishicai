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
 * 作者：MrXu on 2017/12/27 11:28
 * 邮箱：17610872621@163.com
 */
public class LTFucaiFrag extends NewsBaseFragment implements BaseRecyclerAdapter.Delegate {
    private List<NewsBean> list = new ArrayList<>();

    @Override
    protected void initData() {
        super.initData();
        list.clear();
        BaseRecyclerAdapter adapter = new BaseRecyclerAdapter(getActivity(), this);
        recyclerView.setAdapter(adapter);
        NewsBean bean1 = new NewsBean("小燕子福彩3D:双胆4 9", "2017-10-17 14:06", "http://img1.cache.netease.com/sports/2015/1/9/20150109104658f178d.jpg","     【独胆】:4\n" +
                "【双胆】:4 9\n" +
                "【六码复式】:234589\n" +
                "【缩减到二十注】:\n" +
                "234,246,247,248,345,347,348,349,359,369,\n" +
                "379,389,456,458,459,468,469,478,479,489\n" +
                "大底:\n" +
                "014,024,034,045,046,047,048,124,129,134,\n" +
                "139,145,146,147,148,149,159,169,179,189,\n" +
                "234,239,245,246,247,248,249,259,269,279,\n" +
                "289,345,346,347,348,349,359,369,379,389,\n" +
                "456,457,458,459,467,468,469,478,479,489,\n" +
                "小燕子【3D一周计划分析】（10月16日~10月22日）\n" +
                "三码：167\n" +
                "四码：1267\n" +
                "五码：12467\n" +
                "六码：124679\n" +
                "和值：11 14 16 17\n" +
                "对码：00 11 22 33 99\n" +
                "两码：06 08 27 36 49\n" +
                "组三：\n" +
                "007 008 114 118 225 227 336 339 994 996\n" +
                "组六：\n" +
                "049 057 137 139 142 143 148 236 239 253\n" +
                "259 276 289 358 367463 578 678 862 935\n" +
                "主打组选:\n" +
                "049 057 137 139 142 148 236 239 253 276\n" +
                "289 367 578 678 862\n" +
                "定位：\n" +
                "123567// 02478//123689\n" +
                "单挑一注：276\n" +
                "双色球专刊终极航母来了！！排三260期专家球博士命中直选！！3D第270期专家子墨，老李背着手，悠杉命中组选！\n" +
                "关注微信公众号：ssqzhk1， 收看最新报纸，赢取百万大奖。\n" +
                "来源：双色球专刊（独家提供）");

        NewsBean bean2 = new NewsBean("乾坤福彩3D:五码23468", "2017-10-17 14:05",  "http://img2.cache.netease.com/sports/2015/1/9/20150109104437f4c60.jpg", " 周计划\n" +
                "独胆6\n" +
                "五码23468\n" +
                "六码234678\n" +
                "和值08 09 10 12 14\n" +
                "两码23 24 62 63 64 67 68\n" +
                "组选\n" +
                "234 234 236 238 268 346 348 462 465 466 467 678 683 684 688\n" +
                "【乾坤】283期福彩3D推荐\n" +
                "金胆2\n" +
                "双胆2 6\n" +
                "跨度12356\n" +
                "组选\n" +
                "251,252,253,254,255,256,257,258,259,260,\n" +
                "261,262,263,264,265,266,267,268,269,270,\n" +
                "双色球专刊终极航母来了！！排三260期专家球博士命中直选！！3D第270期专家子墨，老李背着手，悠杉命中组选！\n" +
                "关注微信公众号：ssqzhk1， 收看最新报纸，赢取百万大奖。\n" );

        NewsBean bean3 = new NewsBean("上善若水福彩3D:定位013", "2017-10-17 11:42",  "http://img4.cache.netease.com/sports/2015/1/9/20150109104423cdf98.jpg", "定位：013/123/014 杀码：5 6/0 6/8 9 胆码：134\n" +
                "福彩3D第2017283期号码推荐：\n" +
                "回顾：上期开出568，组六组合，奇偶比1:2，大小比3:0，和值19，202路组合，跨度3。\n" +
                "定位、杀号分析：\n" +
                "一位：上期开出大码奇数5，近10期奇偶比开出6：4。近10期百位上大小比9:1，本期关注小数开出，杀5 6，关注013。\n" +
                "二位：上期开出大码偶数6，近10期奇偶比开出3:7，近10期十位上大小比值7：3， 本期关注小数出号，杀0 6，关注123。\n" +
                "末位：上期开出大码偶数8，近10期奇偶比开出3:7。近10期个位上大小比7:3，本期关注小数出号，杀8 9，关注014。\n" +
                "定位：013/123/014\n" +
                "杀码：5 6/0 6/8 9\n" +
                "胆码：134" );

        NewsBean bean4 = new NewsBean("旭日福彩3D推荐:胆码0 3 7", "2017-09-27 11:00:46", "http://img4.cache.netease.com/sports/2015/1/9/2015010910440651eb5.jpg", "福利彩票3D开奖结果第2017282期：5 6 8，大大大，奇偶偶组合，和值19，跨度3，本期销量44,235,396元，直选中10,896注，组选中14,141注，2017283期福彩3D预测：\n" +
                "上期回顾 胆码中5\n" +
                "胆码分析：近10期号码3出现1次，历史记录与号码0、7关联出号频繁，本期胆码037；\n" +
                "和尾分析：近5期和尾分别为1-2-9-5-9，看好奇数和尾回补，本期推荐和尾059；\n" +
                "跨度分析：近5期跨度分别为9-2-3-9-3，振幅看好偏大，本期推荐跨度179；\n" +
                "定位分析：百位看好奇数荐037；十位看好偶数荐245；个位看好偶数荐689；\n" +
                "下期推荐：\n" +
                "胆码：037-37-3\n" +
                "和尾：059\n" +
                "跨度：179\n" +
                "定位分析：037/245/689\n" +
                "直组选分析：090 091 072 073 096 343 766 776");
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        recyclerView.refreshComplete();
    }

    @Override
    protected void initView() {
        super.initView();

    }
    /**
     * 下拉刷新  上拉加载的方法
     */
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
