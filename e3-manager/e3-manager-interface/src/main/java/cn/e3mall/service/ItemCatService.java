package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.EasyUiTree;

public interface ItemCatService {
	 
	 List<EasyUiTree> findByParentId(Long parentId);
}
