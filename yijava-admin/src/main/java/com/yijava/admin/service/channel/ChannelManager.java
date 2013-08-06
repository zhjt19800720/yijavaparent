package com.yijava.admin.service.channel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yijava.admin.common.enumeration.entity.ResourceType;
import com.yijava.admin.dao.channel.ChannelDao;
import com.yijava.admin.entity.account.Resource;
import com.yijava.admin.entity.channel.Channel;
import com.yijava.orm.core.RestrictionNames;

@Service
@Transactional
public class ChannelManager {

	@Autowired
	private ChannelDao channelDao;

	public List<Channel> getAllChannel() {

		return null;
		// return
		// channelDao.finddataDictionaryDao.findByQuery(DataDictionary.FindByCateGoryCode,
		// code.getCode());
	}

	public void saveChannel(Channel entity) {
		channelDao.save(entity);
	}

	/**
	 * 通过资源id删除资源
	 * 
	 * @param ids
	 *            资源id集合
	 */
	public void deleteChannel(List<String> ids) {
		channelDao.deleteAll(ids);
	}

	/**
	 * 获取所有父类资源
	 * 
	 * @return List
	 */
	public List<Channel> getAllParentResources() {
		return channelDao.findByProperty("parent_channel", null);
	}

	public List<Channel> getAllResources(String... ignoreIdValue) {

		if (ArrayUtils.isNotEmpty(ignoreIdValue)) {
			return channelDao.findByProperty("id", ignoreIdValue,
					RestrictionNames.NIN);
		}

		return channelDao.getAll();
	}

	public List<Channel> mergeChannelsToParent(List<Channel> list) {
		List<Channel> result = new ArrayList<Channel>();

		for (Channel r : list) {
			if (r.getParent_channel() == null) {
				mergeChannelsToParent(list, r);
				result.add(r);
			}
		}

		return result;
	}
	
	
	/**
	 * 遍历list中的数据,如果数据的父类与parent相等，将数据加入到parent的children中
	 * 
	 * @param list 资源集合
	 */
	private void mergeChannelsToParent(List<Channel> list, Channel parent) {
		if (!parent.getLeaf()) {
			return ;
		}
		
		parent.setChildren(new ArrayList<Channel>());
		
		for (Channel r: list) {
			
			if ( StringUtils.equals(r.getParent_channel(),parent.getId()) ) {
				r.setChildren(null);
				mergeChannelsToParent(list,r);
				parent.getChildren().add(r);
			}
			
		}
	}

}
