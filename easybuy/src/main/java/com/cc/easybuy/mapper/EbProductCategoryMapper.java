package com.cc.easybuy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.easybuy.model.EbProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Mapper
public interface EbProductCategoryMapper extends BaseMapper<EbProductCategory> {

    //查询所有大类的方法
    List<EbProductCategory> selectBigCate();
    //查询所有小类的方法
    List<EbProductCategory> selectSmallCate();
}
