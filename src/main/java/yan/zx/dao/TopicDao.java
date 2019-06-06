package yan.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yan.zx.entity.Topic;

@Repository
public interface TopicDao {

	public int addTopic(Topic topic);
	
	public Topic findTopicByT_no(int t_no);

	public List<Topic> findTopicListByU_id(String u_id);

	public List<Topic> findTopicListByT_noList(@Param("t_noList") List<Integer> t_noList);
}
