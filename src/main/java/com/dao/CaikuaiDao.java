package com.dao;

import com.entity.CaikuaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaikuaiView;

/**
 * 财会审核人员 Dao 接口
 *
 * @author 
 */
public interface CaikuaiDao extends BaseMapper<CaikuaiEntity> {

   List<CaikuaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
