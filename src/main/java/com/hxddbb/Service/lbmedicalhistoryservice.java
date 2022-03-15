package com.hxddbb.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbmedicalhistory;
import com.hxddbb.vo.resultresponse;

public interface lbmedicalhistoryservice {
    //查询所有
    Page<lbmedicalhistory> findlist(long pageNo, long pageSize, lbmedicalhistory lmed);
//增加
    resultresponse save(lbmedicalhistory lmed);
    //根据主键查询
    lbmedicalhistory edit(Integer id);
    //更新
    resultresponse update(lbmedicalhistory lmed);
    //删除
    resultresponse del(Integer id);

}
