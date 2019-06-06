package yan.zx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import yan.zx.entity.Participate;

@Repository
public interface ParticipateDao {

	public List<Participate> findParticipateListByU_id(String u_id);
	public List<Participate> findParticipateListByT_no(int  t_no);
	
}
