package com.yijava.admin.web.channel;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.admin.entity.channel.Channel;
import com.yijava.admin.service.channel.ChannelManager;
import com.yijava.admin.web.model.Menu;
import com.yijava.orm.core.Page;
import com.yijava.orm.core.PageRequest;

@Controller
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	private ChannelManager channelmanager;

	/**
	 * 获取用户列表
	 * 
	 * @param pageRequest
	 *            分页实体信息
	 * @param request
	 *            HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public String view(PageRequest pageRequest, HttpServletRequest request) {
		return "channel/view";
	}

	/**
	 * 获取用户列表
	 * 
	 * @param pageRequest
	 *            分页实体信息
	 * @param request
	 *            HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("test")
	
	public @ResponseBody List<Menu> test(PageRequest pageRequest, HttpServletRequest request) {

		List<Channel> channels=channelmanager.getAllParentResources();
		//List<Channel> channels2=channelmanager.mergeChannelsToParent(channels);
		
		List<Menu> list=new ArrayList<Menu>();		
		Menu menu ; 	
		for(Channel channel:channels)
		{
			menu = 	new Menu(channel.getName());	
			
			if(null!=channel.getChildren() && channel.getChildren().size()>0)
			{
				List<Menu> children=new ArrayList<Menu>();
				for(Channel child:channel.getChildren())
				{
					children.add(new Menu(child.getName()));	
				}
				menu.setChildren(children);
			}
			list.add(menu);
			
		}
		
		
		
		
		/*menu.setText("一级栏目");		
		List<Menu> children=new ArrayList<Menu>();
		children.add(new Menu("一级栏目子栏目"));
		menu.setChildren(children);        
		list.add(menu);
		
		list.add(new Menu("二级栏目"));*/
		return list;
		// return "ddd";

		// return "channel/view";
	}

}
