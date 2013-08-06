package com.yijava.admin.dao.channel;

import org.springframework.stereotype.Repository;

import com.yijava.admin.entity.channel.Channel;
import com.yijava.orm.core.hibernate.support.HibernateSupportDao;

@Repository
public class ChannelDao extends HibernateSupportDao<Channel, String> {

}
