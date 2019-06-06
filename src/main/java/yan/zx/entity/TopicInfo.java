package yan.zx.entity;

import java.util.List;

/**
 * 话题的详情，包含该话题的参与用户信息
 * @author 52822
 *
 */
public class TopicInfo {

	private Topic topic;
	private List<User> userList;
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "TopicInfo [topic=" + topic + ", userList=" + userList + "]";
	}
	
	
}
