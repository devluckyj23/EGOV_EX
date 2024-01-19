package egovframework.let.temp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.let.temp3.service.Temp3VO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("tempService")
public class TempServiceImpl extends EgovAbstractServiceImpl implements TempService{

//	@Resource(name="tempDAO")
//	private TempDAO tempDAO;
//	
//	public TempVO selectTemp(TempVO vo) throws Exception{
//		return tempDAO.selectTemp(vo);
//	}
	
	@Resource(name="tempMapper")
	private TempMapper tempMapper;
	
	@Resource(name="temp2Mapper")
	private Temp2Mapper temp2Mapper;
	
	@Resource(name="egovTempIdGnrService")
	private EgovIdGnrService idgenService;
	
//  ===TempMapper=== 	
//	public TempVO selectTemp(TempVO vo) throws Exception{
//		return tempMapper.selectTemp(vo);
//	}
//
//	//임시데이터 목록 가져오기
//	public List<EgovMap> selectTempList(TempVO vo) throws Exception {
//		return tempMapper.selectTempList(vo);
//	}
//
//	//임시데이터 등록하기
//	public String insertTemp(TempVO vo) throws Exception{
//		  tempMapper.insertTemp(vo);
//		 return null;
//	}
//	//임시데이터 수정하기
//	@Override
//	public void updateTemp(TempVO vo) throws Exception {
//		 tempMapper.updateTemp(vo);	
//	}
//
//	@Override
//	public void deleteTemp(TempVO vo) throws Exception {
//		tempMapper.deleteTemp(vo);
//		
//	}
	
	
// ===Temp2Mapper===	
	public TempVO selectTemp(TempVO vo) throws Exception{
		return temp2Mapper.selectTemp(vo);
	}
	
	//임시데이터 목록 가져오기
	public List<EgovMap> selectTempList(TempVO vo) throws Exception {
		return temp2Mapper.selectTempList(vo);
	}
	
	
	
	
	//임시데이터 등록하기
	public String insertTemp(TempVO vo) throws Exception{
//	idgenService를 불러쓰고, StringId로 받는데, id라는 변수로 받을거고 pk값을 inserTemp로 보내준다.
		String id =idgenService.getNextStringId();
		vo.setTempId(id);
		
		temp2Mapper.insertTemp(vo);
		return id;
	}
	//임시데이터 수정하기
	@Override
	public void updateTemp(TempVO vo) throws Exception {
		temp2Mapper.updateTemp(vo);	
	}
	
	@Override
	public void deleteTemp(TempVO vo) throws Exception {
		temp2Mapper.deleteTemp(vo);
		
	}


	
	
}
