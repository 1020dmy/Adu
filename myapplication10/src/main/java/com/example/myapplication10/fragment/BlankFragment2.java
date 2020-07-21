package com.example.myapplication10.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.myapplication10.MainActivity;
import com.example.myapplication10.R;
import com.example.myapplication10.adapter.MyAdapter;
import com.example.myapplication10.bean.JavaBean;
import com.example.myapplication10.net.ApiService;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    private TableLayout tb;
    private RecyclerView rv;
    private ArrayList<JavaBean.BodyBean.ResultBean> resultBeans;
    private MyAdapter myAdapter;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank2, container, false);
        rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
        resultBeans = new ArrayList<>();
        initData();
        myAdapter = new MyAdapter(getActivity(), resultBeans);
        rv.setAdapter(myAdapter);
        return inflate;
    }

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<JavaBean> getjavabean = apiService.getjavabean();
        getjavabean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JavaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(JavaBean javaBean) {
                        resultBeans.addAll(javaBean.getBody().getResult());
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
