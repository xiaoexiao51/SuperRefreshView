package com.superrefreshview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.superrefreshview.R;
import com.superrefreshview.adapter.BaseRecyclerAdapter;
import com.superrefreshview.adapter.RecyclerViewDivider;
import com.superrefreshview.adapter.SimpleNewsAdapter;
import com.superrefreshview.bean.SimpleNewsBean;
import com.superrefreshview.widget.DefaultFooter;
import com.superrefreshview.widget.DefaultHeader;
import com.superrefreshview.widget.QQHeader;
import com.superrefreshview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.spring_view)
    SpringView mSpringView;
    //    @Bind(R.id.refresh_view)
//    XRefreshView mRefreshView;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private SimpleNewsAdapter mNewsAdapter;
    private List<SimpleNewsBean.ContentBean> mSimpleNewBeens = new ArrayList<>();
    private int refreshCount;

    {
        mSimpleNewBeens.add(new SimpleNewsBean.ContentBean(R.drawable.ic_flower, "我需要三件东西：爱情友谊和图书。然而这三者之间何其相通！炽热的爱情可以充实图书的内容，图书又是人们最忠实的朋友。", "2-20"));
        mSimpleNewBeens.add(new SimpleNewsBean.ContentBean(R.drawable.ic_flower, "世界上一成不变的东西，只有“任何事物都是在不断变化的”这条真理。 —— 斯里兰卡", "2-20"));
        mSimpleNewBeens.add(new SimpleNewsBean.ContentBean(R.drawable.ic_flower, "守住心底那最美风景，成为一种风度，宁静而致远；守住记忆里最美风景，成为一种境界，悠然而豁达；守住生命中最美风景，成为一种睿智，淡定而从容。", "2-20"));
        mSimpleNewBeens.add(new SimpleNewsBean.ContentBean(R.drawable.ic_flower, "生命力的意义在于拚搏，因为世界本身就是一个竞技场，就是无数次被礁石击碎又无数闪地扑向礁石，生命的绿荫才会越长越茂盛。", "2-20"));
        mSimpleNewBeens.add(new SimpleNewsBean.ContentBean(R.drawable.ic_flower, "我们要学会理解红尘的喧嚣变幻，懂得一路从容淡然；要学会原谅人生的不完美，珍惜、善待生命的每一天。", "2-20"));
        mSimpleNewBeens.add(new SimpleNewsBean.ContentBean(R.drawable.ic_flower, "我们要学会理解红尘的喧嚣变幻，懂得一路从容淡然；要学会原谅人生的不完美，珍惜、善待生命的每一天。", "2-20"));
        mSimpleNewBeens.add(new SimpleNewsBean.ContentBean(R.drawable.ic_flower, "我们要学会理解红尘的喧嚣变幻，懂得一路从容淡然；要学会原谅人生的不完美，珍惜、善待生命的每一天。", "2-20"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRefreshView();
        initRecyclerView();
    }

    private void initRefreshView() {
//        mSpringView.setType(SpringView.Type.FOLLOW);
//        mSpringView.setGive(SpringView.Give.BOTH);
        mSpringView.setHeader(new DefaultHeader(this));
        mSpringView.setFooter(new DefaultFooter(this));

        mSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                mSpringView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshCount++;
                        if (refreshCount % 2 != 0) {
                            mSpringView.setHeader(new QQHeader());
                        } else {
                            mSpringView.setHeader(new DefaultHeader(MainActivity.this));
                        }
                        mSpringView.onFinishFreshAndLoad();
                    }
                }, 5000);
            }

            @Override
            public void onLoadmore() {
                mSpringView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSpringView.onFinishFreshAndLoad();
                    }
                }, 1000);
            }
        });

//        mRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
//
//            @Override
//            public void onRefresh(boolean isPullDown) {
//                super.onRefresh(isPullDown);
//                mRefreshView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                    }
//                }, 1000);
//                Toast.makeText(MainActivity.this, "到底了", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLoadMore(boolean isSilence) {
//                super.onLoadMore(isSilence);
//                mRefreshView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                }, 1000);
//                Toast.makeText(MainActivity.this, "到底了", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void initRecyclerView() {

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setNestedScrollingEnabled(false);

        mRecyclerView.addItemDecoration(new RecyclerViewDivider(
                this, LinearLayoutManager.HORIZONTAL, 2, getResources().getColor(R.color.colorPrimary)));

        mNewsAdapter = new SimpleNewsAdapter(this, mSimpleNewBeens);
        mRecyclerView.setAdapter(mNewsAdapter);
        mNewsAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int pos) {

            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && !recyclerView.canScrollVertically(1)) {
                    Toast.makeText(MainActivity.this, "到底了:" + dy, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
