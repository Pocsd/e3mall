package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.EasyUiTree;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatmapper;
	
	@Override
	public List<EasyUiTree> findByParentId(Long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> itemCats = itemCatmapper.selectByExample(example);
		List<EasyUiTree> treees = new ArrayList<EasyUiTree>();
		for(TbItemCat itemCat:itemCats){
			EasyUiTree tree = new EasyUiTree();
			tree.setId(itemCat.getId());
			tree.setText(itemCat.getName());
			tree.setState(itemCat.getIsParent() ? "closed" : "opean");
			treees.add(tree);
		}
		return treees;
	}

}
