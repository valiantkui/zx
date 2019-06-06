package yan.zx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yan.zx.dao.ParticipateDao;
import yan.zx.dao.TopicDao;
import yan.zx.dao.UserDao;
import yan.zx.entity.Participate;
import yan.zx.entity.Topic;
import yan.zx.entity.TopicInfo;
import yan.zx.entity.User;

@Controller
@RequestMapping("topic")
public class TopicController {
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ParticipateDao participateDao;

	@RequestMapping(value="/publishTopic",produces="application/json;charset=utf-8")
	public boolean publishTopic(String name,String date,String intro,String address,HttpSession session) {
		String u_id = (String)session.getAttribute("u_id");
		Topic topic = new Topic();
		topic.setName(name);
		topic.setDate(date);
		topic.setAddress(address);
		topic.setIntro(intro);
		topic.setU_id(u_id);
		return topicDao.addTopic(topic)>0?true:false;
	}
	
	/**
	 * 查找用户所发布的话题
	 * @param u_id
	 * @return
	 */
	@RequestMapping(value="/findTopicListByU_id",produces="application/json;charset=utf-8")
	public List<Topic> findTopicListByU_id(String u_id){
		return topicDao.findTopicListByU_id(u_id);
	}
	
	/**
	 * 查找用户所参加的选题
	 * @param u_id
	 * @return
	 */
	@RequestMapping(value="/findJoinTopicListByU_id",produces="application/json;charset=utf-8")
	public List<Topic> findJoinTopicListByU_id(String u_id){
		List<Participate> participateList = participateDao.findParticipateListByU_id(u_id);
		List<Integer> t_noList = new ArrayList<Integer>();
		for(Participate p: participateList) t_noList.add(p.getT_no());
		
		return topicDao.findTopicListByT_noList(t_noList);
		
		
	}
	
	@RequestMapping(value="/findTopicInfoByT_no",produces="application/json;charset=utf-8")
	public TopicInfo findTopicInfoByT_no(int t_no){
		List<Participate> participateList = participateDao.findParticipateListByT_no(t_no);
		List<String> u_idList = new ArrayList<String>();
		for(Participate p: participateList) {
			u_idList.add(p.getU_id());
		}
		
		Topic topic = topicDao.findTopicByT_no(t_no);
		
		TopicInfo topicInfo = new TopicInfo();
		
		List<User> userList = userDao.findUserListByU_idList(u_idList);
		
		topicInfo.setTopic(topic);
		topicInfo.setUserList(userList);
		
		return topicInfo;
	}
}
