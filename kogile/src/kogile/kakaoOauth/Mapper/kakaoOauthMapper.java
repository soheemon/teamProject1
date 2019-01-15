package kogile.kakaoOauth.Mapper;

import kogile.module.ExterMember;

public interface kakaoOauthMapper {
	
	int insertExterMember(ExterMember member);
	ExterMember selectExterMember(int interlinked_info);
}
