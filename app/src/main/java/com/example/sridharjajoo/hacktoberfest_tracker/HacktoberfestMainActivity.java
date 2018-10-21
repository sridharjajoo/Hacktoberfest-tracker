package com.example.sridharjajoo.hacktoberfest_tracker;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sridharjajoo.hacktoberfest_tracker.data.GithubService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.disposables.CompositeDisposable;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HacktoberfestMainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    GithubService githubService;

    @BindView(R.id.search_view)
    android.support.v7.widget.SearchView searchView;

    @BindView(R.id.iv_check)
    ImageView iv_check;

    @BindView(R.id.tv_hello)
    TextView tv_hello;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacktoberfest_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_check)
    public void checkClick() {
        String username = searchView.getQuery().toString();
        compositeDisposable.add(githubService.findValidPullRequests(username)
                .doOnSubscribe(disposable -> progressBar.setVisibility(VISIBLE))
                .doFinally(() -> progressBar.setVisibility(GONE))
                .subscribe((count) -> tv_hello.setText(count.totalCount)));
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
