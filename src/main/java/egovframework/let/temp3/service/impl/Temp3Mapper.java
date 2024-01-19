package egovframework.let.temp3.service.impl;

import java.util.List;


import egovframework.let.temp3.service.Temp3VO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;



// TempMapper.java를 impl 패키지 않에 넣는 이유는 context-mapper에서 
// <property name="basePackage" value="egovframework.**.service.impl" /> basePackage를 impl로 지정했기 때문이다.

@Mapper("temp3Mapper")
public interface Temp3Mapper {
	
	//임시데이터 가져오기
	public Temp3VO selectTemp(Temp3VO vo) throws Exception;
	
	//임시데이터 목록 가져오기
	List<EgovMap> selectTempList(Temp3VO vo) throws Exception;
	
	//임시데이터 목록수
	int selectTempListCnt(Temp3VO vo)throws Exception;
	
	//임시데이터 등록
	void insertTemp(Temp3VO vo) throws Exception;
	
	//임시데이터 수정하기
	void updateTemp(Temp3VO vo) throws Exception;
	
	//임시데이터 삭제하기
	void deleteTemp(Temp3VO vo) throws Exception;
	
	
}

