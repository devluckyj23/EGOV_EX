package egovframework.let.temp.service.impl;

import java.util.List;

import egovframework.let.temp.service.TempVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;



// TempMapper.java를 impl 패키지 않에 넣는 이유는 context-mapper에서 
// <property name="basePackage" value="egovframework.**.service.impl" /> basePackage를 impl로 지정했기 때문이다.

@Mapper("tempMapper")
public interface TempMapper {
	
	
	public TempVO selectTemp(TempVO vo) throws Exception;
	// TempDAO.selectTemp 고유값이다. 하지만 mapper만 겹치지 않으면 된다.
	
	//임시 데이터 목록 가져오기
	List<EgovMap> selectTempList(TempVO vo) throws Exception;
	
	//임시데이터등록
	 void insertTemp(TempVO vo) throws Exception;
	 //임시데이터 수정하기
	 void updateTemp(TempVO vo)throws Exception;
	 //임시데이터 삭제하기
	 public void deleteTemp(TempVO vo)throws Exception;
	
}

