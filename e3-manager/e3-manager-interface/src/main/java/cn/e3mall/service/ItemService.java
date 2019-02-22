package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.EasyUIGradResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	
	EasyUIGradResult getItemList(int page, int rows);
}
