package cn.bdqn.itripdao.devuser;


import cn.bdqn.itripbeans.pojo.devuser.DevUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {
	/**
	 * 通过userCode获取User
	 *
	 * @param devCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getLoginUser(@Param("devCode") String devCode)throws Exception;

	public int addDecUser(DevUser devUser);
}
