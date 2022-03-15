package com.hxddbb.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxddbb.entity.lbillness;
import com.hxddbb.vo.resultresponse;

public interface lbillnesservice {
    Page<lbillness> findlist(Integer pageNo,Integer pageSize,String name,String text);

    resultresponse save(lbillness lbnes);

    lbillness edit(Integer id);

    resultresponse update(lbillness lbnes);

    int del(Integer id);
}
