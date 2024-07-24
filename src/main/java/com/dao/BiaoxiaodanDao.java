package com.dao;

import com.entity.BiaoxiaodanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BiaoxiaodanView;

/**
 * 报销单 Dao 接口
 *
 * @author 
 */
public interface BiaoxiaodanDao extends BaseMapper<BiaoxiaodanEntity> {

   List<BiaoxiaodanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
