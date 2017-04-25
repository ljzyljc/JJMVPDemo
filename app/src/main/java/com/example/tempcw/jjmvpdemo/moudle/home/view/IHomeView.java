package com.example.tempcw.jjmvpdemo.moudle.home.view;

import com.example.tempcw.jjmvpdemo.moudle.home.bean.GridItem;
import com.example.tempcw.jjmvpdemo.mvp.view.IBaseView;

/**
 * Created by TempCw on 2017/4/18.
 */

public interface IHomeView extends IBaseView<GridItem>{

    @Override
    void success(GridItem gridItem);

    @Override
    void failed(String s);
}
