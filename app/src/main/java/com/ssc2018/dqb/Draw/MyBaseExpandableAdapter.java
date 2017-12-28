package com.ssc2018.dqb.Draw;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.ssc2018.dqb.bean.*;

import java.util.ArrayList;

/**
 * Created by xrc on 2017/12/15.
 * 万能适配器
 */

public class MyBaseExpandableAdapter<T> extends BaseExpandableListAdapter {
    private ArrayList<String> group_list = new ArrayList<>();
    private ArrayList<com.ssc2018.dqb.bean.EverydayDataBean<PlayDataBean>> football_list = new ArrayList<com.ssc2018.dqb.bean.EverydayDataBean<PlayDataBean>>();
    private Context mContext;

    private PageDelegate delegate;

    public interface PageDelegate{
        <T> ArrayList<com.ssc2018.dqb.bean.EverydayDataBean<PlayDataBean>> getData();
        ArrayList<String> getGroupData();
        Context getContext();
        View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent);
        void bindGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent);
        View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent);
        void bindChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent);
    }

    public MyBaseExpandableAdapter(PageDelegate delegate) {
        this.delegate = delegate;
        if (delegate!=null){
            this.group_list = delegate.getGroupData();
            this.football_list = delegate.getData();
            this.mContext = delegate.getContext();
        }
    }

    @Override
    public int getGroupCount() {
        return group_list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return football_list.get(groupPosition).getPlay_list().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group_list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return football_list.get(groupPosition).getPlay_list().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = delegate.getGroupView(groupPosition,isExpanded,convertView,parent);
        }
        delegate.bindGroupView(groupPosition,isExpanded,convertView,parent);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = delegate.getChildView(groupPosition,childPosition,isLastChild,convertView,parent);
        }
        delegate.bindChildView(groupPosition,childPosition,isLastChild,convertView,parent);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    /**
     *  优化代码，更新单个数据
     * @param expendlist
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param parent
     */
    public void notifyDataSetChanged(ExpandableListView expendlist, int groupPosition, int childPosition, boolean isLastChild, ViewGroup parent) {
        super.notifyDataSetChanged();

        /**第一个可见的位置**/
        int firstVisiblePosition = expendlist.getFirstVisiblePosition();

        /**最后一个可见的位置**/
        int lastVisiblePosition = expendlist.getLastVisiblePosition();

        /**在看见范围内才更新，不可见的滑动后自动会调用getView方法更新**/
        if (childPosition >= firstVisiblePosition && childPosition <= lastVisiblePosition) {
            /**获取指定位置view对象**/
            View view = expendlist.getChildAt(childPosition - firstVisiblePosition);
            getChildView(groupPosition,childPosition,isLastChild,view, parent);
        }
    }
}
